package sourceFiles;

public class Animal {
    private String species;
    private boolean isMammal;
    private String habitat;

    public Animal(String species, boolean isMammal, String habitat) {
        this.species = species;
        this.isMammal = isMammal;
        this.habitat = habitat;
    }

    public void displayInfo() {
        String mammalStatus = isMammal ? "a mammal" : "not a mammal";
        System.out.println(species + " is " + mammalStatus + " and lives in " + habitat + ".");
    }
}

