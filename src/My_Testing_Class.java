public class My_Testing_Class {
    private int value;

    public My_Testing_Class(int value) {
        this.value = value;
    }

    // Custom hashCode method
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + value; // Use a prime number multiplier for better distribution
        return hash;
    }}