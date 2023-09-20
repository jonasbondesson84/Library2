import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String choice;
        Scanner sc = new Scanner(System.in);
        Library myLibrary = new Library();
        ArrayList<Book> listOfBooks = new ArrayList<>();

        System.out.println("Welcome to my library. Choose what you want to do. \n");
        do {
            System.out.println("1. Add a book to the library.");
            System.out.println("2. Search for a book.");
            System.out.println("3. List all available books.");
            System.out.println("4. List all non-available books.");
            System.out.println("5. Reserv a book.");
            System.out.println("6. Return a book.");
            System.out.println("7. Quit");
            choice=sc.nextLine();

            switch (choice) {
                case "1" -> {
                    myLibrary.addBooks();
                }
                case "2" -> {
                    myLibrary.searchForBooks();
                }
                case "3" -> {
                    myLibrary.listBooks(true);
                }
                case "4" -> {
                    myLibrary.listBooks(false);
                }
                case "5" -> {
                    myLibrary.reservBook();
                }
                case "6" -> {
                    myLibrary.returnBook();

                }
                default -> {
                    System.out.println("Wrong input, try again. \n");
                }
            }

        } while(!choice.equalsIgnoreCase("7"));
    }
}