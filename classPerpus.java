class Buku {
    private String judul;
    private String[] penulis;
    private String kategori;
    
    public void setJudul(String j) {
        judul = j;
    }
    
    public void setPenulis(String[] p) {
        penulis = p;
    }
    
    public void setKategori(String k) {
        kategori = k;
    }
    
    public void displayInfo() {
        System.out.println("Judul Buku: " + judul);
        System.out.print("Penulis: ");
        for (int i = 0; i < penulis.length; i++) {
            System.out.print(penulis[i]);
            if (i < penulis.length - 1) System.out.print(", ");
        }
        System.out.println("\nKategori: " + kategori);
        System.out.println("====================");
    }
}

public class classPerpus {
    public static void main(String[] args) {
        Buku b1 = new Buku();
        b1.setJudul("Pengantar Teknologi Informasi");
        b1.setPenulis(new String[]{"John Doe"});
        b1.setKategori("Teknologi");
        b1.displayInfo();
        
        Buku b2 = new Buku();
        b2.setJudul("Sejarah Dunia yang Disembunyikan");
        b2.setPenulis(new String[]{"Jonathan Black"});
        b2.setKategori("Sejarah");
        b2.displayInfo();
        
        Buku b3 = new Buku();
        b3.setJudul("Atomic Habits");
        b3.setPenulis(new String[]{"James Clear"});
        b3.setKategori("Self Development");
        b3.displayInfo();
        
        Buku b4 = new Buku();
        b4.setJudul("Dasar-dasar Filsafat");
        b4.setPenulis(new String[]{"Aristoteles"});
        b4.setKategori("Filsafat");
        b4.displayInfo();
        
        Buku b5 = new Buku();
        b5.setJudul("Konsep Politik Modern");
        b5.setPenulis(new String[]{"SP. Varma"});
        b5.setKategori("Politik");
        b5.displayInfo();
    }
}