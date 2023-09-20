import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBooks() {
        String title;
        String author;
        int year;
        int edition;
        System.out.println("Enter title:");
        title= sc.nextLine();
        System.out.println("Enter author:");
        author=sc.nextLine();
        System.out.println("Enter year of publication:");
        year=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter edition:");
        edition=sc.nextInt();
        sc.nextLine();

        books.add(new Book(title, author, year, edition));
    }

    public void listBooks(boolean available) {
        for (Book currentBook : books) {
            if(currentBook.isAvailable()==available) {
                System.out.println(currentBook);
            }
        }
        System.out.println();
    }

    public ArrayList<Book> searchForBooks() {
        String searchTerm;
        ArrayList<Book> listOfFoundBooks = new ArrayList<>();
        System.out.println("Which book are you looking for?");
        searchTerm = sc.nextLine();
        for(Book currentBook : books) {
            if (currentBook.getTitle().contains(searchTerm)) {
                listOfFoundBooks.add(currentBook);
            }
        }
        if(!listOfFoundBooks.isEmpty()) {
            System.out.println("The following books were found:");
            for (Book currentBook : listOfFoundBooks) {
                System.out.println(listOfFoundBooks.indexOf(currentBook) +". "+ currentBook);
            }
            System.out.println();
        } else {
            System.out.println("No books found. \n");
        }
        return listOfFoundBooks;

    }

    public void reservBook() {
        ArrayList<Book> listOfFoundBooks;
        do {
            listOfFoundBooks = searchForBooks();
        } while (listOfFoundBooks.isEmpty());
        int choice;
        String answer;
        do {
            System.out.println("Which book do you want to reserv (choose by number)?");
            choice = sc.nextInt();
            sc.nextLine();
        } while (listOfFoundBooks.size()< choice);
        System.out.println("Do you want to reserv " + listOfFoundBooks.get(choice).getTitle() + " by author " +listOfFoundBooks.get(choice).getAuthor() + "?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        answer=sc.nextLine();
        switch (answer.toLowerCase()) {
            case "1", "yes" -> {
                if(listOfFoundBooks.get(choice).isAvailable()) {
                    listOfFoundBooks.get(choice).setAvailable(false);
                    System.out.println("Thank you for reserving " + listOfFoundBooks.get(choice).getTitle() + " by author " + listOfFoundBooks.get(choice).getAuthor() + ".");
                } else {
                    System.out.println("Sorry, book not available. \n");
                }
            }
            case "2", "no" -> {
                System.out.println("Okay, thank you anyway.");
            }
        }

    }

    public void returnBook() {
        ArrayList<Book> listOfFoundBooks;
        do {
            listOfFoundBooks = searchForBooks();
        } while (listOfFoundBooks.isEmpty());
        int choice;
        String answer;
        do {
            System.out.println("Which book do you want to reserv (choose by number)?");
            choice = sc.nextInt();
            sc.nextLine();
        } while (listOfFoundBooks.size()< choice);
        System.out.println("Do you want to return " + listOfFoundBooks.get(choice).getTitle() + " by author " +listOfFoundBooks.get(choice).getAuthor() + "?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        answer=sc.nextLine();
        switch (answer.toLowerCase()) {
            case "1", "yes" -> {
                if(!listOfFoundBooks.get(choice).isAvailable()) {
                    listOfFoundBooks.get(choice).setAvailable(true);
                    System.out.println("Thank you for returning " + listOfFoundBooks.get(choice).getTitle() + " by author " + listOfFoundBooks.get(choice).getAuthor() + ".");
                } else {
                    System.out.println("Sorry, book not reserved. \n");
                }
            }
            case "2", "no" -> {
                System.out.println("Okay, thank you anyway.");
            }
        }

    }
}
