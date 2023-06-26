package inflearnbasicjava.stackqueue._04;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        main.solution(s);
        main.teacherSolution(s);
    }


    // 오답 발생
    public void solution(String s) {
        Stack<Character> nums = new Stack<>();

        int answer = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                nums.push(c);
            } else {
                if (answer == -1) {
                    answer = Integer.parseInt(nums.pop().toString());
                }

                int target = Integer.parseInt(nums.pop().toString());
                if (c == '+') {
                    answer += target;
                }

                if (c == '-') {
                    answer -= target;
                }

                if (c == '*') {
                    answer *= target;
                }

                if (c == '/') {
                    answer /= target;
                }
            }

        }

        System.out.println(answer);
    }

    public void teacherSolution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();

                if (c == '+') {
                    stack.push(lt + rt);
                }

                if (c == '-') {
                    stack.push(lt - rt);
                }

                if (c == '*') {
                    stack.push(lt * rt);
                }

                if (c == '/') {
                    stack.push(lt / rt);
                }
            }
        }

        answer = stack.get(0);

        System.out.println(answer);
    }
}
