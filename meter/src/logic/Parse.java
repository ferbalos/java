package logic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;

public class Parse {
	private LineNumberReader line;
	private int linesHeader;

	public void getHeaders(String file, String splitBy, int linesHeader) throws IOException {
		line = new ReadLine().readLine(file);

		this.linesHeader = linesHeader;
		String[] header;
		String strLine = "";

		System.out.println("\n<---HEADER--->");
		while ((strLine = line.readLine()) != null && line.getLineNumber() <= this.linesHeader) {
			System.out.println("L"+line.getLineNumber()+": "+strLine);
		}
		line.close();
	}//eogetHeaders
	
	public void getData(String file, String splitBy, int linesHeader) throws IOException {
		line = new ReadLine().readLine(file);

		this.linesHeader = linesHeader;
		String[] header;
		String strLine = "";

		System.out.println("\n<---RECORDS--->");
		while ((strLine = line.readLine()) != null) {
			if ((line.getLineNumber()) > this.linesHeader) {
			System.out.println("L"+line.getLineNumber()+": "+strLine);
			}
		}
		line.close();
	}//eogetData
	
	

}// eoclass
