package data;

import java.util.*;
import util.iMenu;

public class Student extends User implements iMenu{

    public String name, faculty, nim, programStudi;
    public static ArrayList<ArrayList<String>> borrowedBooks = new ArrayList<>();

    public static String isStudent = "";

    public Student (String name, String faculty, String nim, String programStudi) {
        this.name = name;
        this.faculty = faculty;
        this.nim = nim;
        this.programStudi = programStudi;
    }

    public Student () {

    }

    User user = new User();

    public static void displayInfo(String name) {
        System.out.println("Successfully login as " + name);
    }

    public static void showBorrowedBooks() {
        System.out.println("=============================================================================================================");
        System.out.printf("|| %-3s ||   %-17s||            %-20s ||  %-10s ||  %-10s || %-8s  ||%n", "No", "Book ID", "Title", "Author", "Category", "Duration");
        System.out.println("=============================================================================================================");
        int no = 1;
        for (int i = 0; i < borrowedBooks.size(); i++) {
            if(borrowedBooks.get(i).get(0).equals(isStudent)) {
                for (int j = 0; j < borrowedBooks.get(i).size(); j++) {
                    for (int k = 0; k < User.bookList.size(); k++) {
                        if (User.bookList.get(k).getBookId().equals(borrowedBooks.get(i).get(j))) {
                            System.out.printf("|| %-3d ||  %-17s ||  %-30s ||  %-10s ||  %-10s ||  %-8d ||%n", no, User.bookList.get(k).getBookId(), User.bookList.get(k).getTitle(), User.bookList.get(k).getAuthor(), User.bookList.get(k).getCategory(), User.bookList.get(k).getDuration());
                            no++;
                        }
                    }
                }
            }
        }
        System.out.println("=============================================================================================================");
    }

    static Student student = new Student();

    public static void logout() {
        Scanner input = new Scanner(System.in);
        if(borrowedBooks.isEmpty()) {
            System.out.println("Belum ada buku yang dipilih");
            System.out.println("Silahkan pilih buku terlebih dahulu");
        }else {
            boolean empty = true;
            for (int i = 0; i < borrowedBooks.size(); i++) {
                if(borrowedBooks.get(i).getFirst().equals(isStudent)) {
                    empty = false;
                    break;
                }
            }
            if(empty) {
                System.out.println("Belum ada buku yang dipilih");
                System.out.println("Silahkan pilih buku terlebih dahulu");
            }else {
                showBorrowedBooks();
                System.out.println("Apakah kamu yakin untuk meminjam semua buku tersebut?");
                System.out.println("Input Y (iya) atau T (tidak): ");
                String option = input.next();
                input.nextLine();
                if (option.equals("T") || option.equals("t")) {
                    return;
                } else if (option.equals("Y") || option.equals("y")) {
                    System.out.println("Peminjaman buku berhasil dilakukan.");
                    System.out.println("Terima kasih...");
                    isStudent = "";
                    return;
                }
            }
        }
    }

    public static void returnBooks() {
        Scanner input = new Scanner(System.in);
        showBorrowedBooks();
        System.out.print("Input ID Buku yang ingin dihapus (Input 99 untuk back): ");
        String inputID = input.next();
        input.nextLine();
        if (inputID.equals("99")) {
            return;
        } else {
            boolean bookFound = false;
            for (ArrayList<String> borrowedBook : borrowedBooks) {
                if (borrowedBook.get(0).equals(isStudent)) {
                    for (int j = 1; j < borrowedBook.size(); j++) {
                        if (borrowedBook.get(j).equals(inputID)) {
                            for (int k = 0; k < User.bookList.size(); k++) {
                                if (User.bookList.get(k).getBookId().equals(inputID)) {
                                    int stockNow = User.bookList.get(k).getStock();
                                    User.bookList.get(k).setStock(stockNow + 1);
                                    System.out.println("Successfully to return the book with title '" + User.bookList.get(k).getTitle() + "'");
                                    if(borrowedBook.size() == 2) {
                                        borrowedBooks.remove(borrowedBook);
                                    }else {
                                        borrowedBook.remove(j);
                                    }
                                    bookFound = true;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
            if (!bookFound) {
                System.out.println("Borrowed book with ID '" + inputID + "' is not found.");
            }
        }
    }

    public void choiceBook() {
        Scanner input = new Scanner(System.in);
        int loop = 1;
        while(loop == 1) {
            user.displayBook();
            System.out.println("Input Id buku yang ingin dipinjam (input 99 untuk back)");
            System.out.print("Input: ");
            String inputID = input.nextLine();
            if(inputID.equals("99")) {
                loop = 0;
                System.out.println("Kembali ke menu awal...");
            }
            for (int i = 0; i < Admin.bookList.size(); i++) {
                if (User.bookList.get(i).getBookId().equals(inputID)) {
                    if (User.bookList.get(i).getStock() == 0) {
                        System.out.println("Stock buku kosong!");
                        System.out.println("Silahkan pilih yang lain.");
                    } else {
                        boolean durationTrue = false;
                        int duration = 1;
                        while(!durationTrue) {
                            System.out.println("Berapa lama buku akan dipinjam? (maksimal 14 hari)");
                            System.out.print("Input lama (hari): ");
                            duration = input.nextInt();
                            input.nextLine();
                            if (duration > 14) {
                                System.out.println("Maksimal peminjaman 14 hari.");
                            }else {
                                durationTrue = true;
                            }
                        }
                        User.bookList.get(i).setDuration(duration);
                        int j;
                        boolean found = false;
                        for (j = 0; j < borrowedBooks.size(); j++) {
                            if (borrowedBooks.get(j).get(0).equals(isStudent)) {
                                found = true;
                                break;
                            }
                        }
                        if(found) {
                            borrowedBooks.get(j).add(User.bookList.get(i).getBookId());
                        }else {
                            ArrayList<String> newBorrowedBooks = new ArrayList<>();
                            newBorrowedBooks.add(isStudent);
                            newBorrowedBooks.add(User.bookList.get(i).getBookId());
                            borrowedBooks.add(newBorrowedBooks);
                        }
                        int stockNow = User.bookList.get(i).getStock();
                        User.bookList.get(i).setStock(stockNow-1);
                    }
                }
            }
        }
    }

    public void getNim(String nim) {
        if (nim.equals("99")) {
            return;
        }

        for (int i = 0; i < Admin.StudentList.size(); i++) {
            if(Admin.StudentList.get(i).nim.equals(nim)) {
                Student.isStudent = nim;
                Student.displayInfo(Admin.StudentList.get(i).name);
                student.menu();
                return;
            }
        }

        System.out.println("NIM not found.");
    }

    @Override
    public void menu() {
        Scanner input = new Scanner(System.in);

        while (!Student.isStudent.isEmpty()) {
            System.out.println("=== Student Menu ===");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Kembalikan buku");
            System.out.println("4. Pinjam buku atau Logout");
            System.out.print("Choose option (1-4): ");
            int option;
            try {
                option = input.nextInt();

                input.nextLine();
                switch (option) {
                    case 1:
                        if(borrowedBooks.isEmpty()) {
                            System.out.println("Belum ada buku yang dipilih");
                            System.out.println("Silahkan pilih buku terlebih dahulu");
                        }else {
                            boolean empty = true;
                            for (int i = 0; i < borrowedBooks.size(); i++) {
                                if(borrowedBooks.get(i).getFirst().equals(isStudent)) {
                                    Student.showBorrowedBooks();
                                    empty = false;
                                    break;
                                }
                            }
                            if(empty) {
                                System.out.println("Belum ada buku yang dipilih");
                                System.out.println("Silahkan pilih buku terlebih dahulu");
                            }
                        }
                        break;
                    case 2:
                        choiceBook();
                        break;
                    case 3:
                        if(borrowedBooks.isEmpty()) {
                            System.out.println("Belum ada buku yang dipilih");
                            System.out.println("Silahkan pilih buku terlebih dahulu");
                        }else {
                            boolean empty = true;
                            for (int i = 0; i < borrowedBooks.size(); i++) {
                                if(borrowedBooks.get(i).getFirst().equals(isStudent)) {
                                    Student.returnBooks();
                                    empty = false;
                                    break;
                                }
                            }
                            if(empty) {
                                System.out.println("Belum ada buku yang dipilih");
                                System.out.println("Silahkan pilih buku terlebih dahulu");
                            }
                        }
                        break;
                    case 4:
                        Student.logout();
                        break;
                    default:
                        System.out.println("Invalid options.");
                        break;
                }
            }catch (IllegalArgumentException e) {
                System.out.println("Invalid options.");
            }

        }
    }
}
