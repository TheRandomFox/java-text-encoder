import java.util.*;

public class Encoder {
    public static void main(String[] args) throws Exception {
        String plainText;
        String encodedText;
        String key;
        int mode = 3; //init with arbitrary value that is not 1, 2 or 0.
        Scanner scan = new Scanner(System.in);

        System.out.println("Java Text Encoder -- by Abdul Halim Slamat \n");
        while (true) {
            // Main loop
            // Request userinput (encode or decode)
            System.out.println("Select mode. \n[1] Encode plain text \n[2] Decode encoded text \n[0] Close application");
            try {
                mode = scan.nextInt();
                if (mode == 1) {
                    // encode
                    // Request plaintext input, key (optional)
                }
                else if (mode == 2) {
                    // decode
                    // Request encoded text input (no key required)
                }
                else if (mode == 0) {
                    System.out.println("Application is closing...");
                    System.exit(0);
                }
                else {
                    System.out.println("Invalid input.\n");
                }
            } 
            catch (Exception ex) {
                System.out.println("Invalid input.\n");
            }
        }
    }

    public String encode (String plainText_in, String key) {
        // Generate cypher
        Cypher cypher = new Cypher(key);

        // Check if inputs contain characters not in table 
        
    }

    // public String decode (String encodedText_in, String key)
}
