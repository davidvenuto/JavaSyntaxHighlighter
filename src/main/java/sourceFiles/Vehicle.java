package sourceFiles;
public class Vehicle {
    private String type;
    private int maxSpeed;

    public Vehicle(String type, int maxSpeed) {
        this.type = type;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Vehicle Type: " + type + ", Max Speed: " + maxSpeed + "km/h");
    }
}
