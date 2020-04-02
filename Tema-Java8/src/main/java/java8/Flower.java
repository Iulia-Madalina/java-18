package java8;


public class Flower {

    private String name;
    private String color;
    private int numberOfPetals;
    private double height;
    private int lifeTimeInDays;

    public Flower(String name, String color, int numberOfPetals, double height, int lifeTimeInDays) {
        this.name = name;
        this.color = color;
        this.numberOfPetals = numberOfPetals;
        this.height = height;
        this.lifeTimeInDays = lifeTimeInDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfPetals() {
        return numberOfPetals;
    }

    public void setNumberOfPetals(int numberOfPetals) {
        this.numberOfPetals = numberOfPetals;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getLifeTimeInDays() {
        return lifeTimeInDays;
    }

    public void setLifeTimeInDays(int lifeTimeInDays) {
        this.lifeTimeInDays = lifeTimeInDays;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", numberOfPetals=" + numberOfPetals +
                ", height=" + height +
                ", lifeTimeInDays=" + lifeTimeInDays +
                '}';
    }
}
