package BOJ.BOJ11270;

import java.util.Scanner;

public class BOJ11270MySolve {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalCountOfNum = sc.nextInt();
        String num = sc.next();

        String[] strArray = num.split("");
        int[] intArray = new int[totalCountOfNum];
        int sum = 0;

        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

        for (int i = 0; i < totalCountOfNum; i++) {
            sum += intArray[i];
        }

        System.out.println(sum);
    }
}