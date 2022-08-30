
## BufferReader 설명
https://st-lab.tistory.com/41

## StringTokenizer 설명
https://jhnyang.tistory.com/398
```java
// delimeter를 따로 지정해주지 않을 경우, 띄어쓰기를 기준으로 tokenizer가 진행된다.
new StringTokenizer(str);
```

## 소스코드를 이용해 BufferReader, StringTokenizer 값 확인
```text
입력 예시
5 3
5 4 3 2 1
1 3
2 4
1 2
```

```java
public class BOJ11659BookSolve {
    public static void main(String[] args) throws IOException { // bufferReader.readLine() 메서드가 예외를 던질 수도 있다.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //bufferedReader.readLine()에서 입력 5 3 을 받는다.
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // stringTokenizer.nextToken()에서 5를 꺼낸 후 int형으로 변환 후 suNo에 할당
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        
        // stringTokenizer.nextToken()에서 3를 꺼낸 후 int형으로 변환 후 quizNo에 할당
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        
        long[] S = new long[suNo + 1];
        // bufferReader.readLine()에서 5 4 3 2 1을 받고 StringTokenizer로 전달
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i = 1; i <= suNo; i++) {
            // stringTokenizer.nextToken()에서 5, 4, 3, 2, 1 을 순차적으로 꺼낸다.
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        //quizNo만큼 해당 작업 진행, 주석은 입력의 1 3 까지 부분만 설명, 마지막 줄인 1 2 입력을 받는다. 
        for (int q = 0; q < quizNo; q++) {
            // bufferedReader.readLine()에서 1 3 을 받고 StringTokenizer에 전달
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            // stringTokenizer.nextToken()에서 1을 꺼낸다.
            int i = Integer.parseInt(stringTokenizer.nextToken());
            // stringTokenizer.nextToken()에서 1을 꺼낸다.
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }
    }
}

```

## 합배열 구하기
![이름 없는 노트북-3.jpg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5748365f-bc4b-4719-ae39-bf672fa76ff3/%E1%84%8B%E1%85%B5%E1%84%85%E1%85%B3%E1%86%B7_%E1%84%8B%E1%85%A5%E1%86%B9%E1%84%82%E1%85%B3%E1%86%AB_%E1%84%82%E1%85%A9%E1%84%90%E1%85%B3%E1%84%87%E1%85%AE%E1%86%A8-3.jpg)
![이름 없는 노트북-3.jpg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5748365f-bc4b-4719-ae39-bf672fa76ff3/%E1%84%8B%E1%85%B5%E1%84%85%E1%85%B3%E1%86%B7_%E1%84%8B%E1%85%A5%E1%86%B9%E1%84%82%E1%85%B3%E1%86%AB_%E1%84%82%E1%85%A9%E1%84%90%E1%85%B3%E1%84%87%E1%85%AE%E1%86%A8-3.jpg)

