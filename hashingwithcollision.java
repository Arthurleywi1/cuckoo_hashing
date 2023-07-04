import java.util.ArrayList;
import java.util.List;

public class hashingwithcollision { 

    public static void printCollisions(List<List<String>> hashTable) { 
        for (int i = 0; i < hashTable.size(); i++) { // iterate through the hash table
            List<String> basket = hashTable.get(i); // get the basket at index i 
            if (basket.size() > 1) { // if the basket has more than one item, there is a collision
                System.out.println("Collision index " + i + ": " + basket); 
            }
        }
    }

    public static void main(String[] args) { 
        List<List<String>> hashTable = new ArrayList<List<String>>(); // create a hash table
        for (int i = 0; i < 10; i++) { // add 10 baskets to the hash table
            hashTable.add(new ArrayList<String>()); // each basket is an empty list
        } 

        hashTable.get(3).add("grape");
        hashTable.get(4).add("apple");
        hashTable.get(4).add("banana");
        hashTable.get(5).add("orange");
        hashTable.get(5).add("kiwi");

        printCollisions(hashTable);
    }
}
