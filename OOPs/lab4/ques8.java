// Create a class Building with overloaded constructors. Then create a class House that extends Building, and use super() to call different constructors from the superclass based on input parameters.

class Building {
    protected String address;
    protected int squareFootage;
    protected int floors;

    // Constructor 1: Only address
    public Building(String address) {
        this.address = address;
        this.squareFootage = 1000; // Default square footage
        this.floors = 1;          // Default number of floors
    }

    // Constructor 2: Address and square footage
    public Building(String address, int squareFootage) {
        this.address = address;
        this.squareFootage = squareFootage;
        this.floors = 1;           // Default number of floors
    }

    // Constructor 3: Address, square footage, and floors
    public Building(String address, int squareFootage, int floors) {
        this.address = address;
        this.squareFootage = squareFootage;
        this.floors = floors;
    }

    // Method to display building information
    public void displayInfo() {
        System.out.println("Building Information:");
        System.out.println("Address: " + address);
        System.out.println("Square Footage: " + squareFootage);
        System.out.println("Number of Floors: " + floors);
    }
}

class House extends Building {
    // Constructor 1: Only address
    public House(String address) {
        super(address);  // Calls Building constructor with address only
    }

    // Constructor 2: Address and square footage
    public House(String address, int squareFootage) {
        super(address, squareFootage);  // Calls Building constructor with address and square footage
    }

    // Constructor 3: Address, square footage, and floors
    public House(String address, int squareFootage, int floors) {
        super(address, squareFootage, floors);  // Calls Building constructor with all parameters
    }

    // Override displayInfo to add House-specific information
    @Override
    public void displayInfo() {
        System.out.println("\nHouse Information:");
        System.out.println("Address: " + address);
        System.out.println("Square Footage: " + squareFootage);
        System.out.println("Number of Floors: " + floors);
    }
}

public class ques8 {
    public static void main(String[] args) {
        // Create houses with different parameters
        House house1 = new House("123 Main St");
        House house2 = new House("456 Oak Ave", 2000);
        House house3 = new House("789 Pine Rd", 3000, 3);

        // Display house information
        house1.displayInfo();
        house2.displayInfo();
        house3.displayInfo();
    }
}
