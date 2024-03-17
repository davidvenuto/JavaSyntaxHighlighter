package sourceFiles;

public class Patient {
    private String name;
    private int age;
    private String illness;

    public Patient(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
    }

    public String getPatientInfo() {
        return "Patient Name: " + name + ", Age: " + age + ", Illness: " + illness;
    }
}
