package inflearnbasicjava.string.string03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(main.solution(str));
    }

    public String solution(String str) {
        String answer = "";

        String[] temp = str.split(" ");
        for (String x : temp) {
            if (x.length() > answer.length()) {
                answer = x;
            }
        }

        return answer;
    }

    public String teacherSolution(String str) {
        String answer = "";

        int m = Integer.MIN_VALUE, pos;

        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }

        if (str.length() > m) {
            answer = str;
        }

        return answer;
    }
}
