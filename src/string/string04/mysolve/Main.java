package string.string04.mysolve;

import java.util.Scanner;

/**
 * https://sundries-in-myidea.tistory.com/139 String을 + 연산하게되면 어떻게 되는지 공부 String은 immutable하기 때문에 +
 * 연산 시 새로운 메모리를 계속 사용하게 된다.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            strings[i] = str;
        }
        main.solution(strings);
    }

    public void solution(String[] str) {
        String answer = "";

        for (String el : str) {
            for (int i = el.length() - 1; i >= 0; i--) {
                answer += el.charAt(i);
            }
            System.out.println(answer);
            answer = "";
        }
    }
}
