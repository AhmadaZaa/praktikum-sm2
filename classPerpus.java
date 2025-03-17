class Buku {
    private String judul;
    private String[] penulis;
    private String kategori;
    private String sinopsis;
    
    // Constructor
    public Buku(String judul, String[] penulis, String kategori, String sinopsis) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.sinopsis = sinopsis;
    }
    
        // Method untuk menampilkan informasi buku
        public void displayInfo() {
            System.out.println("Judul Buku: " + judul);
            System.out.print("Penulis: ");
            for (int i = 0; i < penulis.length; i++) {
                System.out.print(penulis[i]);
                if (i < penulis.length - 1) System.out.print(", ");
            }
            System.out.println("\nKategori: " + kategori);
            System.out.println("Sinopsis: " + sinopsis);
            System.out.println("Jumlah Kata dalam Sinopsis: " + hitungKataSinopsis());
            System.out.println("====================");
        }
    
        // Method untuk menghitung jumlah kata dalam sinopsis
        public int hitungKataSinopsis() {
            return sinopsis.split("\\s+").length;
        }
    
        // Method untuk mengecek tingkat kesamaan antara dua buku
        public double cekKesamaan(Buku bukuLain) {
            int total = 4; // Empat atribut yang dibandingkan
            int kesamaan = 0;
    
            if (this.judul.equalsIgnoreCase(bukuLain.judul)) kesamaan++;
            if (this.kategori.equalsIgnoreCase(bukuLain.kategori)) kesamaan++;
            if (this.sinopsis.equalsIgnoreCase(bukuLain.sinopsis)) kesamaan++;
            if (this.penulis.length == bukuLain.penulis.length) {
                boolean sama = true;
                for (int i = 0; i < penulis.length; i++) {
                    if (!this.penulis[i].equalsIgnoreCase(bukuLain.penulis[i])) {
                        sama = false;
                        break;
                    }
                }
                if (sama) kesamaan++;
            }
            return (kesamaan / (double) total) * 100;
        }
    
        // Method untuk membuat salinan objek buku
        public Buku copy() {
            return new Buku(judul, penulis.clone(), kategori, sinopsis);
        }
    }

public class classPerpus {
    public static void main(String[] args) {
        Buku[] buku = new Buku[35];
        String[][] daftarBuku = {
            {"Teknologi", "Pengantar Teknologi Informasi", "John Doe", "Buku ini membahas dasar-dasar teknologi informasi secara lengkap."},
            {"Teknologi", "Dasar-dasar Jaringan Komputer", "Andrew Tanenbaum", "Penjelasan mendalam tentang jaringan komputer modern."},
            {"Teknologi", "Kecerdasan Buatan dan Aplikasinya", "Stuart Russell", "Membahas AI dari konsep dasar hingga penerapannya."},
            {"Teknologi", "Algoritma dan Struktur Data", "Robert Sedgewick", "Panduan tentang algoritma dan struktur data dalam pemrograman."},
            {"Teknologi", "Pemrograman Java untuk Pemula", "Herbert Schildt", "Buku ini memperkenalkan pemrograman Java secara mudah."},
            {"Sejarah", "Sejarah Dunia yang Disembunyikan", "Jonathan Black", "Mengungkap sejarah yang jarang diketahui banyak orang."},
            {"Sejarah", "Sejarah Peradaban Islam", "Karen Armstrong", "Membahas perjalanan sejarah Islam dari masa ke masa."},
            {"Sejarah", "Perang Dunia II dalam Perspektif Baru", "Max Hastings", "Analisis mendalam tentang Perang Dunia II."},
            {"Sejarah", "Sejarah Nusantara", "Ahmad Mansur Suryanegara", "Mengungkap sejarah Indonesia secara lebih mendalam."},
            {"Sejarah", "The Silk Roads", "Peter Frankopan", "Sejarah jalur sutra dan dampaknya terhadap dunia."},
            {"Self Development", "Atomic Habits", "James Clear", "Panduan untuk membentuk kebiasaan baik dan menghilangkan yang buruk."},
            {"Self Development", "The Power of Habit", "Charles Duhigg", "Membahas bagaimana kebiasaan terbentuk dan berubah."},
            {"Self Development", "Grit: The Power of Passion and Perseverance", "Angela Duckworth", "Menjelaskan pentingnya ketekunan dalam meraih sukses."},
            {"Self Development", "Mindset: The New Psychology of Success", "Carol S. Dweck", "Menjelaskan pentingnya mindset dalam meraih kesuksesan."},
            {"Self Development", "Ikigai: The Japanese Secret to a Long and Happy Life", "Hector Garcia", "Rahasia kebahagiaan dan umur panjang dari Jepang."},
            {"Filsafat", "Dasar-dasar Filsafat", "Aristoteles", "Buku ini menjelaskan dasar-dasar pemikiran filsafat klasik."},
            {"Filsafat", "Filsafat Eksistensialisme", "Jean-Paul Sartre", "Mengupas teori eksistensialisme secara mendalam."},
            {"Filsafat", "The Republic", "Plato", "Buku klasik tentang konsep keadilan dalam negara."},
            {"Filsafat", "Being and Time", "Martin Heidegger", "Menjelaskan konsep waktu dan eksistensi manusia."},
            {"Filsafat", "Meditations", "Marcus Aurelius", "Refleksi pribadi seorang kaisar Romawi tentang hidup."},
            {"Politik", "Konsep Politik Modern", "SP. Varma", "Buku yang mengupas teori-teori politik modern."},
            {"Politik", "The Prince", "Niccolò Machiavelli", "Panduan politik tentang bagaimana memperoleh dan mempertahankan kekuasaan."},
            {"Politik", "Demokrasi dan Kebebasan", "Fareed Zakaria", "Menjelaskan hubungan demokrasi dan kebebasan."},
            {"Politik", "The Road to Serfdom", "Friedrich Hayek", "Menjelaskan bahayanya kontrol pemerintah yang berlebihan."},
            {"Politik", "The Communist Manifesto", "Karl Marx", "Manifesto politik yang membentuk ideologi komunisme."},
            {"Ekonomi", "Wealth of Nations", "Adam Smith", "Dasar-dasar ekonomi pasar bebas dijelaskan di sini."},
            {"Ekonomi", "Capital in the Twenty-First Century", "Thomas Piketty", "Menganalisis ketimpangan ekonomi modern."},
            {"Ekonomi", "Freakonomics", "Steven D. Levitt", "Menghubungkan ekonomi dengan fenomena sosial tak terduga."},
            {"Ekonomi", "The General Theory of Employment, Interest, and Money", "John Maynard Keynes", "Teori ekonomi Keynesian yang berpengaruh."},
            {"Ekonomi", "Thinking, Fast and Slow", "Daniel Kahneman", "Menjelaskan bagaimana otak manusia membuat keputusan."}
        };
        
        for (int i = 0; i < buku.length; i++) {
            buku[i] = new Buku(daftarBuku[i][1], new String[]{daftarBuku[i][2]}, daftarBuku[i][0], daftarBuku[i][3]);
            buku[i].displayInfo();
        }
    }
}