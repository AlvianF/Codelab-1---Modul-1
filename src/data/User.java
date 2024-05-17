package data;

import books.Book;
import books.HistoryBook;
import books.StoryBook;
import books.TextBook;

public class User {

    public static Book[] bookList = new Book[50];

    public void displayBook() {
        if(Admin.bookCount != 0) {
            System.out.println("==========================================================================================================");
            System.out.printf("|| %-3s ||   %-17s||            %-20s ||  %-10s ||  %-10s || %-5s  ||%n", "No", "Book ID", "Title", "Author", "Category", "Stock");
            System.out.println("==========================================================================================================");
            for (int i = 0; i < Admin.bookCount; i++) {
                System.out.printf("|| %-3d ||  %-17s ||  %-30s ||  %-10s ||  %-10s ||  %-5d ||%n", i + 1, User.bookList[i].getBookId(), User.bookList[i].getTitle(), User.bookList[i].getAuthor(), User.bookList[i].getCategory(), User.bookList[i].getStock());
            }
            System.out.println("==========================================================================================================");
        }
    }

    public static void addBook(int option, String id, String title, String author, int stock) {
        switch (option) {
            case 1:
                User.bookList[Admin.bookCount] = new StoryBook(id, title, author, stock);
                Admin.bookCount++;
                System.out.println("Book successfully added to the library.");
                break;
            case 2:
                User.bookList[Admin.bookCount] = new HistoryBook(id, title, author, stock);
                Admin.bookCount++;
                System.out.println("Book successfully added to the library.");
                break;
            case 3:
                User.bookList[Admin.bookCount] = new TextBook(id, title, author, stock);
                Admin.bookCount++;
                System.out.println("Book successfully added to the library.");
                break;
        }
    }
}
