package interfaces;

interface  card{
    int num = 1;
    void display();
}

class idCard implements card {
    @Override
    public void display() {
        System.out.println("ID Card number: " + 123);
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        idCard id = new idCard();
        id.display();
    }
}
