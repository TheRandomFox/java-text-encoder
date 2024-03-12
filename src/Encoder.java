import java.util.*;

public class Encoder {
    String plainText;
    String encodedText;
    String key;
    
    public static void main(String[] args) throws Exception {
        
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
                    // Request plaintext input, key (optional). Ensure key is valid.
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

    public String encode (String pltext, String key) {
        /* Generate Cypher object. Init encodedText with key character.
         * For each character in pltext input...
         *      check if inputs contain characters not in table.
         *      If true, pass to Cypher.mapCharToCypher().
         *      Else, add to encodedText string as-is.
        */
        Cypher cypher = new Cypher(key);
        String currChar;

        encodedText = key; //resets any existing data in encodedText
        for (int i=0; i<pltext.length(); i++) {
            currChar = String.valueOf(pltext.charAt(i));
            if (Cypher.isValidChar(currChar)) {
                encodedText += Cypher.mapCharToCypher(currChar, cypher);
            }
            else {
                encodedText += currChar;
            }
        }
        return encodedText;
    }

    // public String decode (String entext, String key)
}
