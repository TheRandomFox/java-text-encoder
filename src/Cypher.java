//import java.util.*;

public class Cypher {
	/* Generates encoded character tables based on provided key. */
	String key;
	String tableEncoded;
	static final String tableDefault = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
	
	public Cypher(String key_in) {
		/* constructor */
		key = key_in;
		tableEncoded = generateCypher(key_in);
	}

	boolean isValidChar(String inputChar) {
		/* Checks if input character belongs to the list of valid characters */
		boolean isValid = tableDefault.contains(inputChar);
		return isValid;
	}
	
	String generateCypher(String key) {
		/* Generate encoded cypher table.
		 * Find offset 'distance' by locating index of given key (case-insensitive) 
		 * within tableDefault. Duplicate into new String and shift positions of chars accordingly.
		 */
		int offset = tableDefault.indexOf(key);
		String encoded = tableDefault;
		String temp = encoded.substring(encoded.length()-1-offset);
		encoded = encoded.substring(0,encoded.length()-offset);
		encoded = temp.concat(encoded);
		
		System.out.println("Debug: tableEncoded: "+ encoded);
		return encoded;
	}
}
