/**
 * Demonstrates Text Blocks (Java 15+)
 * Text blocks provide a clear, readable way to write multi-line strings
 */

public class ModernTextBlocks {
    public static void main(String[] args) {
        System.out.println("=== Java Text Blocks Demo ===\n");

        // Old way: String concatenation (messy and hard to read)
        String oldJson = "{\n" +
                "  \"name\": \"Harshal\",\n" +
                "  \"age\": 25,\n" +
                "  \"skills\": [\"Java\", \"Python\", \"JavaScript\"]\n" +
                "}";

        System.out.println("Old JSON formatting (with escape sequences):");
        System.out.println(oldJson);

        // Modern way: Text blocks
        String modernJson = """
                {
                  "name": "Harshal",
                  "age": 25,
                  "skills": ["Java", "Python", "JavaScript"]
                }
                """;

        System.out.println("\nModern Text Block JSON:");
        System.out.println(modernJson);

        // SQL query example
        String sqlQuery = """
                SELECT student.name, student.age, course.title
                FROM students student
                JOIN enrollments enrollment ON student.id = enrollment.student_id
                JOIN courses course ON enrollment.course_id = course.id
                WHERE student.age >= 18
                ORDER BY student.name;
                """;

        System.out.println("SQL Query with Text Block:");
        System.out.println(sqlQuery);

        // HTML example
        String html = """
                <html>
                    <head>
                        <title>Modern Java Features</title>
                    </head>
                    <body>
                        <h1>Welcome to Java Text Blocks!</h1>
                        <p>This makes multi-line strings so much easier.</p>
                    </body>
                </html>
                """;

        System.out.println("HTML with Text Block:");
        System.out.println(html);

        // Text block with expressions
        String name = "Harshal";
        int year = 2024;
        String message = """
                Hello %s!
                Welcome to modern Java programming.
                Year: %d
                """.formatted(name, year);

        System.out.println("Text Block with Formatting:");
        System.out.println(message);

        // Controlling indentation
        String poem = """
                    Roses are red,
                      Violets are blue,
                    Java is modern,
                      And so are you!
                """;

        System.out.println("Poem with custom indentation:");
        System.out.println(poem);

        System.out.println("\n=== Benefits of Text Blocks ===");
        System.out.println("✓ No need to escape quotes and newlines");
        System.out.println("✓ More readable multi-line strings");
        System.out.println("✓ Preserves formatting and indentation");
        System.out.println("✓ Perfect for JSON, SQL, HTML, and XML");
    }
}
