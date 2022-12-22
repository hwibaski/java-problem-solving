package string._string_03.mysolve;

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
        for(String x : temp) {
            if(x.length() > answer.length())  {
                answer = x;
            }
        }

        return answer;
    }
}
