package logic;

import java.io.IOException;
import java.io.LineNumberReader;

public class Parse {
	private LineNumberReader line;

	public void getHeaders(String file, int linesHeader) throws IOException {
		line = new ReadLine().readLine(file);

		String strLine = "";

		System.out.println("\n<---HEADER--->");
		while ((strLine = line.readLine()) != null && line.getLineNumber() <= linesHeader) {
			System.out.println("L" + line.getLineNumber() + ": " + strLine);
		}
		line.close();
	}// eogetHeaders

	public void getData(String file, int linesHeader) throws IOException {
		line = new ReadLine().readLine(file);

		String strLine = "";

		System.out.println("\n<---RECORDS--->");
		while ((strLine = line.readLine()) != null) {
			if ((line.getLineNumber()) > linesHeader) {
				System.out.println("L" + line.getLineNumber() + ": " + strLine);
			}
		}
		line.close();
	}// eogetData

	public void getDataHead(String file, int linesHeader, int dataHead) throws IOException {
		line = new ReadLine().readLine(file);
		int lineCount = 0;
		Count count = new Count();
		int total = count.countLines(file);

		String strLine = "";

		System.out.println("\n<---RECORDS--->");
		while ((strLine = line.readLine()) != null) {
			lineCount++;
			if (lineCount > linesHeader && lineCount <= dataHead + 1) {
				System.out.println("L" + line.getLineNumber() + ": " + strLine);
			}

		}
		if (dataHead > (total - linesHeader)) {
			System.out.println("<---EOF--->");
		}
		line.close();
	}// eogetDataHead

	public void getDataTail(String file, int linesHeader, int dataTail) throws IOException {
		Count count = new Count();
		int total = count.countLines(file);
		line = new ReadLine().readLine(file);
		// moves lineReader to EOF
		//line.setLineNumber(total);

		int lineCount = 0;

		String strLine = "";

		System.out.println("\n<---RECORDS--->");
		if(dataTail < total) {
			while(lineCount < dataTail) {
				lineCount++;
				
				// aquí está el fallo
				line.mark(total-lineCount);
				line.reset();
				line.setLineNumber(total-lineCount);
				
				strLine = line.readLine();
				System.out.println(total);
				System.out.println("L" + line.getLineNumber() + ": " + strLine);
			}
		}

					




		if (dataTail > (total - linesHeader)) {
			System.out.println("<---Too much records!--->");
		}
		line.close();
	}// eogetDataTail

}// eoclass
