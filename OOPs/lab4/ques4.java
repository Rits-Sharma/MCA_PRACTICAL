class Animal{
    void makeSound(){
        System.out.println("Animal sound");
    }
}

class Dog extends Animal{
    @Override   
    void makeSound(){
        super.makeSound();
        System.out.println("Bark");
    }
}



public class ques4 {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.makeSound();

        Dog d = new Dog();
        d.makeSound();
    }
}
