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
        Buku[] buku = new Buku[35];
        String[][] daftarBuku = {
            {"Teknologi", "Pengantar Teknologi Informasi", "John Doe"},
            {"Teknologi", "Dasar-dasar Jaringan Komputer", "Andrew Tanenbaum"},
            {"Teknologi", "Kecerdasan Buatan dan Aplikasinya", "Stuart Russell"},
            {"Teknologi", "Algoritma dan Struktur Data", "Robert Sedgewick"},
            {"Teknologi", "Pemrograman Java untuk Pemula", "Herbert Schildt"},
            
            {"Sejarah", "Sejarah Dunia yang Disembunyikan", "Jonathan Black"},
            {"Sejarah", "Sejarah Peradaban Islam", "Karen Armstrong"},
            {"Sejarah", "Perang Dunia II dalam Perspektif Baru", "Max Hastings"},
            {"Sejarah", "Sejarah Nusantara", "Ahmad Mansur Suryanegara"},
            {"Sejarah", "The Silk Roads", "Peter Frankopan"},
            
            {"Self Development", "Atomic Habits", "James Clear"},
            {"Self Development", "The Power of Habit", "Charles Duhigg"},
            {"Self Development", "Grit: The Power of Passion and Perseverance", "Angela Duckworth"},
            {"Self Development", "Mindset: The New Psychology of Success", "Carol S. Dweck"},
            {"Self Development", "Ikigai: The Japanese Secret to a Long and Happy Life", "Hector Garcia"},
            
            {"Filsafat", "Dasar-dasar Filsafat", "Aristoteles"},
            {"Filsafat", "Filsafat Eksistensialisme", "Jean-Paul Sartre"},
            {"Filsafat", "The Republic", "Plato"},
            {"Filsafat", "Being and Time", "Martin Heidegger"},
            {"Filsafat", "Meditations", "Marcus Aurelius"},
            
            {"Politik", "Konsep Politik Modern", "SP. Varma"},
            {"Politik", "The Prince", "Niccolò Machiavelli"},
            {"Politik", "Demokrasi dan Kebebasan", "Fareed Zakaria"},
            {"Politik", "The Road to Serfdom", "Friedrich Hayek"},
            {"Politik", "The Communist Manifesto", "Karl Marx"},
            
            {"Ekonomi", "Wealth of Nations", "Adam Smith"},
            {"Ekonomi", "Capital in the Twenty-First Century", "Thomas Piketty"},
            {"Ekonomi", "Freakonomics", "Steven D. Levitt"},
            {"Ekonomi", "The General Theory of Employment, Interest, and Money", "John Maynard Keynes"},
            {"Ekonomi", "Thinking, Fast and Slow", "Daniel Kahneman"}
        };
        
        for (int i = 0; i < buku.length; i++) {
            buku[i] = new Buku();
            buku[i].setKategori(daftarBuku[i][0]);
            buku[i].setJudul(daftarBuku[i][1]);
            buku[i].setPenulis(new String[]{daftarBuku[i][2]});
            buku[i].displayInfo();
        }
    }
}
