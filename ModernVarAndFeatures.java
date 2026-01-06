/**
 * Demonstrates var keyword and other modern Java features (Java 10+)
 * var provides local variable type inference for cleaner, more readable code
 */

import java.util.*;
import java.util.stream.*;

public class ModernVarAndFeatures {

    public static void main(String[] args) {
        System.out.println("=== var Keyword and Modern Features Demo ===\n");

        // Basic var usage
        System.out.println("1. Basic var Usage:");
        var message = "Hello, Modern Java!"; // String inferred
        var number = 42; // int inferred
        var price = 99.99; // double inferred
        var isActive = true; // boolean inferred

        System.out.println("Message: " + message + " (Type: String)");
        System.out.println("Number: " + number + " (Type: int)");
        System.out.println("Price: " + price + " (Type: double)");
        System.out.println("IsActive: " + isActive + " (Type: boolean)");

        // var with collections
        System.out.println("\n2. var with Collections:");
        var names = new ArrayList<String>(); // ArrayList<String> inferred
        names.add("Harshal");
        names.add("Priya");
        names.add("Amit");
        System.out.println("Names: " + names);

        var scores = Map.of("Math", 95, "Science", 88, "English", 92);
        System.out.println("Scores: " + scores);

        // var in loops
        System.out.println("\n3. var in Loops:");
        for (var name : names) {
            System.out.println("Hello, " + name);
        }

        var numbers = List.of(1, 2, 3, 4, 5);
        for (var i = 0; i < numbers.size(); i++) {
            System.out.println("Number at index " + i + ": " + numbers.get(i));
        }

        // var with streams
        System.out.println("\n4. var with Streams:");
        var evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Diamond operator improvement (Java 9+)
        System.out.println("\n5. Diamond Operator with Anonymous Classes:");
        var list = new ArrayList<String>() {
            {
                add("Item 1");
                add("Item 2");
            }
        };
        System.out.println("Anonymous list: " + list);

        // Try-with-resources improvements (Java 9+)
        System.out.println("\n6. Modern Try-with-Resources:");
        var resource = "Resource content";
        // Effectively final variables can be used directly
        System.out.println("Processing: " + resource);

        // Collection factory methods (Java 9+)
        System.out.println("\n7. Collection Factory Methods:");
        var immutableList = List.of("Apple", "Banana", "Cherry");
        var immutableSet = Set.of(1, 2, 3, 4, 5);
        var immutableMap = Map.of(
                "name", "Harshal",
                "age", "25",
                "city", "Pune"
        );

        System.out.println("Immutable List: " + immutableList);
        System.out.println("Immutable Set: " + immutableSet);
        System.out.println("Immutable Map: " + immutableMap);

        // Stream API enhancements (Java 9+)
        System.out.println("\n8. Stream API Enhancements:");

        // takeWhile - takes elements while condition is true
        var numbersStream = Stream.of(2, 4, 6, 8, 7, 10, 12);
        var takenWhileEven = numbersStream
                .takeWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("takeWhile (even): " + takenWhileEven);

        // dropWhile - drops elements while condition is true
        var numbersStream2 = Stream.of(2, 4, 6, 8, 7, 10, 12);
        var droppedWhileEven = numbersStream2
                .dropWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("dropWhile (even): " + droppedWhileEven);

        // iterate with predicate
        var limitedSequence = Stream.iterate(0, n -> n < 10, n -> n + 2)
                .collect(Collectors.toList());
        System.out.println("Limited sequence: " + limitedSequence);

        // Optional improvements
        System.out.println("\n9. Optional Enhancements:");
        var optional = Optional.of("Hello");
        
        // ifPresentOrElse (Java 9+)
        optional.ifPresentOrElse(
                value -> System.out.println("Value present: " + value),
                () -> System.out.println("Value absent")
        );

        // or() method (Java 9+)
        var emptyOptional = Optional.<String>empty();
        var result = emptyOptional.or(() -> Optional.of("Default Value"));
        System.out.println("Optional result: " + result.get());

        // String methods enhancements (Java 11+)
        System.out.println("\n10. String Enhancements:");
        var text = "  Hello Java  ";
        System.out.println("Original: '" + text + "'");
        System.out.println("strip(): '" + text.strip() + "'");
        System.out.println("isBlank(): " + text.isBlank());
        System.out.println("lines count: " + "Line1\nLine2\nLine3".lines().count());

        var repeatedText = "Java ".repeat(3);
        System.out.println("repeat(3): " + repeatedText);

        // Local variable syntax for lambda parameters (Java 11+)
        System.out.println("\n11. var in Lambda Parameters:");
        var upperCaseNames = names.stream()
                .map((var name) -> name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Uppercase names: " + upperCaseNames);

        // Teeing Collector (Java 12+)
        System.out.println("\n12. Teeing Collector:");
        var stats = numbers.stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(Integer::intValue),
                        Collectors.counting(),
                        (sum, count) -> "Sum: " + sum + ", Count: " + count
                ));
        System.out.println("Statistics: " + stats);

        System.out.println("\n=== Benefits of Modern Java Features ===");
        System.out.println("✓ var reduces boilerplate, improves readability");
        System.out.println("✓ Collection factory methods create immutable collections easily");
        System.out.println("✓ Enhanced Stream API with takeWhile, dropWhile, iterate");
        System.out.println("✓ Improved Optional with ifPresentOrElse, or, stream");
        System.out.println("✓ String enhancements: strip, isBlank, lines, repeat");
        System.out.println("✓ More expressive and concise code overall");
    }
}
