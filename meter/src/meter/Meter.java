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
		Parse parse = new Parse();
		Count count = new Count();
		
		try {
			count.getCountLines(file);
			parse.getHeaders(file, splitBy, linesHeader);
			parse.getData(file, splitBy, linesHeader);
		} catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
