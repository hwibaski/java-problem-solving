package inflearnbasicjava.stackqueue._08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        main.solution(n, m, arr);
    }

    // 못 풀었음
    public void solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int target = arr[m];
        int tmp = m;

        for (int i : arr) {
            q.offer(i);
        }

        while (tmp != 0) {
            int poll = q.poll();

            for (Integer integer : q) {
                if (poll < integer) {
                    q.offer(poll);
                    break;
                }
            }
            answer++;
        }

        for (Integer integer : q) {
            int p = q.poll();

        }

        System.out.println(answer + 1);
    }

    public void teacherSolution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new Person(i, arr[i]));
        }
        while (!q.isEmpty()) {
            Person tmp = q.poll();
            for (Person x : q) {
                if (x.priority > tmp.priority) {
                    q.offer(tmp);
                    tmp = null;
                    break;
                }

                if (tmp != null) {
                    answer++;
                    if (tmp.id == m) {
                        System.out.println(answer);
                    }
                }
            }
        }
    }

    static class Person {
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}


