package BOJ.solved.BOJ1546;

import java.util.Scanner;

public class BOJ1546MySolve {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalSubjectCount = sc.nextInt();
        sc.nextLine(); // 개행문자 \n 을 버퍼에서 비워주기 위해 호출
        String scoreLine = sc.nextLine();
        String[] eachSubjectScoreArr = scoreLine.split(" ");

        int maxScore = 0;
        double sum = 0;
        double avg = 0;

        for (String eachSubjectScore: eachSubjectScoreArr) {
            int intScore = Integer.valueOf(eachSubjectScore);
            if (maxScore < intScore) {
                maxScore = intScore;
            }
        }

        for (String eachSubjectScore: eachSubjectScoreArr) {
            double doubleScore = Double.valueOf(eachSubjectScore);
            sum += doubleScore / maxScore * 100;
        }

        avg = sum / totalSubjectCount;

        System.out.println(avg);
    }
}
