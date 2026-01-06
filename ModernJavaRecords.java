/**
 * Demonstrates Java Records (Java 14+)
 * Records provide a compact syntax for declaring classes that are transparent holders for shallowly immutable data.
 */

// Traditional class approach
class TraditionalStudent {
    private final String name;
    private final int age;
    private final String major;

    public TraditionalStudent(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMajor() { return major; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TraditionalStudent)) return false;
        TraditionalStudent that = (TraditionalStudent) o;
        return age == that.age && name.equals(that.name) && major.equals(that.major);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + major.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TraditionalStudent{name='" + name + "', age=" + age + ", major='" + major + "'}";
    }
}

// Modern Record approach - much more concise!
record Student(String name, int age, String major) {
    // Compact constructor for validation
    public Student {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    // Custom methods can be added
    public boolean isAdult() {
        return age >= 18;
    }
}

// Records can implement interfaces
interface Describable {
    String getDescription();
}

record Course(String code, String title, int credits) implements Describable {
    @Override
    public String getDescription() {
        return String.format("%s: %s (%d credits)", code, title, credits);
    }
}

public class ModernJavaRecords {
    public static void main(String[] args) {
        System.out.println("=== Java Records Demo ===\n");

        // Creating a record instance
        Student student1 = new Student("Harshal", 25, "Computer Science");
        Student student2 = new Student("Priya", 23, "Data Science");
        Student student3 = new Student("Harshal", 25, "Computer Science");

        System.out.println("Student 1: " + student1);
        System.out.println("Student 2: " + student2);

        // Accessing record components (automatic getters)
        System.out.println("\nStudent 1 Details:");
        System.out.println("Name: " + student1.name());
        System.out.println("Age: " + student1.age());
        System.out.println("Major: " + student1.major());
        System.out.println("Is Adult: " + student1.isAdult());

        // Automatic equals and hashCode
        System.out.println("\nEquality Check:");
        System.out.println("student1 equals student2: " + student1.equals(student2));
        System.out.println("student1 equals student3: " + student1.equals(student3));
        System.out.println("student1 hashCode: " + student1.hashCode());
        System.out.println("student3 hashCode: " + student3.hashCode());

        // Record implementing interface
        System.out.println("\n=== Course Record with Interface ===");
        Course course = new Course("CS101", "Introduction to Programming", 3);
        System.out.println(course.getDescription());

        System.out.println("\n=== Benefits of Records ===");
        System.out.println("✓ Immutable by default");
        System.out.println("✓ Automatic constructor, getters, equals(), hashCode(), toString()");
        System.out.println("✓ Concise syntax - no boilerplate code");
        System.out.println("✓ Perfect for DTOs and value objects");
    }
}
