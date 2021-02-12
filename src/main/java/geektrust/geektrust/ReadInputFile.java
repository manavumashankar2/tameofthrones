package geektrust.geektrust;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadInputFile {
	
	static List<HashMap<String , String>> inputData = new ArrayList<HashMap<String ,String>>() ; 


	@Override
	public String toString() {
		return "ReadInputFile [inputData=" + inputData + "]";
	}


	public static List<HashMap<String, String>> getData(String filePath) {


		try 
		{
			File file = new File(filePath) ; 
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
			        String data = scan.nextLine();
			        String[] emblemStr = data.split(" ",2) ; 
					String name = emblemStr[0] ;
			        String str =  emblemStr[1].replace(" ", "") ; 
			        HashMap<String, String> map = new HashMap<String, String>() ; 
			        map.put(name, str) ; 
					inputData.add(map) ; 
			      }
			scan.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e);
		}
	     
		return inputData ; 
	}

}
