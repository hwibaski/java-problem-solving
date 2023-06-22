package inflearnbasicjava.stackqueue._01;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        main.solution(s);
    }

    public void solution(String s) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (!stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }

                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            answer = "NO";
        }

        System.out.println(answer);
    }
}
