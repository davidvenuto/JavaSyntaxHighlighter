package sourceFiles;

public class GardenPlant {
    private String name;
    private String season;
    private boolean isPerennial;

    public GardenPlant(String name, String season, boolean isPerennial) {
        this.name = name;
        this.season = season;
        this.isPerennial = isPerennial;
    }

    public void displayPlantDetails() {
        String type = isPerennial ? "Perennial" : "Annual";
        System.out.println("Plant: " + name + ", Season: " + season + ", Type: " + type);
    }
}
