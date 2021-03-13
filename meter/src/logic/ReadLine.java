package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;

public class ReadLine {
	public LineNumberReader readLine(String file) throws FileNotFoundException, UnsupportedEncodingException{
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		LineNumberReader lineReader = new LineNumberReader(isr);
		
		return lineReader;
		
	}//eoreadLine

}//eoClass
