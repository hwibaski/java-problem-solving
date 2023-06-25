package inflearnbasicjava.stackqueue._03;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }
        main.solution(n, arr, m, moves);
//        main.teacherSolution(arr, moves);
    }

    /**
     * 바구니 내에서 같은 숫자끼리 만났을 때 없어지는 로직 구현 못함
     */
    public void solution(int n, int[][] arr, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < m; i++) {
            int ip = 0;
            int jp = moves[i] - 1;

            while (arr[ip][jp] == 0) {
                if (ip == n - 1) {
                    break;
                }
                ip++;
            }

            int target = arr[ip][jp];
            if (target != 0) {
                arr[ip][jp] = 0;
                // stack이 비어있으면 peek() 시 exception 발생
                if (!stack.isEmpty() && target == stack.peek()) {
                    answer += 2;
                    stack.pop();
                } else {
                    stack.push(target);
                }
            }
        }

        System.out.println(answer);
    }

    public void teacherSolution(int[][] arr, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int pos : moves) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][pos - 1] != 0) {
                    int tmp = arr[i][pos - 1];
                    arr[i][pos - 1] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    public static void print(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
