package inflearnbasicjava.stackqueue._02.readme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        main.solution(s);
    }

    public void solution(String s) {
        List<Character> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }

            if (c == ')') {
                stack.pop();
            }

            if (c != '(' && c != ')')
                if (stack.isEmpty()) {
                    list.add(c);
                }
        }

        for (Character character : list) {
            System.out.print(character);
        }
    }

    public void teacherSolution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(') {
                }
            } else {
                stack.push(x);
            }
        }

        for (Character character : stack) {
            System.out.print(character);
        }
    }
}
