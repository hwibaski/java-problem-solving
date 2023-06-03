package inflearnbasicjava.string.string09;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        main.solution(str);
    }

    public void solution(String str) {
        StringBuilder tmp = new StringBuilder();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                tmp.append(x);
            }
        }

        int answer = Integer.parseInt(tmp.toString());
        System.out.println(answer);
    }

    public void teacherSolution(String str) {
        int answer = 0;
        for (char x : str.toCharArray()) {
            if (x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }

        System.out.println(answer);
    }
}
