package inflearnbasicjava.sortandsearch._04;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int cacheSize = sc.nextInt();
        int totalWorkCount = sc.nextInt();

        int[] works = new int[totalWorkCount];

        for (int i = 0; i < totalWorkCount; i++) {
            works[i] = sc.nextInt();
        }

        main.solution(cacheSize, totalWorkCount, works);
    }

    public void solution(int cacheSize, int totalWorkCount, int[] works) {
        LinkedList<Integer> list = new LinkedList<>();

        int idx = 0;
        while (totalWorkCount-- > 0) {
            int work = works[idx];
            if (list.size() < cacheSize) {
                if (list.contains(work)) {
                    int i = list.indexOf(work);
                    list.remove(i);
                    list.addFirst(work);
                } else {
                    list.addFirst(work);
                }
            } else {
                if (list.contains(work)) {
                    int i = list.indexOf(work);
                    list.remove(i);
                    list.addFirst(work);
                } else {
                    list.remove(list.size() - 1);
                    list.addFirst(work);
                }
            }

            idx++;
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    /**
     * 컬렉션 쓰지 않고 푸는 방법
     */
    public void teacherSolution(int cacheSize, int totalWorkCount, int[] works) {
        int[] cache = new int[cacheSize];
        for (int work : works) {
            int pos = -1;

            for (int i = 0; i < cacheSize; i++) {
                // 캐시에 해당 작업이 있는 경우, 적중한 캐시의 index 저장
                if (work == cache[i]) {
                    pos = i;
                }
            }

            // 캐시 미스일 경우
            if (pos == -1) {
                for (int i = cacheSize - 1; i >= 1; i--) {
                    // 캐시의 첫번째 인덱스를 제외한 나머지 인덱스 하나씩 배열의 밀어주기
                    // why? 가장 첫번째 인덱스는 새로운 요소가 들어가야하므로
                    cache[i] = cache[i - 1];
                }

            } else {
                // 캐시 히트인 경우
                // 캐시의 첫번째 인덱스를 제외한 나머지 인덱스 하나씩 밀어주기
                // 다만 캐시가 적중한 인덱스부터 앞으로 전진하면서 하나씩 밀어주기
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            
            cache[0] = work;
        }

        for (int i : cache) {
            System.out.print(i + " ");
        }
    }
}
