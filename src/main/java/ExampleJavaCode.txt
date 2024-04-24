interface Printable {
    void print();
}

public class ExampleJavaCode implements Printable {
    private String message = "Hello, Java Syntax Highlighter!";

    public void print() {
        System.out.println(message);
    }

    public static void main(String[] args) {
        ExampleJavaCode example = new ExampleJavaCode();
        example.print();
    }
}
