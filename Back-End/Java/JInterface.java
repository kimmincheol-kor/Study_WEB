public class JInterface {
    public static void main(String[] args) {
        ZooKeeper keeper = new ZooKeeper();
        Lion lion = new Lion();
        Tiger tiger = new Tiger();
        Rabbit rabbit = new Rabbit();

        keeper.feed(lion);
        keeper.feed(tiger);
        keeper.feed(rabbit);
    }
}

class ZooKeeper {
    void feed(Carnivore cv) {
        System.out.println("Carnivore feed " + cv.getFood());
    }

    void feed(Herbivore hv) {
        System.out.println("Herbivore feed " + hv.getFood());
    }
}

class Animal {
    
}

interface Carnivore {
    String getFood();
}

interface Herbivore {
    String getFood();
}

class Tiger extends Animal implements Carnivore {
    public String getFood() {
        return "TigerFood";
    }
}

class Lion extends Animal implements Carnivore {
    public String getFood() {
        return "LionFood";
    }
}

class Rabbit extends Animal implements Herbivore {
    public String getFood() {
        return "RabbitFood";
    }
}