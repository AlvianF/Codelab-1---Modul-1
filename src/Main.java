import java.time.*;
import java.time.format.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String nama, jenisKelamin;
        char inputKelamin;
        String tanggalLahir;

        System.out.print("Nama: ");
        Scanner input = new Scanner(System.in);

        nama = input.nextLine();

        System.out.print("Jenis Kelamin (L/P): ");

        inputKelamin = input.next().charAt(0);

        if (inputKelamin == 'P' || inputKelamin == 'p') {
            jenisKelamin = "Perempuan";
        }else if (inputKelamin == 'L' || inputKelamin == 'l') {
            jenisKelamin = "Laki-laki";
        }else{
            System.out.println("Format input jenis kelamin salah.");
            return;
        }

        System.out.print("Tanggal lahir (yyyy-mm-dd): ");

        tanggalLahir = input.next();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate tanggal = LocalDate.parse(tanggalLahir, format);

            LocalDate sekarang = LocalDate.now();

            Period umur = Period.between(tanggal, sekarang);

            if (umur.getMonths() != 0) {
                System.out.print("Nama: " + nama + "\nJenis Kelamin: " + jenisKelamin + "\nUmur: " + umur.getYears() + " tahun " + umur.getMonths() + " bulan");
            }else {
                System.out.print("Nama: " + nama + "\nJenis Kelamin: " + jenisKelamin + "\nUmur: " + umur.getYears() + " tahun");
            }
        }catch (Exception e) {
            System.out.println("Format tanggal lahir salah.");
        }

    }
}