public class Book {
    private String title;
    private String author;
    private int yearPublished;
    private int edition;
    private boolean available;

    public Book(String title, String author, int yearPublished, int edition) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.edition = edition;
        this.available=true;
    }
    public Book() {
        this.title="";
        this.author="";
        this.yearPublished=0;
        this.edition=0;
        this.available=true;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
        return title + " by " + author + ". Published year " + yearPublished + ", edition nr" + edition + ". This book is " + (available ? "available." : "not available.");
    }
}
