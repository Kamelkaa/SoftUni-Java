package lab.ferrari;

public class Ferrari implements Car {
    //-	driverName: String
    //-	model: String
    private String driverName;
    private String model;

    //+	Ferrari (String)
    public Ferrari(String name) {
        this.driverName = name;
        this.model = "488-Spider";
    }

    //+	brakes() : String
    @Override
    public String brakes() {
        return "Brakes!";
    }

    //+	gas() : String
    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    //+	toString(): String
    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.model, this.brakes(), this.gas(), this.driverName);
    }
}
