package datastructure.hashtable;

// 출처 : https://www.youtube.com/watch?v=Vi0hauJemxA&list=PLjSkJdbr_gFaPf3ojJFZYXXA__8zcUpdZ
public class Main {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(3);
        hashTable.put("a", "1");
        hashTable.put("b", "2");
        hashTable.put("c", "3");
        hashTable.put("c", "10");
        System.out.println("hashTable = " + hashTable.get("c"));
    }
}
