import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private String genre;

    public Book() {
    }

    public Book(String title, String author, String isbn, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}


public class BookObjArrayList {

    public static Scanner sc = new Scanner(System.in);
    public static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        while(true) {
            System.out.println("1.Add book.\n2.Update book.\n3.Delete book.\n4.Show all books.\n5.Exit");
            System.out.println("Enter your choice.");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1: addBook(); break;
                    case 2: update(); break;
                    case 3: delete(); break;
                    case 4: show(); break;
                    case 5: return;
                    default: System.out.println("Invalid choice. Try again."); break;
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    public static void show() {
        if(bookList.isEmpty()) {
            System.out.println("There are no books in the list to show.");
            return;
        }

        System.out.println("The available books:-");
        for (Book book : bookList) {
            System.out.println(book.getTitle() + " written by " + book.getAuthor());
        }
    }

    public static void addBook() {
        Book book = new Book();

        System.out.print("Enter the book title: ");
        book.setTitle(sc.nextLine());
        System.out.print("Enter the author name: ");
        book.setAuthor(sc.nextLine());
        System.out.print("Enter the ISBN: ");
        book.setIsbn(sc.nextLine());
        System.out.print("Enter the genre: ");
        book.setGenre(sc.nextLine());

        bookList.add(book);
        System.out.println("Book successfully added at index " + (bookList.size() - 1));

    }

    public static void update() {
        if(bookList.isEmpty()) {
            System.out.println("There are no books in the list to update.");
            return;
        }

        System.out.println("There are currently " + bookList.size() + " books in the list");

        System.out.print("Enter the index to modify the details of the book: ");
        int idx = sc.nextInt();
        sc.nextLine();
        Book book = bookList.get(idx);

        System.out.println("The details of the selected book as follows:- ");
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getISBN());
        System.out.println(book.getGenre());

        try {
            System.out.println("Modify the details");
            System.out.print("Enter the new title: ");
            book.setTitle(sc.nextLine());
            System.out.print("Enter the new author name: ");
            book.setAuthor(sc.nextLine());
            System.out.print("Enter the new ISBN: ");
            book.setIsbn(sc.nextLine());
            System.out.print("Enter the new genre: ");
            book.setGenre(sc.nextLine());
        } catch(Exception e) {
            System.out.println("There was an issue updating your book.");
        }

        System.out.println("Book updated Successfully!");
    }

    public static void delete() {
        if(bookList.isEmpty()) {
            System.out.println("There are no books in the list to delete.");
            return;
        }
        System.out.print("Enter the index to delete the book: ");
        int idx = sc.nextInt();
        sc.nextLine();
        Book book = bookList.get(idx);

        System.out.println("The details of the selected book as follows:- ");
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getISBN());
        System.out.println(book.getGenre());

        System.out.println("Are you sure you want to delete this?");
        System.out.println("(press enter to confirm, any character to abort)");
        String input = sc.nextLine();
        if(input.isEmpty()) {
            bookList.remove(idx);
            System.out.println("Book deleted successfully.");
        }
    }
}
