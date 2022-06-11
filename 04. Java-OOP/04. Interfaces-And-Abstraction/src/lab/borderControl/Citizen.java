package lab.borderControl;

public class Citizen implements Identifiable {
    //-	name: String
    //-	age: int
    //-	id: String
    private String name;
    private int age;
    private String id;

    //+	Citizen(Stirng, int, String)
    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    //+	getName() : String
    public String getName() {
        return name;
    }

    //+	getAge() : int
    public int getAge() {
        return age;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
