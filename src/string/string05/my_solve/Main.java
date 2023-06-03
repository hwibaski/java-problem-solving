package string.string05.my_solve;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(main.solution(str));
    }

    public String solution(String str) {
        char[] s = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            char tmp = s[lt];
            if (Character.isAlphabetic(s[lt]) && Character.isAlphabetic(s[rt])) {
                s[lt] = s[rt];
                s[rt] = tmp;
            }
            lt++;
            rt--;
        }

        return String.valueOf(s);
    }

}
