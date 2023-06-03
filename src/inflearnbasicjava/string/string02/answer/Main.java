package inflearnbasicjava.string.string02.answer;

import java.util.Scanner;

/**
 * Character 클래서 사용해도 되지만 ASCII 코드로도 해결 가능 영대문자 : 65 ~ 90 영소문자 : 97 ~ 122 a는 97, A는 65 a -> A하기 위해서는
 * 97 - 32 -> 65
 */

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(main.solution(str));
    }

    public String solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (x >= 97 && x <= 122) {
                answer += (char) (x - 32);
            } else {
                answer += (char) (x + 32);
            }
        }

        return answer;
    }
}
