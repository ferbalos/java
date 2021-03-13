package logic;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Read {
	
	
	public FileReader getFile(String file) throws FileNotFoundException{
		FileReader fr = new FileReader(file);
		return fr;
		
	}
	


}
