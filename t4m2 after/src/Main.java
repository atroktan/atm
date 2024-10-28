import java.util.Scanner;

class ATM {
    private double saldo = 1000;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.jalankanATM();
    }

    public void jalankanATM() {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = dapatkanInputPengguna();
            tanganiPilihan(pilihan);
        } while (pilihan != 4);
    }

    private void tampilkanMenu() {
        System.out.println("\nMenu ATM:");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Deposit");
        System.out.println("3. Tarik Tunai");
        System.out.println("4. Keluar");
        System.out.print("Pilih opsi: ");
    }

    private int dapatkanInputPengguna() {
        return scanner.nextInt();
    }

    private void tanganiPilihan(int pilihan) {
        switch (pilihan) {
            case 1:
                cekSaldo();
                break;
            case 2:
                deposit();
                break;
            case 3:
                tarikTunai();
                break;
            case 4:
                System.out.println("Terima kasih telah menggunakan ATM kami.");
                break;
            default:
                System.out.println("Opsi tidak valid. Silakan coba lagi.");
        }
    }

    private void cekSaldo() {
        System.out.println("Saldo saat ini: " + saldo);
    }

    private void deposit() {
        System.out.print("Masukkan jumlah deposit: ");
        double jumlah = scanner.nextDouble();
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Deposit berhasil. Saldo baru: " + saldo);
        } else {
            System.out.println("Jumlah deposit tidak valid.");
        }
    }

    private void tarikTunai() {
        System.out.print("Masukkan jumlah tarik tunai: ");
        double jumlah = scanner.nextDouble();
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Tarik tunai berhasil. Saldo baru: " + saldo);
        } else {
            System.out.println("Jumlah tidak valid atau saldo tidak cukup.");
        }
    }
}