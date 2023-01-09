package string._string_06.my_solve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * fail
 * temp.contains()에서 각 char를 String.valueOf()로 새로운 객체로 생성해서 넣기 때문에
 * 예상과 같이 contains가 동작하지 않음
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        main.solution(str);
    }

    public void solution(String str) {
        System.out.println(str);
        List<String> temp = new ArrayList<String>();
        char[] chars = str.toCharArray();

        for(char x : chars) {
            if (!temp.contains(x)) {
                temp.add(String.valueOf(x));
            }
        }

        System.out.println(temp);
        System.out.println(String.join(",", temp));
    }

}
