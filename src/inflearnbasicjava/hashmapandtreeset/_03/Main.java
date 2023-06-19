package inflearnbasicjava.hashmapandtreeset._03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

    // 시간 초과
    public void solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
            answer.add(map.size());
        }

        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }
    }

    public void teacherSolution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());

            map.put(arr[lt], map.get(lt) - 1);
            
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
        }

        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }
    }
}
