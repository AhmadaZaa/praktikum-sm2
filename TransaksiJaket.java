import java.util.Scanner;

class Jaket {
    public static final int HARGA_JAKET_A = 100000;
    public static final int HARGA_JAKET_B = 125000;
    public static final int HARGA_JAKET_C = 175000;

    private int totalHarga = 0;
    private int totalDiskon = 0;

    public void beliJaketA(int jumlah) {
        int hargaAwal = HARGA_JAKET_A * jumlah;
        int hargaDiskon = (jumlah > 100) ? 95000 * jumlah : hargaAwal;
        if (jumlah > 100) {
            totalDiskon += (HARGA_JAKET_A - 95000) * jumlah;
        }
        totalHarga += hargaDiskon;
        System.out.println("Total harga jaket A: Rp " + hargaDiskon);
    }

    public void beliJaketB(int jumlah) {
        int hargaAwal = HARGA_JAKET_B * jumlah;
        int hargaDiskon = (jumlah > 100) ? 120000 * jumlah : hargaAwal;
        if (jumlah > 100) {
            totalDiskon += (HARGA_JAKET_B - 120000) * jumlah;
        }
        totalHarga += hargaDiskon;
        System.out.println("Total harga jaket B: Rp " + hargaDiskon);
    }

    public void beliJaketC(int jumlah) {
        int hargaAwal = HARGA_JAKET_C * jumlah;
        int hargaDiskon = (jumlah > 100) ? 160000 * jumlah : hargaAwal;
        if (jumlah > 100) {
            totalDiskon += (HARGA_JAKET_C - 160000) * jumlah;
        }
        totalHarga += hargaDiskon;
        System.out.println("Total harga jaket C: Rp " + hargaDiskon);
    }

    public void tampilkanTotal() {
        System.out.println("\n===============================");
        System.out.println(">> Total Diskon : Rp " + totalDiskon);
        System.out.println(">> Total Bayar  : Rp " + totalHarga);
        System.out.println("===============================\n");
    }

    public int getTotalHarga() {
        return totalHarga;
    }
}

public class TransaksiJaket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Jaket jaket = new Jaket();

        System.out.println("=== PROGRAM PEMBELIAN JAKET CV. LABKOMDAS ===\n");

        System.out.print("Masukkan jumlah jaket A yang dibeli: ");
        int jumlahA = input.nextInt();
        jaket.beliJaketA(jumlahA);

        System.out.print("Masukkan jumlah jaket B yang dibeli: ");
        int jumlahB = input.nextInt();
        jaket.beliJaketB(jumlahB);

        System.out.print("Masukkan jumlah jaket C yang dibeli: ");
        int jumlahC = input.nextInt();
        jaket.beliJaketC(jumlahC);

        jaket.tampilkanTotal();

        // Konfirmasi pembayaran
        System.out.print("Apakah Anda ingin melakukan pembayaran sekarang? (y/n): ");
        char konfirmasi = input.next().charAt(0);
        if (konfirmasi == 'y' || konfirmasi == 'Y') {
            System.out.println(">> Pembayaran sejumlah Rp " + jaket.getTotalHarga() + " berhasil dilakukan.");
            System.out.println(">> Terima kasih sudah berbelanja di CV. Labkomdas :)");
        } else {
            System.out.println(">> Transaksi dibatalkan. Silakan kembali jika ingin berbelanja.");
        }
    }
}