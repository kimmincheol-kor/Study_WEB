class Cat {
    private String name;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}

public class Animal {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        cat1.setName("na1");
        System.out.println(cat1.getName());
        System.out.println(cat2.getName());
        cat2.setName("na2");
        System.out.println(cat1.getName());
        System.out.println(cat2.getName());
    }
}