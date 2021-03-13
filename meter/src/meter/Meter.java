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
		int dataHead = 3;
		int dataTail = 2;
		Parse parse = new Parse();
		Count count = new Count();
		
		try {
			count.getCountLines(file);
			//parse.getHeaders(file, linesHeader);
			//parse.getData(file, linesHeader);
			//parse.getDataHead(file, linesHeader, dataHead);
			parse.getDataTail(file, linesHeader, dataTail);
		} catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
