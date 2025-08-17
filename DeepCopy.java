class Address {
    String city;

    Address(String city) {
        this.city = city;
    }

    // Deep copy support
    Address(Address other) {
        this.city = other.city;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Deep copy implementation
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = new Address(this.address); // new Address object
        return cloned;
    }
}

public class DeepCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Pune");
        Person p1 = new Person("Harshal", address);

        // Deep copy
        Person p2 = (Person) p1.clone();

        System.out.println("Before change:");
        System.out.println("p1 address: " + p1.address.city);
        System.out.println("p2 address: " + p2.address.city);

        // Change in p2's address WON'T affect p1
        p2.address.city = "Mumbai";

        System.out.println("\nAfter change:");
        System.out.println("p1 address: " + p1.address.city); // Pune
        System.out.println("p2 address: " + p2.address.city); // Mumbai
    }
}
