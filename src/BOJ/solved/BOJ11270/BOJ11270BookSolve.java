package BOJ.solved.BOJ11270;

import java.util.Scanner;

public class BOJ11270BookSolve {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            // System.out.println(((Object)cNum[i]).getClass().getName());
            // System.out.println(((Object)(cNum[i] - '0')).getClass().getName());
            // cNum[i] - '0'을 해줘서 형변환을 일으킨다. character -> integer
            // cNum[i]가 5일 때 ascii 값이 53, '0'은 ascii 값이 48이므로 정수 연산 시
            // cNum[i] - '0'이 decimal 5가 된다..
            sum += cNum[i] - '0';
        }
        System.out.println(sum);
    }
}
