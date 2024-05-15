import java.util.Random;

// Assuming BinarySearchTree and MyHashTable classes:
public class Main {
    public static void main(String[] args) {
        // Testing BinarySearchTree class
        Binary_Search_Tree<Integer, String> tree = new Binary_Search_Tree<>();
        tree.add(1, "One");
        tree.add(2, "Two");
        tree.add(3, "Three");

        Iterable<Integer> keys = tree.iterator();
        for (Integer key : keys) {
            System.out.println("key is " + key + " and value is " + tree.get(key));
        }

        // Testing MyHashTable class
        My_Hash_Table<My_Testing_Class, ADS_Student> table = new My_Hash_Table<>();

        // Adding 10,000 random elements:
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            My_Testing_Class key = new My_Testing_Class(random.nextInt(1000)); // Create a random key
            ADS_Student value = new ADS_Student("Fahima" + i, 19 + (i % 5)); // Student value
            table.put(key, value);
        }

        // Retrieving a value using a specific key
        My_Testing_Class specificKey = new My_Testing_Class(123); // Example key
        ADS_Student retrievedValue = table.get(specificKey);
        if (retrievedValue != null) {
            System.out.println("Retrieved value: " + retrievedValue);
        } else {
            System.out.println("Value not found for key: " + specificKey);
        }
    }
}
