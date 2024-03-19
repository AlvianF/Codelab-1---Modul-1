import java.util.*;

public class Mahasiswa {

    String nama, nim, jurusan;

    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    static String inputNama, inputNIM, inputJurusan;
    static Mahasiswa[] arrayMahasiswa = new Mahasiswa[5];
    static int jumlahDataMahasiswa = 0;

    static Scanner input = new Scanner(System.in);

    static public void tambahData() {
        int selesai = 1;
        System.out.print("Masukkan nama Mahasiswa: ");
        inputNama = input.nextLine();
        while (selesai != 2) {
            System.out.print("Masukkan NIM Mahasiswa: ");
            inputNIM = input.nextLine();
            if (inputNIM.length() != 15) {
                System.out.println("NIM Harus 15 Digit!!!");
            } else {
                selesai = 2;
                System.out.print("Masukkan jurusan mahasiswa: ");
                inputJurusan = input.nextLine();
                Mahasiswa data = new Mahasiswa(inputNama, inputNIM, inputJurusan);
                arrayMahasiswa[jumlahDataMahasiswa] = data;
                jumlahDataMahasiswa++;
                System.out.println("Data mahasiswa berhasil ditambahkan.");
            }
        }

    }

    static public void tampilUniversitas() {
        System.out.println("Universitas Muhammadiyah Malang");
    }

    static public void tampilDataMahasiswa() {
        if (jumlahDataMahasiswa != 0) {
            for (int i = 0; i < jumlahDataMahasiswa; i++) {
                System.out.print("Nama: " + arrayMahasiswa[i].nama + ", NIM: " + arrayMahasiswa[i].nim + ", Jurusan: " + arrayMahasiswa[i].jurusan + "\n");
            }
            System.out.print("\n");
        }else {
            System.out.print("Tidak ada data mahasiswa.\n\n");
        }
    }
}
