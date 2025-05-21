import java.util.*;

public class GamePetualangan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, User> users = new HashMap<>();
        Random random = new Random();

        while (true) {
            System.out.println("\n=== Game Petualangan ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            int menu = scanner.nextInt(); scanner.nextLine();

            if (menu == 1) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                if (users.containsKey(username)) {
                    System.out.println("Username sudah digunakan!");
                } else {
                    users.put(username, new User(username, password));
                    System.out.println("Registrasi berhasil!");
                }
            } else if (menu == 2) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                User user = users.get(username);
                if (user != null && user.checkPassword(password)) {
                    System.out.println("Login berhasil!");
                    int posisi = 0;
                    while (true) {
                        System.out.println("\nPosisi saat ini: " + posisi);
                        System.out.println("1. Maju");
                        System.out.println("2. Mundur");
                        System.out.println("3. Keluar");
                        System.out.print("Pilih: ");
                        int aksi = scanner.nextInt();

                        if (aksi == 1) {
                            posisi++;
                            tampilkanEvent(random);
                        } else if (aksi == 2) {
                            posisi--;
                            tampilkanEvent(random);
                        } else {
                            System.out.println("Keluar dari game.");
                            break;
                        }
                    }
                } else {
                    System.out.println("Login gagal!");
                }
            } else {
                System.out.println("Terima kasih!");
                break;
            }
        }

        scanner.close();
    }

    static void tampilkanEvent(Random random) {
        int event = random.nextInt(3);
        if (event == 0) {
            System.out.println(">> Kamu menemukan item!");
        } else if (event == 1) {
            System.out.println(">> Kamu bertemu musuh!");
        } else {
            System.out.println(">> Tidak terjadi apa-apa.");
        }
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkPassword(String input) {
        return this.password.equals(input);
    }
}
