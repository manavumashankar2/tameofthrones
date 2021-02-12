package geektrust.geektrust;

import java.util.HashMap;
import java.util.Map;

public class KingdomDataRegistry {

	public static Map<String , String> map = new HashMap<String, String>();
	
	KingdomDataRegistry(){
		map.put("LAND" ,  "PANDA" ) ; 
		map.put("WATER" , "OCTOPUS" ) ; 
		map.put("ICE" ,"MAMMOTH")  ; 
		map.put("AIR" , "OWL")  ; 
		map.put("FIRE" , "DRAGON" ) ; 
	}
	
	public void addNewKingdom(Kingdom kingdom) {
		this.map.put(kingdom.name, kingdom.emblem) ;
	}
	
	public String getKingdomData(String name){
		return this.map.get(name) ; 
	}

	@Override
	public String toString() {
		return "KingdomDataRegistry [map=" + map + "]";
	}
	
}
