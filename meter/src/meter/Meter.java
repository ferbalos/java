package meter;

import java.io.FileNotFoundException;
import java.io.IOException;

import logic.Count;
import logic.Parse;

public class Meter {

	public static void main(String[] args) {
		

		String file = "/home/fernando/Git/java/meter/ejemplo.csv";
		String splitBy = ",";
		int linesHeader = 1;
		int dataHead = 4;
		int dataTail = 3;
		Parse parse = new Parse();
		Count count = new Count();
		
		try {
			count.getCountLines(file);
			count.getCountColumns(file, splitBy, linesHeader);
			parse.getHeaders(file, linesHeader);
			parse.getData(file, linesHeader);
			//parse.getDataHead(file, linesHeader, dataHead);
			//parse.getDataTail(file, linesHeader, dataTail);
		} catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
