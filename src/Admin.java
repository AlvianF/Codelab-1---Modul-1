import java.util.Scanner;

public class Admin {
    String nama, nim, fakultas, prodi;

    Admin[] dataStudent = new Admin[10];
    int jumlahStudent = 0;

    public Admin(String nama, String nim, String fakultas, String prodi) {
        this.nama = nama;
        this.nim = nim;
        this.fakultas = fakultas;
        this.prodi = prodi;

    }

    Scanner input = new Scanner(System.in);


    String inputNama, inputNIM, inputFakultas, inputProdi;

    public Admin() {

    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        inputNama = input.nextLine();
        System.out.print("Enter student NIM: ");
        inputNIM = input.next();
        input.nextLine();
        if (inputNIM.length() != 15) {
            System.out.println("NIM must have 15 digits!!");
            return;
        }else if(!inputNIM.matches("\\d+")){
            System.out.println("Invalid NIM!");
            return;
        }
        System.out.print("Enter student faculty: ");
        inputFakultas = input.nextLine();
        System.out.print("Enter student program: ");
        inputProdi = input.nextLine();

        Admin dataBaru = new Admin(inputNama, inputNIM, inputFakultas, inputProdi);

        dataStudent[jumlahStudent] = dataBaru;
        jumlahStudent++;

        System.out.println("Student successfully registered.");
    }

    public void displayStudent() {

        if(jumlahStudent != 0) {
            System.out.println("List of Registered Students: ");
            for (int i = 0; i < jumlahStudent; i++) {
                System.out.print("Name: " + dataStudent[i].nama + "\nFaculty: " + dataStudent[i].fakultas + "\nNIM: " + dataStudent[i].nim + "\nProgram: " + dataStudent[i].prodi + "\n\n");
            }
        }else {
            System.out.println("There is no student registered.");
        }
    }

}
