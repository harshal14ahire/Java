class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy (default clone)
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ShallowCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Pune");
        Person p1 = new Person("Harshal", address);

        // Shallow copy
        Person p2 = (Person) p1.clone();

        System.out.println("Before change:");
        System.out.println("p1 address: " + p1.address.city);
        System.out.println("p2 address: " + p2.address.city);

        // Change in p2's address will reflect in p1 also
        p2.address.city = "Mumbai";

        System.out.println("\nAfter change:");
        System.out.println("p1 address: " + p1.address.city); // Mumbai
        System.out.println("p2 address: " + p2.address.city); // Mumbai
    }
}
