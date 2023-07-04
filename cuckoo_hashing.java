import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class cuckoo_hashing {
    private int size; // size of hash table
    private List<String> table; // hash table
 
    public cuckoo_hashing(int size) {
        this.size = size; 
        this.table = new ArrayList<String>(size); // initialize hash table
        for (int i = 0; i < size; i++) {
            this.table.add(null);
        }
    }

    private int _hash1(String key) { 
        return Math.abs(key.hashCode() % this.size); // return hash value
    }

    private int _hash2(String key) {
        Random rand = new Random();
        int randNum = Math.abs(rand.nextInt(this.size));
        return (Math.abs(key.hashCode()) + randNum) % this.size; 
    }

    public void insert(String key) {
        for (int i = 0; i < this.size; i++) {
            int index1 = _hash1(key); // index of first hash
            int index2 = _hash2(key); // index of second hash
            if (this.table.get(index1) == null) {
                this.table.set(index1, key); // insert key at index1
                return; 
            } else if (this.table.get(index2) == null) {  
                this.table.set(index2, key); // insert key at index2
                return; 
            } else {
                String temp = this.table.get(index1); // swap key with key at index1
                this.table.set(index1, key);
                key = temp;
            }
        }
        throw new RuntimeException("Hash table is full");
    }

    public boolean search(String key) {
        int index1 = _hash1(key);
        int index2 = _hash2(key); 
        return this.table.get(index1) != null &&  
        this.table.get(index1).equals(key) || this.table.get(index2) != null // search key at index1 and index2
        && this.table.get(index2).equals(key);
    }

    public static void main(String[] args) {
        cuckoo_hashing hashTable = new cuckoo_hashing(10); // initialize hash table
        hashTable.insert("apple");
        hashTable.insert("banana"); 

        System.out.println(hashTable.search("apple"));  // prints true
        System.out.println(hashTable.search("orange"));  // prints false
    }
}
