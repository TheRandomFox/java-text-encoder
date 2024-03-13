import java.util.*;

public class Encoder {
    static boolean debugMode = false;

    public static void main(String[] args) throws Exception {
        String key;
        String plainText;
        String encodedText;
        int mode = 9; //init with arbitrary value that is not 1, 2, 5 or 0.
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Java Text Encoder -- by Abdul Halim Slamat (13/03/2023) \n");
        while (true) {
            // Main loop
            // Request userinput (encode or decode)
            System.out.println("Enter a number to select mode.");
            System.out.println("[1] Encode plain text \n[2] Decode encoded text \n[0] Close application");
            try {
                mode = scan.nextInt();
                scan.nextLine();
                if (mode == 1) {
                    /* Encode
                     * Request plaintext input & key. Ensure key is valid.
                    */
                    System.out.print("Enter plaintext message: ");
                    plainText = scan.nextLine().toUpperCase();
                    if (debugMode) {System.out.println("Debug: plainText: " + plainText);}
                    
                    System.out.print("Enter cypher key (1 character only): ");
                    key = scan.next().toUpperCase();
                    if (debugMode) {System.out.println("Debug: key: " + key);}

                    if (key.length()<=1 & Cypher.isValidChar(key)) {
                        if (key=="") {
                            key = "A"; //default value if no key provided
                        }
                        break;
                    }
                    else {
                        if (key.length()>1) {
                            System.out.println("Error: Invalid key. Too long.");
                        }
                        if (Cypher.isValidChar(key)==false) {
                            System.out.println("Error: Invalid character(s) used as key.");
                        }
                        System.out.println("\n"); //skip line for spacing
                        key = "";
                        scan.nextLine();
                        // let user try again
                    }
                    encodedText = encode(plainText, key);
                    System.out.println("Encoded message: " + encodedText + "\n\n");
                    mode = 9; //reset mode
                }
                else if (mode == 2) {
                    /* decode
                     * Request encoded text input (no key required)
                     */
                    System.out.print("Enter encoded message: ");
                    encodedText = scan.nextLine().toUpperCase();
                    key = String.valueOf(encodedText.charAt(0));
                
                    if (Cypher.isValidChar(key)) {
                        plainText = decode(encodedText, key);
                        System.out.println("Decoded message: " + plainText + "\n\n");
                    }
                    else {
                        System.out.println("Error: Invalid message format.\n");
                        scan.nextLine();
                    }
                    mode = 9; //reset mode
                }
                else if (mode == 5) {
                    /* Hidden mode: Toggle debug messages. 
                    */
                    System.out.print("[5]Toggle debug mode: ");
                    if (debugMode == false) {
                        debugMode = true;
                        System.out.println("Debug messages are now on.\n");
                    }
                    else {
                        debugMode = false;
                        System.out.println("Debug messages are now off.\n");
                    }
                    mode = 9; //reset mode
                }
                else if (mode == 0) {
                    System.out.println("Application is closing...");
                    scan.close();
                    System.exit(0);
                }
                else {
                    System.out.println("Invalid input.\n");
                    scan.nextLine();
                    mode = 9; //reset mode
                }
            } 
            catch (Exception ex) {
                System.out.println("Invalid input.\n");
                scan.nextLine();
            }
        }
    }

    static String encode (String pltext, String key) {
        /* Instantiate Cypher object. Init encodedText with key character.
         * For each character in pltext input...
         *      check if inputs contain characters not in table.
         *      If true, pass to Cypher.mapCharToCypher().
         *      Else, add to encodedText string as-is.
        */
        if (debugMode) {System.out.println("Debug: Encoder.encode() is running.");}

        Cypher cypr = new Cypher(key);
        String currChar;
        int charIndex;

        String encodedText = key; //reset existing data if any
        
        for (int i=0; i<pltext.length(); i++) {
            currChar = String.valueOf(pltext.charAt(i));
            if (Cypher.isValidChar(currChar)) {
                charIndex = Cypher.tableDefault.indexOf(currChar);
                encodedText += String.valueOf(cypr.tableEncoded.charAt(charIndex));
            }
            else {
                encodedText += currChar;
            }
        }
        if (debugMode) {System.out.println("Debug: encode() successful");}
        return encodedText;
    }

    static String decode (String entext, String key) {
        /* Decodes encodedText to plainText. Reverse of encode().
         * Uses first char in encoded text input as "key" value.
         */
        if (debugMode) {System.out.println("Debug: starting Encoder.decode() is running.");}

        String currChar;
        int charIndex;
        Cypher cypr = new Cypher(key);

        String pltext = ""; //reset existing data if any

        for (int i=1; i<entext.length(); i++) {
            currChar = String.valueOf(entext.charAt(i));
            if (Cypher.isValidChar(currChar)) {
                charIndex = cypr.tableEncoded.indexOf(currChar);
                pltext += String.valueOf(Cypher.tableDefault.charAt(charIndex));
            }
            else {
                pltext += currChar;
            }
        }
        if (debugMode) {System.out.println("Debug: decode() successful");}
        return pltext;
    }
}
