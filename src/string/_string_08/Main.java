package string._string_08;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        main.solution(str);
    }

    // my solve
    public void solution(String str) {
        String answer = "";
        StringBuilder tmp = new StringBuilder();

        for (char x :str.toCharArray()) {
            if(Character.isAlphabetic(x)) {
                tmp.append(x);
            }
        }

        String a = tmp.toString();
        String b = tmp.reverse().toString();

        if (a.equalsIgnoreCase(b)) {
            answer = "YES";
        } else {
            answer = "NO";
        }

        System.out.println(answer);
    }

    public void solution2(String str) {
        String answer = "NO";
        /**
         * [^A-Z] : A ~ Z가 아닌 것들을 선택
         */
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equals(tmp)) {
            answer = "YES";
        }

        System.out.println(answer);
    }
}
