import java.util.Scanner;

public class Manager {
    public static void main (String[] args) {
        play();
    }

    public static void play() {
        System.out.println("---------------------");
        System.out.println("1. Enter a new book");
        System.out.println("2. Search a book by book title");
        System.out.println("3. Display books");
        System.out.println("4. Borrow a book by book ID");
        System.out.println("5. Exit");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your choice");
        int choice = scanner.nextInt();
                if (choice == 1) {
                    BookList.add();
                    play();
                }
                else if (choice == 2) {
                    BookList.search();
                    play();
                }
                else if (choice == 3) {
                    BookList.display();
                    play();
                }
                else if (choice == 4) {
                    BookList.borrow();
                    play();
                }
            }

}
