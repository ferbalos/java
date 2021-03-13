package logic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class Count {
	
	private LineNumberReader line;
	private int linesHeader;
	private int lineCount;
	private int columnCount;
	
	public int countLines(String file) throws IOException {
		line = new ReadLine().readLine(file);
		lineCount = 0;
		String strLine = "";

		while ((strLine = line.readLine()) != null) {
			lineCount++;
		}
		line.close();
		return lineCount;
	}//eocountLines
	
	public void getCountLines(String file) throws IOException {
		System.out.println("Total lines on file: "+countLines(file));
	}//eogetCountLines
	
	public int countColumns(String file, String splitBy, int headerLine) throws IOException {
		line = new ReadLine().readLine(file);
		ArrayList<String> al;
		String strLine = "";
		
		if((strLine = line.readLine()) != null) {
			al = new ArrayList<String>(Arrays.asList(strLine.split(splitBy)));
			columnCount = al.size();
		}
		
		return columnCount;
	}
	
	public void getCountColumns(String file, String splitBy, int headerLine) throws IOException {
		System.out.println("Total columns on file: "+countColumns(file, splitBy, headerLine));
	}//eogetCountLines

}//eoclass
