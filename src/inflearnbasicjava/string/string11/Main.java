package inflearnbasicjava.string.string11;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        main.solution(s);
    }

    public void solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

        for (char x : s.toCharArray()) {
            if (map.containsKey(x)) {
                Integer integer = map.get(x);
                map.put(x, ++integer);
            } else {
                map.put(x, 1);
            }
        }

        map.forEach((key, value) -> {
            if (value == 1) {
                stringBuilder.append(key);
            } else {
                stringBuilder.append(key);
                stringBuilder.append(value);
            }
        });

        String answer = stringBuilder.toString();
        System.out.println(answer);
    }

    public void teacherSolution(String s) {
        String answer = "";
        s = s + " ";
        int cnt = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                answer += s.charAt(i);
                if (cnt > 1) {
                    answer += String.valueOf(cnt);
                    cnt = 1;
                }
            }
        }

        System.out.println(answer);
    }
}
