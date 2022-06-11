package exercise.task_04_PizzaCalories;

public class Dough {
    //-	flourType: String
    //-	bakingTechnique: String
    //-	weight: double
    private String flourType;
    private String bakingTechnique;
    private double weight;

    //+ 	Dought (String, String, double)
    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    //-	setWeight(double): void
    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    //-	setFlourType(String): void
    private void setFlourType(String flourType) {
        if ("White".equals(flourType) || "Wholegrain".equals(flourType)) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    //-	setBakingTechnique(String): void
    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
            case "Chewy":
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    //+	calculateCalories (): double
    public double calculateCalories() {
        // (2 * weight) * flourTypeModifier * bakingTechniqueModifier;
        double flourTypeModifier = this.getFlourTypeModifier(this.flourType);
        double bakingTechniqueModifier = this.getBakingTechniqueModifier(this.bakingTechnique);

        return (2 * this.weight) * flourTypeModifier * bakingTechniqueModifier;
    }

    private double getBakingTechniqueModifier(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
            case "Homemade":
                return 1;
            default:
                return 0;
        }
    }

    private double getFlourTypeModifier(String flourType) {
        if ("White".equals(flourType)) {
            return 1.5;
        } else if ("Wholegrain".equals(flourType)) {
            return 1;
        } else {
            return 0;
        }
    }
}
