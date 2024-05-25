package data;

import books.Book;
import books.HistoryBook;
import books.StoryBook;
import books.TextBook;

import java.util.ArrayList;

public class User {

    public static ArrayList<Book> bookList = new ArrayList<>();

    public void displayBook() {
        if(!Admin.StudentList.isEmpty()) {
            System.out.println("==========================================================================================================");
            System.out.printf("|| %-3s ||   %-17s||            %-20s ||  %-10s ||  %-10s || %-5s  ||%n", "No", "Book ID", "Title", "Author", "Category", "Stock");
            System.out.println("==========================================================================================================");
            for (int i = 0; i < Admin.StudentList.size(); i++) {
                System.out.printf("|| %-3d ||  %-17s ||  %-30s ||  %-10s ||  %-10s ||  %-5d ||%n", i + 1, User.bookList.get(i).getBookId(), User.bookList.get(i).getTitle(), User.bookList.get(i).getAuthor(), User.bookList.get(i).getCategory(), User.bookList.get(i).getStock());
            }
            System.out.println("==========================================================================================================");
        }
    }

    public static void addBook(int option, String id, String title, String author, int stock) {
        switch (option) {
            case 1:
                User.bookList.add(new StoryBook(id, title, author, stock));
                System.out.println("Book successfully added to the library.");
                break;
            case 2:
                User.bookList.add(new HistoryBook(id, title, author, stock));
                System.out.println("Book successfully added to the library.");
                break;
            case 3:
                User.bookList.add(new TextBook(id, title, author, stock));
                System.out.println("Book successfully added to the library.");
                break;
        }
    }
}
