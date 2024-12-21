import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Operation operation = new Operation();
    }
}

class Operation {
    private Scanner scanner;
    private Tree tree;
    private Stack stack;
    private Queue queue;

    public Operation() {
        scanner = new Scanner(System.in);
        tree = new Tree();
        stack = new Stack();
        queue = new Queue();
        createDefaultData();
        start();
    }

    private void start() {
        while (true) {
            System.out.println("\n== KAMUS KATA BY KELOMPOK 9 ==");
            System.out.println("1. Cari kata");
            System.out.println("2. Tampilkan semua kata");
            System.out.println("3. Hapus kata");
            System.out.println("4. Riwayat kata yang dihapus");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> findWord();
                case 2 -> showAllWords();
                case 3 -> deleteWord();
                case 4 -> showDeletedHistory();
                case 5 -> exit();
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void findWord() {
        System.out.print("Masukkan awalan kata yang ingin dicari: ");
        String prefix = scanner.nextLine().toLowerCase();
        if (tree.search(prefix)) {
            System.out.println("Kata dengan awalan '" + prefix + "' ditemukan.");
            tree.printWords(prefix);
        } else {
            System.out.println("Tidak ada kata dengan awalan '" + prefix + "'");
        }
    }

    private void showAllWords() {
        System.out.println("Pilih urutan pengurutan:");
        System.out.println("1. Urutkan Ascending");
        System.out.println("2. Urutkan Descending");
        System.out.println("3. Tampilkan tanpa pengurutan");
        System.out.print("Masukkan pilihan Anda: ");
        int orderChoice = scanner.nextInt();
        scanner.nextLine();

        switch (orderChoice) {
            case 1 -> {
                tree.bubbleSortAscending();
                System.out.println("Kata telah diurutkan secara ascending.");
                tree.printWords(""); 
            }
            case 2 -> {
                tree.bubbleSortDescending();
                System.out.println("Kata telah diurutkan secara descending.");
                tree.printWords(""); 
            }
            case 3 -> tree.printWords(""); 
            default -> System.out.println("Pilihan tidak valid!");
        }
    }

    private void deleteWord() {
        System.out.print("Masukkan kata yang ingin dihapus: ");
        String word = scanner.nextLine().toLowerCase();
        tree.delete(word);
        queue.enqueue(word); 
        System.out.println("Kata '" + word + "' berhasil dihapus.");
    }

    private void showDeletedHistory() {
        System.out.println("Riwayat kata yang dihapus:");
        queue.print();
    }

    private void exit() {
        System.out.println("Terima kasih telah menggunakan kamus!");
        System.exit(0);
    }

    private void createDefaultData() {
       
        tree.insert("ana");
        tree.insert("angga");
        tree.insert("surya");
        tree.insert("nurul");
        tree.insert("novi");
        tree.insert("nana");
    }
}
