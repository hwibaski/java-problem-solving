package inflearnbasicjava.hashmapandtreeset._01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String string = sc.next();

        main.solution(n, string);
    }

    public void solution(int n, String string) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.toCharArray().length; i++) {
            map.put(string.charAt(i), map.get(string.charAt(i)) == null ? 0 : map.get(string.charAt(i)) + 1);
        }

        char answer = 0;
        int max = 0;
        for (Character key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        System.out.println(answer);
    }

    public void teacherSolution(int n, String s) {
        char answer = ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char x : map.keySet()) {
            if (map.get(x) > max) {
                max = map.get(x);
                answer = x;
            }
        }

        System.out.println(answer);
    }
}
