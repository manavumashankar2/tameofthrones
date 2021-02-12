package geektrust.geektrust;

public class Decryption {
	public static final String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String decryptString(String name , String encodedStr) {
		int alphabetsLen = alphabets.length() ;
		KingdomDataRegistry data = new KingdomDataRegistry() ; 
		int shift = data.getKingdomData(name).length() ; 
		
		String decodedStr = "";

		for (int i = 0; i < encodedStr.length(); i++) {
			int mappingAlph = alphabets.indexOf(encodedStr.charAt(i));
			int deVal = (mappingAlph - shift) % alphabetsLen ;
			deVal = ( deVal < 0 ? (alphabetsLen + deVal ) : deVal) ;
			char decodedChar = alphabets.charAt(deVal); // the character to be replaced
			decodedStr = decodedStr + decodedChar; // adding to decoded string
		}
		    
        return decodedStr;
	}
}
	
