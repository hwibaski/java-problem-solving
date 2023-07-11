package inflearnbasicjava.sortandsearch._07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Point implements Comparable<Point> {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point point = new Point(x, y);
            list.add(point);
        }


        main.teacherSolution(list);
    }

//    public void solution(int n, int[][] arr) {
//        for (int i = 0; i < n - 1; i++) {
//            if (arr[i][0] > arr[i + 1][0]) {
//                int[] tmp = arr[i + 1];
//                arr[i + 1] = arr[i];
//                arr[i] = tmp;
//            }
//        }
//
//        for (int i = 0; i < n - 1; i++) {
//            if (arr[i][0] == arr[i + 1][0]) {
//                if (arr[i][1] > arr[i + 1][1]) {
//                    int[] tmp = arr[i + 1];
//                    arr[i + 1] = arr[i];
//                    arr[i] = tmp;
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.println(arr[i][0] + " " + arr[i][1]);
//        }
//    }

    public void teacherSolution(List<Point> list) {
        Collections.sort(list);
        for (Point point : list) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
