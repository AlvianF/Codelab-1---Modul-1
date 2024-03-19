//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int ulang = 1;

        int pilihan;
        Scanner inputPilihan = new Scanner(System.in);
        while (ulang != 2) {

            System.out.println("Menu: ");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan anda: ");

            pilihan = inputPilihan.nextInt();

            switch(pilihan) {
                case 1:
                    Mahasiswa.tambahData();
                    break;
                case 2:
                    Mahasiswa.tampilUniversitas();
                    Mahasiswa.tampilDataMahasiswa();
                    break;
                case 3:
                    System.out.println("Adios!");
                    return;
            }
        }

    }
}