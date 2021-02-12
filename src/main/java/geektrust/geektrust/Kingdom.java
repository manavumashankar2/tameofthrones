package geektrust.geektrust;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class Kingdom {

	KingdomDataRegistry data =  new KingdomDataRegistry() ; 

	public String name ; 
	public String emblem ;
	private Set<String> allies ;
		
	public Kingdom( String name, String emblem) {
		Objects.requireNonNull(name , Messages.KINGDOM_NAME_NOT_NULL) ; 
		Objects.requireNonNull(emblem , Messages.KINGDOM_EMBLEM_NOT_NULL) ; 

		this.name = name;
		this.emblem = emblem;
		this.allies = new LinkedHashSet<String>();
	}

	public Set<String> sendMessage(List<HashMap<String, String>> inputData) {
				
		for ( Map<String , String > map : inputData ) {
			String decryptedStr = "" ; 
			for ( Entry<String, String> inputPair :  map.entrySet() ) { 
				decryptedStr = Decryption.decryptString( inputPair.getKey() , inputPair.getValue() ) ;
				
				if(ifSentMessageValid(decryptedStr ,data.getKingdomData(inputPair.getKey()))) {
					allies.add(inputPair.getKey()) ; 
				}
			}
		}
		
		return allies ; 
		
	}
	
	public static boolean ifSentMessageValid(String decryptedStr , String emblem) {
		
		for(int i = 0 ; i<decryptedStr.length() ; i++) {
			if(emblem.indexOf(decryptedStr.charAt(i))!=-1){
				emblem = emblem.replaceFirst(""+decryptedStr.charAt(i), "") ; 
			}
		}
		if(emblem.equals("")) {
			return true ; 
		}
		return false ; 
	}

	@Override
	public String toString() {
		return "Kingdom [name=" + name + ", emblem=" + emblem + ", allies=" + allies + "]";
	}
	
	
}
