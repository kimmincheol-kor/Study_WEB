public class Inheritance {
    public static void main(String[] args) {
        
        Dog myDog = new Dog();
        HouseDog hDog = new HouseDog();

        myDog.setName("bobo");
        hDog.setName("caca");

        myDog.Bow();
        hDog.Bow();
        hDog.Bow(".HOUSE.");
    }
}

class Animal {
    private String name;

    Animal() {
        System.out.println("Create Animal");
    }

    Animal(String name) { // Overloading
        this.setName(name);
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}

class Dog extends Animal {

    Dog() {
        System.out.println("Create Dog");
    }

    void Bow() {
        System.out.println("Bow!");
        System.out.println(this.getName());
    }
}

class HouseDog extends Dog {

    HouseDog() {
        System.out.println("Create House Dog");
    }

    void Bow() { // Same Arguments
        System.out.println("Overriding Bow in the house!");
        System.out.println(this.getName());
    }

    void Bow(String bow) { // Different Arguments
        System.out.println("Overloading Bow in the house!");
        System.out.println(bow);
    }
}