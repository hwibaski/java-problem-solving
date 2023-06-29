package inflearnbasicjava.stackqueue._07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        main.solution(s1, s2);
    }

    public void solution(String s1, String s2) {
        String answer = "NO";

        char[] target = s1.toCharArray();
        int p = 0;

        Queue<Character> queue = new LinkedList<>();

        for (char c : s2.toCharArray()) {
            queue.offer(c);
        }

        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            if (poll == target[p]) {
                p++;
            }

            if (p >= target.length) {
                answer = "YES";
                break;
            }
        }

        System.out.println(answer);
    }

    public void teacherSolution(String need, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();

        for (char x : need.toCharArray()) {
            queue.offer(x);
        }

        for (char x : plan.toCharArray()) {
            // x 가 필수과목이면
            if (queue.contains(x)) {
                // x 의 순서 검증
                if (x != queue.poll()) {
                    answer = "NO";
                    break;
                }
            }
        }

        // 들어야할 필수 과목이 남아있다면
        if (!queue.isEmpty()) {
            answer = "NO";
        }

        System.out.println(answer);

    }
}
