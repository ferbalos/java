package logic;

import java.io.IOException;
import java.io.LineNumberReader;

public class Count {
	
	private LineNumberReader line;
	private int linesHeader;
	private int lineCount;
	
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

}//eoclass
