/**
 * Demonstrates Switch Expressions (Java 14+)
 * Switch expressions provide a more concise and safer alternative to traditional switch statements
 */

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum Season {
    SPRING, SUMMER, FALL, WINTER
}

public class ModernSwitchExpressions {

    // Old way: Traditional switch statement
    public static String getDayTypeOldWay(Day day) {
        String dayType;
        switch (day) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                dayType = "Weekday";
                break;
            case SATURDAY:
            case SUNDAY:
                dayType = "Weekend";
                break;
            default:
                throw new IllegalArgumentException("Invalid day");
        }
        return dayType;
    }

    // Modern way: Switch expression with arrow syntax
    public static String getDayTypeModernWay(Day day) {
        return switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
            case SATURDAY, SUNDAY -> "Weekend";
        };
    }

    // Switch expression with yield for complex logic
    public static String getSeasonDescription(Season season) {
        return switch (season) {
            case SPRING -> "Flowers bloom, temperature is mild";
            case SUMMER -> "Hot weather, perfect for beach";
            case FALL -> {
                String description = "Leaves fall, ";
                description += "temperature drops";
                yield description; // yield is used for returning values in block
            }
            case WINTER -> "Cold weather, time for skiing";
        };
    }

    // Switch expression returning different types
    public static int getWorkingDays(Day startDay) {
        return switch (startDay) {
            case MONDAY -> 5;
            case TUESDAY -> 4;
            case WEDNESDAY -> 3;
            case THURSDAY -> 2;
            case FRIDAY -> 1;
            case SATURDAY, SUNDAY -> 0;
        };
    }

    // Switch with type checking (using instanceof)
    public static String formatValue(Object obj) {
        if (obj instanceof Integer) {
            return String.format("Integer: %d", (Integer) obj);
        } else if (obj instanceof String) {
            return String.format("String: %s", (String) obj);
        } else if (obj instanceof Double) {
            return String.format("Double: %.2f", (Double) obj);
        } else if (obj == null) {
            return "Null value";
        } else {
            return "Unknown type: " + obj.getClass().getSimpleName();
        }
    }

    // Categorize numbers with conditions
    public static String categorizeNumber(Object obj) {
        if (obj instanceof Integer) {
            int i = (Integer) obj;
            if (i > 0) return "Positive integer: " + i;
            if (i < 0) return "Negative integer: " + i;
            return "Zero";
        } else if (obj instanceof Double) {
            double d = (Double) obj;
            if (d > 0.0) return "Positive double: " + d;
            if (d < 0.0) return "Negative double: " + d;
            return "Zero double";
        } else if (obj == null) {
            return "Null value";
        }
        return "Not a number";
    }

    public static void main(String[] args) {
        System.out.println("=== Switch Expressions Demo ===\n");

        // Basic switch expression
        System.out.println("Day Type Classification:");
        for (Day day : Day.values()) {
            System.out.println(day + " is a " + getDayTypeModernWay(day));
        }

        // Switch with yield
        System.out.println("\nSeason Descriptions:");
        for (Season season : Season.values()) {
            System.out.println(season + ": " + getSeasonDescription(season));
        }

        // Switch returning integers
        System.out.println("\nWorking Days Remaining:");
        System.out.println("Starting Monday: " + getWorkingDays(Day.MONDAY) + " days");
        System.out.println("Starting Wednesday: " + getWorkingDays(Day.WEDNESDAY) + " days");
        System.out.println("Starting Saturday: " + getWorkingDays(Day.SATURDAY) + " days");

        // Type-based switching
        System.out.println("\nType-Based Switching:");
        System.out.println(formatValue(42));
        System.out.println(formatValue("Hello Java"));
        System.out.println(formatValue(3.14159));
        System.out.println(formatValue(null));
        System.out.println(formatValue(true));

        // Categorizing numbers
        System.out.println("\nCategorizing Numbers:");
        System.out.println(categorizeNumber(10));
        System.out.println(categorizeNumber(-5));
        System.out.println(categorizeNumber(0));
        System.out.println(categorizeNumber(3.14));
        System.out.println(categorizeNumber(-2.5));
        System.out.println(categorizeNumber("not a number"));

        // Comparison: Old vs New
        System.out.println("\nComparison Old vs New:");
        Day testDay = Day.FRIDAY;
        System.out.println("Old way: " + getDayTypeOldWay(testDay));
        System.out.println("New way: " + getDayTypeModernWay(testDay));

        System.out.println("\n=== Benefits of Switch Expressions ===");
        System.out.println("✓ No fall-through errors (no missing breaks)");
        System.out.println("✓ Can be used as expressions (return values directly)");
        System.out.println("✓ Exhaustiveness checking by compiler");
        System.out.println("✓ Arrow syntax is more concise");
        System.out.println("✓ Multiple case labels in single line");
    }
}
