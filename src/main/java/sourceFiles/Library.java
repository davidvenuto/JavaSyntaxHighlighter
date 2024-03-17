package sourceFiles;

public class Library {
    private String name;
    private int numberOfBooks;

    public Library(String name, int numberOfBooks) {
        this.name = name;
        this.numberOfBooks = numberOfBooks;
    }

    public void addBook(int booksAdded) {
        this.numberOfBooks += booksAdded;
    }

    public void lendBook(int booksLent) {
        if (booksLent > this.numberOfBooks) {
            System.out.println("Not enough books in the library.");
        } else {
            this.numberOfBooks -= booksLent;
        }
    }

    public String getInfo() {
        return "Library Name: " + name + ", Number of Books: " + numberOfBooks;
    }
}
