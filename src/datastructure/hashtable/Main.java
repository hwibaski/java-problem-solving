package datastructure.hashtable;

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
