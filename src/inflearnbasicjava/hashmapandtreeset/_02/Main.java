package inflearnbasicjava.hashmapandtreeset._02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        main.solution(s1, s2);
    }

    public void solution(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char x : s1.toCharArray()) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }

        for (char x : s2.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        if (map1.size() != map2.size()) {
            System.out.println("NO");
            return;
        }

        for (char x : s1.toCharArray()) {
            int cnt1 = map2.get(x);
            int cnt2 = map1.get(x);

            if (cnt1 != cnt2) {
                System.out.println("NO");
                return;
            }
        }

        for (char x : s2.toCharArray()) {
            int cnt1 = map2.get(x);
            int cnt2 = map1.get(x);

            if (cnt1 != cnt2) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public void teacherSolution(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : s2.toCharArray()) {
            // x라는 키가 존재하지 않거나 x키의 값이 0일 때
            if (!map.containsKey(x) || map.get(x) == 0) {
                answer = "NO";
                break;
            }

            map.put(x, map.get(x) - 1);
        }

        System.out.println(answer);
    }
}
