import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> daftarMahasiswa = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        boolean selesai = false;
        while (!selesai) {
            System.out.print("Masukkan nama ke-" + (daftarMahasiswa.size()+1) + ": ");
            String inputNama = input.nextLine();
            try {
                if (inputNama.isEmpty()) {
                    throw new IllegalArgumentException("Nama tidak boleh kosong!");
                }

                if (inputNama.equalsIgnoreCase("selesai")) {
                    System.out.println("Daftar mahasiswa yang di inputkan:");
                    for (String nama : daftarMahasiswa) {
                        System.out.println("- " + nama);
                    }
                    selesai = true;
                } else {
                    daftarMahasiswa.add(inputNama);
                }
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}