package geektrust.geektrust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Geektrust {
		
	public static void main(String[] args) {
		
		KingdomDataRegistry data =  new KingdomDataRegistry() ; 
		String filePath = args[0] ; 
		Set<String> set = new LinkedHashSet<String>() ; 
		
		List<HashMap<String , String>> inputData = new ArrayList<HashMap<String ,String>>() ; 
		
		inputData = ReadInputFile.getData(filePath) ; 
		
		Kingdom sender = new Kingdom("SPACE", "GORILLA") ; 
		data.addNewKingdom(sender);
		set = sender.sendMessage(inputData ) ; 
		
		//if 3 or more unique kingdoms allied
		if(set.size()>=3) {
			System.out.print(sender.name);
			for(String ele : set ) {
				System.out.print(" "+ele);
			}
		}
		else {
			System.out.println("NONE");
		}
	}
	
	
	

}
