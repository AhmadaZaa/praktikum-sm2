import java.util.Scanner;

class Aritmatika {
    // Static method: Penjumlahan & Pengurangan
    public static void hitungPenjumlahan(int a, int b) {
        int hasil = a + b;
        System.out.println("Hasil penjumlahan adalah: " + hasil);
    }

    public static void hitungPengurangan(int a, int b) {
        int hasil = a - b;
        System.out.println("Hasil pengurangan adalah: " + hasil);
    }

    // Non-static method: Perkalian & Pembagian
    public void hitungPerkalian(int a, int b) {
        int hasil = a * b;
        System.out.println("Hasil perkalian adalah: " + hasil);
    }

    public void hitungPembagian(int a, int b) {
        if (b != 0) {
            int hasil = a / b;
            System.out.println("Hasil pembagian adalah: " + hasil);
        } else {
            System.out.println("Pembagian dengan 0 tidak valid!");
        }
    }

    // Method untuk menyederhanakan pecahan
    public void sederhana(int pembilang, int penyebut) {
        int fpb = cariFPB(pembilang, penyebut);
        pembilang /= fpb;
        penyebut /= fpb;
        System.out.println("Pecahan setelah disederhanakan: " + pembilang + "/" + penyebut);
    }

    // Helper method cari FPB
    private int cariFPB(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

public class Kalkulator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Aritmatika a = new Aritmatika();

        // Input 2 nilai
        System.out.print("Masukkan nilai 1: ");
        int x = in.nextInt();
        System.out.print("Masukkan nilai 2: ");
        int y = in.nextInt();

        // Pemanggilan static method
        Aritmatika.hitungPenjumlahan(x, y);
        Aritmatika.hitungPengurangan(x, y);

        // Pemanggilan non-static method
        a.hitungPerkalian(x, y);
        a.hitungPembagian(x, y);

        // Uji penyederhanaan pecahan
        System.out.print("Masukkan pembilang pecahan: ");
        int pembilang = in.nextInt();
        System.out.print("Masukkan penyebut pecahan: ");
        int penyebut = in.nextInt();
        a.sederhana(pembilang, penyebut);
    }
}
