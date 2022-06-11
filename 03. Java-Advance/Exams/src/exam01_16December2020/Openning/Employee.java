package exam01_16December2020.Openning;

public class Employee {
    private String name;
    private  int age;
    private String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString(){
        //Employee: {name}, {age} ({country})"
        return String.format("Employee: %s, %d (%s)", this.name, this.age, this.country);
    }
}
