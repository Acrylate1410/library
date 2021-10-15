import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookList {

    private static List<Book> myBooks = new ArrayList<>();
    public static void add() {
        // khai thông tin
        System.out.println("Enter information for the new book");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Is Borrowed (1 = yes, 0 = no): ");
        int choice = scanner.nextInt();
        
        // nhập lại nếu ngoài 1 và 0
        while (choice != 1 && choice != 0) {
            System.out.print("Invalid! Is Borrowed (1 = yes, 0 = no): ");
            choice = scanner.nextInt();
        }
        
        // chỉnh isBorrowed tùy vào choice
        Boolean isBorrowed = false;
        switch (choice) {
            case 1:
                isBorrowed = true;
                break;
            case 0:
                isBorrowed = false;
                break;
        }

        // add vào list với những thông tin được khai
        addToList(id.toUpperCase(), title, author, isBorrowed);
        System.out.println("A new book has been added");
    }

    public static void addToList(String id, String title, String author, Boolean isBorrowed) {
        // khởi tạo book
        Book book = new Book(id.toUpperCase(), title, author, isBorrowed);
        // add book vào myBooks
        myBooks.add(book);
    }

    public static void search() {
        // truy vấn từ user
        System.out.println("Enter book title to search");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Book title: ");
        String searchKey = scanner.nextLine();

        // add những book khớp truy vấn trong myBooks vào booksFound
        List<Book> booksFound = new ArrayList<>();
        for (Book book : myBooks) {
            if (book.getTitle().contains(searchKey)) {
                booksFound.add(book);
            }
        }

        // hiện những book trong booksFound (khớp truy vấn)
        if (booksFound.isEmpty()) {
            System.out.println("No book is found");
        } else {
            System.out.println(String.format("%-10s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borrowed"));
            for (Book book : booksFound) {
                System.out.println(book.toString());
            }
        }
    }

    public static void display() {
        // hiện những book trong myBooks (tất cả book)
        System.out.println(String.format("%-10s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borrowed"));
        for (Book book : myBooks) {
            System.out.println(book.toString());
        }
    }

    public static void borrow() {
        System.out.println("Enter book ID to borrow");
        Scanner scanner = new Scanner(System.in);

        // truy vấn
        System.out.print("Book ID: ");
        String searchKey = scanner.nextLine();
        List<Book> bookBorrowed = new ArrayList<>();

        // add book khớp truy vấn vào bookBorrowed
        for (Book book : myBooks) {
            if (book.getId().equalsIgnoreCase(searchKey)) {
                bookBorrowed.add(book);
            }
        }

        // kiểm tra xem bookBorrowed có rỗng ko (có book nào khớp truy vấn ko)
        if (bookBorrowed.isEmpty()) {
            System.out.println("No book is found");
        } else {
            // kiểm tra tình trạng isBorrowed của book trong bookBorrowed (book khớp truy vấn) và chuyển những cái false sang true
            for (Book book : bookBorrowed) {
                if (book.getIsBorrowed() == false) {
                    System.out.println("You have successfully borrowed the book: " + book.getTitle());
                    book.setIsBorrowed(true);
                }
                else {
                    System.out.println("You cannot borrow this book. The book has been borrowed");
                }
            }
        }
    }

}
