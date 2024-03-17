package sourceFiles;

public class Employee {
    private String id;
    private String name;
    private double salary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double percentage) {
        this.salary += this.salary * percentage / 100.0;
    }

    public String getInfo() {
        return "ID: " + id + ", Name: " + name + ", Salary: $" + salary;
    }
}
