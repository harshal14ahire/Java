/**
 * Demonstrates Sealed Classes (Java 17+)
 * Sealed classes restrict which classes can extend or implement them
 */

// Sealed class defining permitted subclasses
abstract sealed class Vehicle permits Car, Truck, Motorcycle {
    private final String brand;
    private final int year;

    Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    String getBrand() {
        return brand;
    }

    int getYear() {
        return year;
    }

    abstract String getType();
}

// Final class - cannot be extended further
final class Car extends Vehicle {
    private final int doors;

    Car(String brand, int year, int doors) {
        super(brand, year);
        this.doors = doors;
    }

    int getDoors() {
        return doors;
    }

    @Override
    String getType() {
        return "Car";
    }
}

// Sealed class - can be extended by specific classes
sealed class Truck extends Vehicle permits PickupTruck, SemiTruck {
    private final double loadCapacity;

    Truck(String brand, int year, double loadCapacity) {
        super(brand, year);
        this.loadCapacity = loadCapacity;
    }

    double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    String getType() {
        return "Truck";
    }
}

// Non-sealed class - can be extended by anyone
non-sealed class Motorcycle extends Vehicle {
    private final boolean hasSidecar;

    Motorcycle(String brand, int year, boolean hasSidecar) {
        super(brand, year);
        this.hasSidecar = hasSidecar;
    }

    boolean hasSidecar() {
        return hasSidecar;
    }

    @Override
    String getType() {
        return "Motorcycle";
    }
}

// Further extensions of the sealed Truck class
final class PickupTruck extends Truck {
    private final boolean fourWheelDrive;

    PickupTruck(String brand, int year, double loadCapacity, boolean fourWheelDrive) {
        super(brand, year, loadCapacity);
        this.fourWheelDrive = fourWheelDrive;
    }

    boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    @Override
    String getType() {
        return "Pickup Truck";
    }
}

final class SemiTruck extends Truck {
    private final int trailers;

    SemiTruck(String brand, int year, double loadCapacity, int trailers) {
        super(brand, year, loadCapacity);
        this.trailers = trailers;
    }

    int getTrailers() {
        return trailers;
    }

    @Override
    String getType() {
        return "Semi Truck";
    }
}

// Example: Motorcycle can be extended since it's non-sealed
class SportMotorcycle extends Motorcycle {
    private final int topSpeed;

    SportMotorcycle(String brand, int year, boolean hasSidecar, int topSpeed) {
        super(brand, year, hasSidecar);
        this.topSpeed = topSpeed;
    }

    int getTopSpeed() {
        return topSpeed;
    }

    @Override
    String getType() {
        return "Sport Motorcycle";
    }
}

// Sealed interface example
sealed interface Payment permits CreditCardPayment, DebitCardPayment, CashPayment {
    double getAmount();
    String getPaymentType();
}

record CreditCardPayment(double amount, String cardNumber, String cvv) implements Payment {
    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getPaymentType() {
        return "Credit Card";
    }
}

record DebitCardPayment(double amount, String cardNumber, String pin) implements Payment {
    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getPaymentType() {
        return "Debit Card";
    }
}

record CashPayment(double amount) implements Payment {
    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getPaymentType() {
        return "Cash";
    }
}

public class ModernSealedClasses {

    // Exhaustive pattern matching with sealed classes
    public static String describeVehicle(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            Car c = (Car) vehicle;
            return "Car with " + c.getDoors() + " doors";
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle m = (Motorcycle) vehicle;
            return "Motorcycle" + (m.hasSidecar() ? " with sidecar" : "");
        } else if (vehicle instanceof Truck) {
            Truck t = (Truck) vehicle;
            return "Truck with capacity: " + t.getLoadCapacity() + " tons";
        }
        return "Unknown vehicle";
    }

    // Processing payments with sealed interface
    public static void processPayment(Payment payment) {
        String message;
        if (payment instanceof CreditCardPayment) {
            CreditCardPayment cc = (CreditCardPayment) payment;
            message = "Processing credit card payment of $" + cc.getAmount();
        } else if (payment instanceof DebitCardPayment) {
            DebitCardPayment dc = (DebitCardPayment) payment;
            message = "Processing debit card payment of $" + dc.getAmount();
        } else if (payment instanceof CashPayment) {
            CashPayment cash = (CashPayment) payment;
            message = "Processing cash payment of $" + cash.getAmount();
        } else {
            message = "Unknown payment type";
        }
        System.out.println(message);
    }

    public static void main(String[] args) {
        System.out.println("=== Sealed Classes Demo ===\n");

        // Creating instances
        Car car = new Car("Toyota", 2024, 4);
        Truck truck = new PickupTruck("Ford", 2023, 2.5, true);
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", 2024, false);
        SportMotorcycle sportBike = new SportMotorcycle("Ducati", 2024, false, 300);

        System.out.println("Vehicle Descriptions:");
        System.out.println(car.getBrand() + " " + car.getType() + ": " + describeVehicle(car));
        System.out.println(truck.getBrand() + " " + truck.getType() + ": " + describeVehicle(truck));
        System.out.println(motorcycle.getBrand() + " " + motorcycle.getType() + ": " + describeVehicle(motorcycle));
        System.out.println(sportBike.getBrand() + " " + sportBike.getType() + " (Top Speed: " + sportBike.getTopSpeed() + " km/h)");

        System.out.println("\nSealed Interface Example (Payment Processing):");
        Payment payment1 = new CreditCardPayment(150.50, "1234-5678-9012-3456", "123");
        Payment payment2 = new DebitCardPayment(75.25, "9876-5432-1098-7654", "4321");
        Payment payment3 = new CashPayment(100.00);

        processPayment(payment1);
        processPayment(payment2);
        processPayment(payment3);

        System.out.println("\n=== Sealed Class Hierarchy ===");
        System.out.println("Vehicle (sealed)");
        System.out.println("├── Car (final) - cannot be extended");
        System.out.println("├── Truck (sealed)");
        System.out.println("│   ├── PickupTruck (final)");
        System.out.println("│   └── SemiTruck (final)");
        System.out.println("└── Motorcycle (non-sealed) - can be extended");
        System.out.println("    └── SportMotorcycle - extended from non-sealed");

        System.out.println("\n=== Benefits of Sealed Classes ===");
        System.out.println("✓ Controlled inheritance - define exact class hierarchy");
        System.out.println("✓ Exhaustive pattern matching - compiler knows all subtypes");
        System.out.println("✓ Better domain modeling - express design intent clearly");
        System.out.println("✓ Enhanced security - prevent unauthorized extensions");
        System.out.println("✓ Works with records and interfaces");
    }
}
