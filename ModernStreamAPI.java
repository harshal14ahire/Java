/**
 * Demonstrates Stream API and Functional Programming features
 * Shows modern approaches to data processing in Java
 */

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

// Sample data classes
class Employee {
    private String name;
    private String department;
    private double salary;
    private int age;

    Employee(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    String getName() { return name; }
    String getDepartment() { return department; }
    double getSalary() { return salary; }
    int getAge() { return age; }

    @Override
    public String toString() {
        return String.format("%s (%s, $%.0f, %d yrs)", name, department, salary, age);
    }
}

public class ModernStreamAPI {

    public static void main(String[] args) {
        System.out.println("=== Stream API and Functional Programming Demo ===\n");

        // Sample data
        var employees = List.of(
                new Employee("Harshal", "Engineering", 85000, 28),
                new Employee("Priya", "Marketing", 65000, 25),
                new Employee("Amit", "Engineering", 95000, 32),
                new Employee("Sneha", "HR", 60000, 27),
                new Employee("Rahul", "Engineering", 75000, 24),
                new Employee("Anita", "Marketing", 70000, 29),
                new Employee("Vikram", "Finance", 80000, 35)
        );

        // 1. Filter and Collect
        System.out.println("1. Filter Engineers:");
        var engineers = employees.stream()
                .filter(e -> e.getDepartment().equals("Engineering"))
                .collect(Collectors.toList());
        engineers.forEach(System.out::println);

        // 2. Map operation
        System.out.println("\n2. Employee Names (uppercase):");
        var names = employees.stream()
                .map(Employee::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(names);

        // 3. Sorting
        System.out.println("\n3. Employees Sorted by Salary (descending):");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        // 4. Grouping
        System.out.println("\n4. Employees Grouped by Department:");
        var byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        byDepartment.forEach((dept, emps) -> {
            System.out.println(dept + ": " + emps.size() + " employees");
            emps.forEach(e -> System.out.println("  - " + e.getName()));
        });

        // 5. Statistics
        System.out.println("\n5. Salary Statistics:");
        var salaryStats = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary: $" + String.format("%.2f", salaryStats.getAverage()));
        System.out.println("Max Salary: $" + salaryStats.getMax());
        System.out.println("Min Salary: $" + salaryStats.getMin());
        System.out.println("Total Payroll: $" + salaryStats.getSum());

        // 6. Partitioning
        System.out.println("\n6. Partition by Age (30+):");
        var partitioned = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() >= 30));
        System.out.println("30 or older: " + partitioned.get(true).size());
        System.out.println("Under 30: " + partitioned.get(false).size());

        // 7. Finding and Matching
        System.out.println("\n7. Finding and Matching:");
        var highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        highestPaid.ifPresent(e -> System.out.println("Highest paid: " + e));

        var anyEngineer = employees.stream()
                .filter(e -> e.getDepartment().equals("Engineering"))
                .findAny();
        anyEngineer.ifPresent(e -> System.out.println("Found engineer: " + e.getName()));

        var allAbove50k = employees.stream()
                .allMatch(e -> e.getSalary() > 50000);
        System.out.println("All earn > $50k: " + allAbove50k);

        // 8. Reduction
        System.out.println("\n8. Reduction Operations:");
        var totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println("Total Salary (reduce): $" + totalSalary);

        var concatenatedNames = employees.stream()
                .map(Employee::getName)
                .reduce("", (a, b) -> a.isEmpty() ? b : a + ", " + b);
        System.out.println("All names: " + concatenatedNames);

        // 9. Flat Map
        System.out.println("\n9. FlatMap Example:");
        var departments = List.of(
                List.of("Engineering", "Product", "Design"),
                List.of("Marketing", "Sales"),
                List.of("HR", "Finance")
        );
        var allDepts = departments.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("All departments: " + allDepts);

        // 10. Parallel Streams
        System.out.println("\n10. Parallel Stream Performance:");
        var numbers = IntStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toList());
        
        long startSeq = System.currentTimeMillis();
        var sumSeq = numbers.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        long endSeq = System.currentTimeMillis();

        long startPar = System.currentTimeMillis();
        var sumPar = numbers.parallelStream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        long endPar = System.currentTimeMillis();

        System.out.println("Sequential time: " + (endSeq - startSeq) + "ms");
        System.out.println("Parallel time: " + (endPar - startPar) + "ms");

        // 11. Custom Collectors
        System.out.println("\n11. Custom Joining:");
        var empNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Employee names: " + empNames);

        // 12. Functional Interfaces
        System.out.println("\n12. Functional Interfaces:");
        
        // Predicate
        Predicate<Employee> isHighEarner = e -> e.getSalary() > 80000;
        var highEarners = employees.stream()
                .filter(isHighEarner)
                .count();
        System.out.println("High earners (>$80k): " + highEarners);

        // Function
        Function<Employee, String> employeeInfo = e -> 
                e.getName() + " earns $" + String.format("%.0f", e.getSalary());
        System.out.println("\nEmployee Info:");
        employees.stream()
                .map(employeeInfo)
                .limit(3)
                .forEach(System.out::println);

        // Consumer
        Consumer<Employee> printEmployee = e -> 
                System.out.println("Processing: " + e.getName());
        System.out.println("\nUsing Consumer:");
        employees.stream().limit(2).forEach(printEmployee);

        // Supplier
        Supplier<Employee> newEmployee = () -> 
                new Employee("New Hire", "Engineering", 70000, 26);
        System.out.println("\nNew employee: " + newEmployee.get());

        System.out.println("\n=== Benefits of Stream API ===");
        System.out.println("✓ Declarative programming style");
        System.out.println("✓ Built-in parallel processing support");
        System.out.println("✓ Composable operations (filter, map, reduce)");
        System.out.println("✓ Lazy evaluation - efficient processing");
        System.out.println("✓ Rich set of collectors for aggregation");
        System.out.println("✓ Functional programming paradigm in Java");
    }
}
