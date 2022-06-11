package exercise.animals;

public class Frog extends Animal {
    //fields: name, age, gender

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Ribbit";
    }
}
