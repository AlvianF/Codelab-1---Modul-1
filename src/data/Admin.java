package data;

import java.util.*;

import exception.custom.illegalAdminAccess;
import util.iMenu;

public class Admin extends User implements iMenu{

    private static String adminUsername = "admin";
    private static String adminPassword = "admin";
    public static ArrayList<Student> StudentList = new ArrayList<>();

    public static boolean isAdmin;

    public static void addStudent() {
        Scanner input = new Scanner(System.in);
        boolean name = false;
        boolean nim = false;
        boolean faculty = false;
        boolean program = false;
        String inputName = "", inputNim = "", inputFaculty = "", inputProgram = "";


        while (!name) {
            System.out.print("Enter student name: ");
            inputName = input.nextLine();
            if (inputName.isEmpty()) {
                System.out.println("Name is empty.\n");
            }else if(inputName.equals("99")){
                return;
            }else {
                name = true;
            }
        }
        while (!nim) {
            System.out.print("Enter student nim: ");
            inputNim = input.next();
            input.nextLine();
            if(inputNim.equals("99")) {
                return;
            }else if (inputNim.length() != 15) {
                System.out.println("NIM must have 15 digits!!");
            } else if (!inputNim.matches("\\d+")) {
                System.out.println("Invalid NIM!");
            }else {
                nim = true;
            }
        }
        while (!faculty) {
            System.out.print("Enter student faculty: ");
            inputFaculty = input.nextLine();
            if (inputFaculty.isEmpty()) {
                System.out.println("Invalid faculty.\n");
            }else if(inputFaculty.equals("99")){
                return;
            }else {
                faculty = true;
            }
        }
        while (!program) {
            System.out.print("Enter student program: ");
            inputProgram = input.nextLine();
            if (inputProgram.isEmpty()) {
                System.out.println("Invalid program.\n");
            }else if(inputProgram.equals("99")) {
                return;
            }else {
                program = true;
            }
        }

        StudentList.add(new Student(inputName, inputFaculty, inputNim, inputProgram));

        System.out.println("Student successfully registered.");
    }

    public static void inputBook() {
        Scanner input = new Scanner(System.in);
        System.out.print("Select book category: \n1. Story book\n2. History book\n3. Text book\nChoose category (1-3): ");
        int option = input.nextInt();
        String inputTitle = "", inputAuthor = "";
        int inputStock = 0;
        input.nextLine();
        if(option < 4 && option > 0) {
            boolean title = false;
            boolean author = false;
            boolean stock = false;

            while(!title) {
                System.out.print("Enter book title (99 untuk back): ");
                inputTitle = input.nextLine();
                if (inputTitle.isEmpty()) {
                    System.out.println("Title is empty.\n");
                }else if(inputTitle.equals("99")){
                    return;
                }else {
                    title = true;
                }
            }
            while (!author) {
                System.out.print("Enter author (99 untuk back): ");
                inputAuthor = input.nextLine();
                if (inputAuthor.isEmpty()) {
                    System.out.println("Author is empty.\n");
                }else if(inputAuthor.equals("99")){
                    return;
                }else {
                    author = true;
                }
            }
            while (!stock) {
                System.out.print("Enter the stock (99 untuk back): ");
                inputStock = input.nextInt();
                input.nextLine();
                if (inputStock < 1) {
                    System.out.println("Minimum stock is 1.");
                }else if(inputStock == 99){
                    return;
                }else {
                    stock = true;
                }
            }

            String bookID = generateId();
            boolean bookIDReady = false;
            while (!bookIDReady) {
                for (int i = 0; i < bookList.size(); i++) {
                    if (bookList.get(i).getBookId().equals(bookID)) {
                        bookID = generateId();
                        bookIDReady = false;
                        break;
                    }else {
                        bookIDReady = true;
                    }
                }
            }

            User.addBook(option, bookID, inputTitle, inputAuthor, inputStock);
        }else {
            System.out.println("Invalid option.");
        }
    }

    @Override
    public void displayBook() {
        if(!bookList.isEmpty()) {
            System.out.println("==========================================================================================================");
            System.out.printf("|| %-3s ||   %-17s||            %-20s ||  %-10s ||  %-10s || %-5s  ||%n", "No", "Book ID", "Title", "Author", "Category", "Stock");
            System.out.println("==========================================================================================================");
            for (int i = 0; i < bookList.size(); i++) {
                System.out.printf("|| %-3d ||  %-17s ||  %-30s ||  %-10s ||  %-10s ||  %-5d ||%n", i + 1, User.bookList.get(i).getBookId(), User.bookList.get(i).getTitle(), User.bookList.get(i).getAuthor(), User.bookList.get(i).getCategory(), User.bookList.get(i).getStock());
            }
            System.out.println("==========================================================================================================");
        }
    }

    public static void displayStudent() {
        if(!StudentList.isEmpty()) {
            System.out.println("List of Registered Students: ");
            for (int i = 0; i < StudentList.size(); i++) {
                System.out.print("Name: " + StudentList.get(i).name + "\nFaculty: " + StudentList.get(i).faculty + "\nNIM: " + StudentList.get(i).nim + "\nProgram: " + StudentList.get(i).programStudi + "\n\n");
            }
        }else {
            System.out.println("There is no student registered.");
        }
    }

    public static boolean isAdmin(String uname, String pw) throws illegalAdminAccess {
        if(!(uname.equals(adminUsername) && pw.equals(adminPassword))) {
            throw new illegalAdminAccess("Invalid credentials.");
        }else {
            return true;
        }
    }

    public static String generateId() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();

        String formattedID = uuidString.substring(0, 4) + "-" +
                uuidString.substring(9, 13) + "-" +
                uuidString.substring(14, 18);

        return formattedID;
    }

    @Override
    public void menu() {
        Scanner input = new Scanner(System.in);

        while (Admin.isAdmin) {
            System.out.println("==== Admin Menu ====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Book");
            System.out.println("3. Display Registered Students");
            System.out.println("4. Display Available Books");
            System.out.println("5. Logout");
            System.out.print("Choose option (1-5): ");
            int option;
            try {
                option = input.nextInt();

                switch (option) {
                    case 1:
                        Admin.addStudent();
                        break;
                    case 2:
                        Admin.inputBook();
                        break;
                    case 3:
                        Admin.displayStudent();
                        break;
                    case 4:
                        displayBook();
                        break;
                    case 5:
                        Admin.isAdmin = false;
                        System.out.println("Logging out from admin account.");
                        return;
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
