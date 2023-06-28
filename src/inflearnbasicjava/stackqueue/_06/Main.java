package inflearnbasicjava.stackqueue._06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        main.solution(n, k);
    }

    public void solution(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        while (list.size() > 1) {
            if (idx == list.size()) {
                idx = 0;
            }

            int el = list.get(idx++);
            stack.push(el);
            if (stack.size() == k) {
                stack.removeAllElements();

                Integer removedIdx = list.remove(idx);

                if (removedIdx >= list.size()) {
                    idx = removedIdx - 1;
                } else {
                    idx = 0;
                }
            }
        }


        System.out.println(list.get(0));

    }

    public void teacherSolution(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while (!q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }

            q.poll();
            if (q.size() == 1) {
                answer = q.poll();
            }
        }

        System.out.println(answer);
    }
}
