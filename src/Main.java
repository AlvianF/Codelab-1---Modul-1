import java.util.*;

public class Main {
    String id_buku;
    String nama_buku;
    String author_buku;
    String kategori_buku;
    int stock_buku;

    public Main(String id, String nama, String author, String kategori, int stock) {
        this.id_buku = id;
        this.nama_buku = nama;
        this.author_buku = author;
        this.kategori_buku = kategori;
        this.stock_buku = stock;
    }

    static int looping = 0;

    Admin admin = new Admin();
    Student student = new Student();

    boolean loginStudent = false;
    boolean loginAdmin = false;

    public Main() {

    }

    public static void main(String[] args) {

        Main main = new Main();

        while (looping == 0) {
            main.Menu();
        }
    }


    Scanner input = new Scanner(System.in);

    String inputNIM, usernameAdmin, passwordAdmin;
    int opsi;
    String inputPinjam;

    public void Menu() {
        String upwadmin = "admin";
        System.out.print("=== Library System ===\n1. Login as Student\n2. Login as Admin\n3. Exit\nChoose option (1-3): ");
        opsi = input.nextInt();
        switch (opsi) {
            case 1:
                inputNim();
                break;
            case 2:
                System.out.print("Enter your username (admin): ");
                usernameAdmin = input.next();
                System.out.print("Enter your password (admin): ");
                passwordAdmin = input.next();
                if(usernameAdmin.equals(upwadmin)) {
                    if(passwordAdmin.equals(upwadmin)) {
                        System.out.println("Successfully login as Admin.");
                        loginAdmin = true;
                        menuAdmin();
                    }else {
                        System.out.println("Invalid credentials for admin.");
                    }
                }else {
                    System.out.println("Invalid credentials for admin.");
                }
                break;
            case 3:
                System.out.print("Thank you. Exiting program.\n");
                looping = 1;
                break;
            default:
                break;
        }
    }

    public void inputNim() {
        System.out.print("Enter your NIM (input 99 untuk back): ");
        inputNIM = input.next();
        checkNim(inputNIM);
    }

    public void checkNim(String nim) {
        if(nim.equals("99")) {
            return;
        }

        if(admin.jumlahStudent != 0) {

            for (int i = 0; i < admin.jumlahStudent; i++) {
                if(!loginStudent) {
                    if (nim.equals(admin.dataStudent[i].nim)) {
                        System.out.println("Successfully login as Student.");
                        loginStudent = true;
                    }
                }else {
                    break;
                }
            }
        }else {
            return;
        }

        menuStudent();
    }

    public void menuAdmin() {
        while(loginAdmin) {
            System.out.print("=== Admin Menu ===\n1. Add Student\n2. Display Registered Students\n3. Logout\nChoose option (1-3): ");
            opsi = input.nextInt();

            switch (opsi) {
                case 1:
                    admin.addStudent();
                    break;
                case 2:
                    admin.displayStudent();
                    break;
                case 3:
                    loginAdmin = false;
                    break;
                default:
                    break;
            }
        }
    }

    public void menuStudent() {
        while(loginStudent) {
            System.out.print("=== Student Menu ===\n1. Buku terpinjam\n2. Pinjam buku\n3. Pinjam buku atau Logout\nChoose option (1-3): ");
            opsi = input.nextInt();

            switch (opsi) {
                case 1:
                    student.displayBooks();
                    break;
                case 2:
                    System.out.print("Input Id buku yang ingin dipinjam (input 99 untuk back)\nInput: ");
                    inputPinjam = input.next();
                    if(inputPinjam.equals("99")) {
                        break;
                    }
                    if(student.BukuPertama.id_buku.equals(inputPinjam)) {
                        if(student.BukuPertama.stock_buku != 0) {
                            student.BukuPertama.stock_buku--;
                            System.out.println("Berhasil meminjam buku dengan judul " + student.BukuPertama.nama_buku);
                        }else {
                            System.out.println("Stock buku dengan id tersebut sudah habis!");
                        }
                    }else if(student.BukuKedua.id_buku.equals(inputPinjam)) {
                        if(student.BukuKedua.stock_buku != 0) {
                            student.BukuKedua.stock_buku--;
                            System.out.println("Berhasil meminjam buku dengan judul " + student.BukuKedua.nama_buku);
                        }else {
                            System.out.println("Stock buku dengan id tersebut sudah habis!");
                        }
                    }else if(student.BukuKetiga.id_buku.equals(inputPinjam)) {
                        if(student.BukuKetiga.stock_buku != 0) {
                            student.BukuKetiga.stock_buku--;
                            System.out.println("Berhasil meminjam buku dengan judul " + student.BukuKetiga.nama_buku);
                        }else {
                            System.out.println("Stock buku dengan id tersebut sudah habis!");
                        }
                    }else {
                        System.out.println("Tidak dapat menemukan id buku tersebut.");
                    }
                    break;
                case 3:
                    if(!student.inginLogoutStudent) {
                        student.displayBooks();
                        System.out.print("Input Id buku yang ingin dipinjam (input 99 untuk back)\nInput: ");
                        inputPinjam = input.next();
                        if (inputPinjam.equals("99")) {
                            student.logout();
                            break;
                        }
                        if (student.BukuPertama.id_buku.equals(inputPinjam)) {
                            if (student.BukuPertama.stock_buku != 0) {
                                student.BukuPertama.stock_buku--;
                                System.out.println("Berhasil meminjam buku dengan judul " + student.BukuPertama.nama_buku);
                            } else {
                                System.out.println("Stock buku dengan id tersebut sudah habis!");
                            }
                        } else if (student.BukuKedua.id_buku.equals(inputPinjam)) {
                            if (student.BukuKedua.stock_buku != 0) {
                                student.BukuKedua.stock_buku--;
                                System.out.println("Berhasil meminjam buku dengan judul " + student.BukuKedua.nama_buku);
                            } else {
                                System.out.println("Stock buku dengan id tersebut sudah habis!");
                            }
                        } else if (student.BukuKetiga.id_buku.equals(inputPinjam)) {
                            if (student.BukuKetiga.stock_buku != 0) {
                                student.BukuKetiga.stock_buku--;
                                System.out.println("Berhasil meminjam buku dengan judul " + student.BukuKetiga.nama_buku);
                            } else {
                                System.out.println("Stock buku dengan id tersebut sudah habis!");
                            }
                        } else {
                            System.out.println("Tidak dapat menemukan id buku tersebut.");
                            student.logout();
                            break;
                        }
                    }else {
                        System.out.print("System logout...\n\n");
                        loginStudent = false;
                    }
            }
        }
    }
}
