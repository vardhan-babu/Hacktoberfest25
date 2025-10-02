import java.util.Scanner;

public class MultiplicativeCipher {
    // Encrypt function
    public static String encrypt(String plaintext, int key) {
        StringBuilder result = new StringBuilder();
        plaintext = plaintext.toUpperCase();

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                int x = c - 'A';  // Convert letter to number (0–25)
                int enc = (x * key) % 26; // Multiplication cipher
                result.append((char) (enc + 'A'));
            } else {
                result.append(c); // Keep spaces/punctuation unchanged
            }
        }
        return result.toString();
    }

    // Modular inverse function using Extended Euclidean Algorithm
    public static int modInverse(int key, int m) {
        for (int i = 1; i < m; i++) {
            if ((key * i) % m == 1) {
                return i;
            }
        }
        return -1; // No inverse (invalid key)
    }

    // Decrypt function
    public static String decrypt(String ciphertext, int key) {
        int inverse = modInverse(key, 26);
        if (inverse == -1) {
            throw new IllegalArgumentException("Invalid key! No modular inverse exists.");
        }

        StringBuilder result = new StringBuilder();
        ciphertext = ciphertext.toUpperCase();

        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                int y = c - 'A';
                int dec = (y * inverse) % 26; 
                result.append((char) (dec + 'A'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String plaintext = sc.nextLine();

        System.out.print("Enter key (must be coprime with 26): ");
        int key = sc.nextInt();

        String encrypted = encrypt(plaintext, key);
        System.out.println("Encrypted text: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted text: " + decrypted);

        sc.close();
    }
}
