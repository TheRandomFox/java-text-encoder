//import java.util.*;

public class Cypher {
	/* Generates encoded character tables based on provided key. */
	String key;
	String tableEncoded;
	static final String tableDefault = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
	
	public Cypher(String key) {
		/* constructors */
		this.key = key;
		this.tableEncoded = generateCypher(key);
	}

	static boolean isValidChar(String inputChar) {
		/* Checks if input character belongs to the list of valid characters */
		if (Encoder.debugMode) {System.out.println("Debug: starting Cypher.isValidChar()... ");}
		return tableDefault.contains(inputChar);
	}
	
	String generateCypher(String key) {
		/* Generate encoded cypher table.
		 * Find offset 'distance' by locating index of given key within tableDefault. 
		 * Duplicate default table, slices off a chunk of String the length of offset from the back end,
		 * then reattaches the slice to the front of modified table.
		 */
		if (Encoder.debugMode) {System.out.println("Debug: starting Cypher.generateCypher()... ");}
		
		int offset = tableDefault.indexOf(key);
		if (Encoder.debugMode) {System.out.println("Debug: offset: "+offset);}
		String encoded = tableDefault;
		String temp = encoded.substring(encoded.length()-offset);
		encoded = encoded.substring(0,encoded.length()-offset);
		encoded = temp.concat(encoded);
		if (Encoder.debugMode) {
			System.out.println("Debug: generateCypher() successful.");
			System.out.println("Debug: tableEncoded: "+ encoded);
		}
		return encoded;
	}
}
