// Create a parent class Animal with a method makeSound() and a subclass Dog that overrides this method. Use the super keyword to call the parent class's method in the overridden version.

class Animal{
    void makeSound(){
        System.out.println("Animal sound");
    }
}

class Dog extends Animal{
    @Override   
    void makeSound(){
        super.makeSound();   // it will call the Parent class i.e. Animal named and print the parent method
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
