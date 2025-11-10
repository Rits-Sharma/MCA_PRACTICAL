class Building {
    String type;
    int floors;

    Building(int floors) {
        this.type = "Normal";
        this.floors = floors;
    }

    Building(String type, int floors) {
        this.type = type;
        this.floors = floors;
    }

    void show() {
        System.out.println("Building type: " + type);
        System.out.println("Building floors: " + floors);
    }
}

class House extends Building {
    House(int floors) {
        super(floors);
    }

    House(String type, int floors) {
        super(type, floors);
    }

    @Override
    void show() {
        System.out.println("Building type: " + type);
        System.out.println("Building floors: " + floors);
    }
}

public class ques8a {
    public static void main(String[] args) {
        House h1 = new House(2);
        House h2 = new House("Apartment", 12);

        h1.show();
        h2.show();
    }
}
