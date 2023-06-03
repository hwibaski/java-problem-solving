package inflearnbasicjava.string.string07;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        main.solution(str);
    }

    public void solution(String str) {
        String answer = "";
        String reversed = new StringBuilder(str).reverse().toString().toLowerCase();

        if (reversed.equals(str.toLowerCase())) {
            answer = "YES";
        } else {
            answer = "NO";
        }

        System.out.println(answer);
    }
}
