/**
 * Demonstrates Pattern Matching for instanceof (Java 16+)
 * Eliminates the need for explicit casting after instanceof checks
 */

// Shape hierarchy for demonstration
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private final double width;
    private final double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getWidth() {
        return width;
    }

    double getHeight() {
        return height;
    }

    @Override
    double area() {
        return width * height;
    }
}

class Triangle extends Shape {
    private final double base;
    private final double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double getBase() {
        return base;
    }

    double getHeight() {
        return height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }
}

public class ModernPatternMatching {
    
    // Old way: instanceof with explicit casting
    public static String describeShapeOldWay(Shape shape) {
        String description;
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape; // Explicit cast needed
            description = "Circle with radius: " + circle.getRadius();
        } else if (shape instanceof Rectangle) {
            Rectangle rect = (Rectangle) shape; // Explicit cast needed
            description = "Rectangle " + rect.getWidth() + "x" + rect.getHeight();
        } else if (shape instanceof Triangle) {
            Triangle tri = (Triangle) shape; // Explicit cast needed
            description = "Triangle with base: " + tri.getBase() + " and height: " + tri.getHeight();
        } else {
            description = "Unknown shape";
        }
        return description;
    }

    // Modern way: Pattern matching for instanceof
    public static String describeShapeModernWay(Shape shape) {
        String description;
        if (shape instanceof Circle c) { // No explicit cast needed!
            description = "Circle with radius: " + c.getRadius();
        } else if (shape instanceof Rectangle r) {
            description = "Rectangle " + r.getWidth() + "x" + r.getHeight();
        } else if (shape instanceof Triangle t) {
            description = "Triangle with base: " + t.getBase() + " and height: " + t.getHeight();
        } else {
            description = "Unknown shape";
        }
        return description;
    }

    // Pattern matching with logical operators
    public static boolean isLargeShape(Shape shape) {
        // Pattern variable can be used in the same expression
        return shape instanceof Circle c && c.getRadius() > 10 ||
               shape instanceof Rectangle r && r.getWidth() * r.getHeight() > 100;
    }

    // Null-safe pattern matching
    public static String safeDescribe(Object obj) {
        if (obj instanceof String s && !s.isEmpty()) {
            return "Non-empty string: " + s;
        } else if (obj instanceof Integer i && i > 0) {
            return "Positive integer: " + i;
        } else if (obj == null) {
            return "Null object";
        }
        return "Other type or empty";
    }

    public static void main(String[] args) {
        System.out.println("=== Pattern Matching for instanceof Demo ===\n");

        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        Shape triangle = new Triangle(3.0, 4.0);

        System.out.println("Old Way (with explicit casting):");
        System.out.println(describeShapeOldWay(circle));
        System.out.println(describeShapeOldWay(rectangle));
        System.out.println(describeShapeOldWay(triangle));

        System.out.println("\nModern Way (pattern matching):");
        System.out.println(describeShapeModernWay(circle));
        System.out.println(describeShapeModernWay(rectangle));
        System.out.println(describeShapeModernWay(triangle));

        System.out.println("\nPattern Matching with Logical Operators:");
        Shape largeCircle = new Circle(15.0);
        Shape smallCircle = new Circle(3.0);
        System.out.println("Large circle (radius 15): " + isLargeShape(largeCircle));
        System.out.println("Small circle (radius 3): " + isLargeShape(smallCircle));

        System.out.println("\nNull-Safe Pattern Matching:");
        System.out.println(safeDescribe("Hello Java"));
        System.out.println(safeDescribe(42));
        System.out.println(safeDescribe(-5));
        System.out.println(safeDescribe(null));
        System.out.println(safeDescribe(""));

        System.out.println("\n=== Benefits of Pattern Matching ===");
        System.out.println("✓ No need for explicit casting");
        System.out.println("✓ More concise and readable code");
        System.out.println("✓ Fewer errors from incorrect casts");
        System.out.println("✓ Pattern variables are scoped automatically");
    }
}
