import java.util.Objects;

public class ADS_Student {
    private String name;
    private int age;

    public ADS_Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ADS_Student that = (ADS_Student) obj;
        return age == that.age && Objects.equals(name, that.name);
    }
}
