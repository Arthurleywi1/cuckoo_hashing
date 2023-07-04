// import java.util.Arrays;

class CuckooHashTable {
    int size;
    String[] table1; 
    String[] table2;

    public CuckooHashTable(int size) {
        this.size = size;
        this.table1 = new String[size]; 
        // Arrays.fill(table1, null);
        this.table2 = new String[size];
        // Arrays.fill(table2, null);
    }

    public static void printArray(String[] array) { // print array
        StringBuilder sb = new StringBuilder(); // string builder
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                sb.append(array[i]); // append to string builder
            } else {
                sb.append("null"); 
            }
            if (i < array.length - 1) { 
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public int custom_hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += (int) key.charAt(i);
        }
        return hash % size;
    }

    public void insert(String key) {
        int location = custom_hash(key);
        if (table1[location] == null) {
            table1[location] = key;
        } else {
            location = custom_hash(key);
            if (table2[location] == null) {
                table2[location] = key;
            } else {
                String temp = table2[location];
                table2[location] = key;
                insert(temp);
            }
        }
    }

    public Integer search(String key) {
        int location = custom_hash(key);
        if (table1[location] != null && table1[location].equals(key)) { 
            return location; 
        } else {
            location = custom_hash(key);
            if (table2[location] != null && table2[location].equals(key)) {
                return location;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CuckooHashTable hash_table = new CuckooHashTable(10);
    
        hash_table.insert("grape");
        hash_table.insert("apple");
        hash_table.insert("banana");
        hash_table.insert("orange");
        hash_table.insert("kiwi");
    
        printArray(hash_table.table1);
        printArray(hash_table.table2);
    
        System.out.println(hash_table.search("grape"));
        System.out.println(hash_table.search("apple"));
        System.out.println(hash_table.search("banana"));
        System.out.println(hash_table.search("orange"));
        System.out.println(hash_table.search("kiwi"));
    
        printArray(hash_table.table1);
        printArray(hash_table.table2);
    }
    
}

