import java.util.ArrayList;

public class Abstract {

    public static void main(String[] args) {
        Dog dog = new Dog("Wolf", "big", 100);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Tuna", "big", 50));
        animals.add(new Horse("Stallion", "big", 200));

        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if (animal instanceof Mammal currentMammal)
                currentMammal.shedHair();
        }
    }

    private static void doAnimalStuff(Animal animal) {
        animal.makeNoise();
        animal.move("slow");
    }

    public static abstract class Animal {
        protected String type;
        private String size;
        private double weight;

        public Animal(String type, String size, double weight) {
            this.type = type;
            this.size = size;
            this.weight = weight;
        }

        public abstract void move(String speed);

        public abstract void makeNoise();

        public final String getExplicitType() {
            return getClass().getSimpleName() + " (" + type + ")";
        }
    }

    // abstract class extending another has more flexibility
        // can implement all, some or none of the parent's abstract methods
        // can also include additional abstract methods
            // will force subclasses to implement both parent's and parent's parent's abstract methods
                // in this case both Animal's and Mammal's
    public static abstract class Mammal extends Animal {
        public Mammal(String type, String size, double weight) {
            super(type, size, weight);
        }

        @Override
        public void move(String speed) {
            System.out.print(getExplicitType() + " ");
            System.out.println(speed.equals("slow") ? "walks" : "runs");
        }

        public abstract void shedHair();
    }

    public static class Dog extends Animal {
        public Dog(String type, String size, double weight) {
            super(type, size, weight);
        }

        @Override
        public void move(String speed) {
            if (speed.equals("slow"))
                System.out.printf("%s walking \n", type);
            else
                System.out.printf("%s running", type);
        }

        @Override
        public void makeNoise() {
            if (type == "Wolf")
                System.out.print("Howling! ");
            else
                System.out.print("Woof! ");
        }
    }

    public static class Fish extends Animal {
        public Fish(String type, String size, double weight) {
            super(type, size, weight);
        }

        @Override
        public void move(String speed) {
            if (speed.equals("slow"))
                System.out.printf("%s lazily swimming \n", type);
            else
                System.out.printf("%s darting frantically \n", type);
        }

        @Override
        public void makeNoise() {
            if (type == "Goldfish")
                System.out.print("Swish! ");
            else
                System.out.print("Splash! ");
        }
    }

    public static class Horse extends Mammal {
        public Horse(String type, String size, double weight) {
            super(type, size, weight);
        }

        @Override
        public void shedHair() {
            System.out.println(getExplicitType() + "sheds in the spring");
        }

        @Override
        public void makeNoise() {
            System.out.print("Neigh! ");
        }
    }
}
