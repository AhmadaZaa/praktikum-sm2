// Kelas Pelanggan mewakili 1 akun pelanggan di swalayan
class Pelanggan {
    private String noPelanggan;
    private String nama;
    private int saldo;
    private String pin;
    private boolean diblokir = false;
    private int percobaanGagal = 0;

    public Pelanggan(String noPelanggan, String nama, int saldo, String pin) {
        this.noPelanggan = noPelanggan;
        this.nama = nama;
        this.saldo = saldo;
        this.pin = pin;
    }

    // Autentikasi menggunakan no pelanggan & PIN
    private boolean autentikasi(String no, String pinInput) {
        if (diblokir) {
            System.out.println("Akun telah diblokir!");
            return false;
        }

        if (this.noPelanggan.equals(no) && this.pin.equals(pinInput)) {
            percobaanGagal = 0;
            return true;
        } else {
            percobaanGagal++;
            System.out.println("PIN salah! Percobaan: " + percobaanGagal);
            if (percobaanGagal >= 3) {
                diblokir = true;
                System.out.println("Akun telah diblokir karena 3x salah PIN.");
            }
            return false;
        }
    }

    // Metode untuk top up saldo
    public void topUp(String no, String pinInput, int jumlah) {
        if (autentikasi(no, pinInput)) {
            saldo += jumlah;
            System.out.println("Top up berhasil. Saldo sekarang: Rp" + saldo);
        }
    }

    // Metode untuk melakukan pembelian
    public void beli(String no, String pinInput, int totalBelanja) {
        if (autentikasi(no, pinInput)) {
            int cashback = hitungCashback(totalBelanja);
            int totalBayar = totalBelanja - cashback;

            if ((saldo - totalBayar) < 10000) {
                System.out.println("Transaksi gagal. Saldo minimal Rp10.000 harus tersisa.");
            } else {
                saldo -= totalBayar;
                System.out.println("Transaksi berhasil! Total bayar: Rp" + totalBayar + ", cashback: Rp" + cashback);
                System.out.println("Saldo sekarang: Rp" + saldo);
            }
        }
    }

    // Menentukan jumlah cashback berdasarkan jenis pelanggan
    private int hitungCashback(int totalBelanja) {
        String kode = noPelanggan.substring(0, 2);
        if (totalBelanja <= 1000) return 0;

        switch (kode) {
            case "38":
                return (totalBelanja > 1000000) ? (int)(0.05 * totalBelanja) : 0;
            case "56":
                return (totalBelanja > 1000000) ? (int)(0.07 * totalBelanja) : (int)(0.02 * totalBelanja);
            case "74":
                return (totalBelanja > 1000000) ? (int)(0.10 * totalBelanja) : (int)(0.05 * totalBelanja);
            default:
                return 0;
        }
    }

    // Menampilkan informasi akun
    public void tampilkanInfo() {
        System.out.println("Pelanggan: " + nama + " | No: " + noPelanggan + " | Saldo: Rp" + saldo);
    }
}
public class MainTransaksi {
    public static void main(String[] args) {
        // Membuat 3 pelanggan
        Pelanggan p1 = new Pelanggan("3812345678", "Aldi", 2000000, "1234");
        Pelanggan p2 = new Pelanggan("5612345678", "Budi", 1500000, "5678");
        Pelanggan p3 = new Pelanggan("7412345678", "Citra", 900000, "9999");

        // Contoh transaksi
        p1.tampilkanInfo();
        p1.beli("3812345678", "1234", 1200000);
        p1.topUp("3812345678", "1234", 300000);

        System.out.println("====");

        p2.beli("5612345678", "5678", 800000); // total belanja < 1jt → cashback kecil
        System.out.println("====");

        // Tes salah PIN
        p3.beli("7412345678", "0000", 300000);
        p3.beli("7412345678", "1111", 300000);
        p3.beli("7412345678", "2222", 300000); // akun akan diblokir
        p3.topUp("7412345678", "9999", 100000); // tidak bisa karena akun diblokir
    }
}