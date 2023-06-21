package inflearnbasicjava.hashmapandtreeset._05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        main.solution(n, k, arr);
    }

    public void solution(int n, int k, int[] arr) {
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int x = j + 1; x < n; x++) {
                    lists.add(arr[i] + arr[j] + arr[x]);
                }
            }
        }

        Collections.sort(lists, Collections.reverseOrder());

        for (Integer list : lists) {
            System.out.println(list);
        }
    }

    public void teacherSolution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int x = j + 1; x < n; x++) {
                    treeSet.add(arr[i] + arr[j] + arr[x]);
                }
            }
        }
        int cnt = 0;
        // treeSet.size(); - set의 사이즈
        // treeSet.remove(143); - 첫 번째 143을 찾아서 삭제
        // treeSet.first(); - set의 첫 번째 요소 리턴
        // treeSet.last(); - set의 마지막 요소 리턴

        for (int x : treeSet) {
            cnt++;
            if (cnt == 3) {
                answer = x;
                break;
            }
        }

        System.out.println(answer);
    }
}
