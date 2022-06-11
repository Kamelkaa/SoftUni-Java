package lab.borderControl;

public class Robot implements Identifiable {
    //-	id: String
    //-	model: String
    private String id;
    private String model;

    //+	Robot(Stirng, String)
    public Robot(String model, String id) {
        this.id = id;
        this.model = model;
    }

    //+	getModel() : String
    public String getModel() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
