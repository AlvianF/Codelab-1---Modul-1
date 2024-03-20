public class Student {

    Main BukuPertama;
    Main BukuKedua;
    Main BukuKetiga;

    boolean inginLogoutStudent = false;
    boolean dataBukuSudahAda = false;

    public void displayBooks() {
        if(!dataBukuSudahAda) {
            BukuPertama = new Main("388c-e681-9152", "title", "author", "Sejarah", 4);

            BukuKedua = new Main("ed90-be30-5cdb", "title", "author", "Sejarah", 0);

            BukuKetiga = new Main("d95e-0c4a-9523", "title", "author", "Sejarah", 2);
            dataBukuSudahAda = true;
        }
        int no_urut = 1;
        System.out.print("=======================================================================================\n");
        System.out.print("|| No. \t|| Id buku \t\t\t|| Nama buku \t\t|| Author \t\t|| Category\t|| Stock ||\n");
        System.out.print("=======================================================================================\n");
        System.out.print("|| " + no_urut + "\t|| " + BukuPertama.id_buku + " \t|| " + BukuPertama.nama_buku + " \t\t\t|| " + BukuPertama.author_buku + " \t\t|| " + BukuPertama.kategori_buku + " \t|| " + BukuPertama.stock_buku + "\t ||\n");
        no_urut++;
        System.out.print("|| " + no_urut + "\t|| " + BukuKedua.id_buku + " \t|| " + BukuKedua.nama_buku + " \t\t\t|| " + BukuKedua.author_buku + " \t\t|| " + BukuKedua.kategori_buku + " \t|| " + BukuKedua.stock_buku + "\t ||\n");
        no_urut++;
        System.out.print("|| " + no_urut + "\t|| " + BukuKetiga.id_buku + " \t|| " + BukuKetiga.nama_buku + " \t\t\t|| " + BukuKetiga.author_buku + " \t\t|| " + BukuKetiga.kategori_buku + " \t|| " + BukuKetiga.stock_buku + "\t ||\n");
        System.out.print("=======================================================================================\n");
    }

    public void logout() {
        inginLogoutStudent = true;
    }
}
