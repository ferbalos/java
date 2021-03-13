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
			System.out.println("<---End of line records--->");
		}
		line.close();
	}// eogetDataHead

	public void getDataTail(String file, int linesHeader, int dataTail) throws IOException {
		Count count = new Count();
		int total = count.countLines(file);
		line = new ReadLine().readLine(file);
		int lineCount = 0;
		String strLine = "";

		System.out.println("\n<---RECORDS--->");
		if (dataTail <= total-linesHeader) {
			for (int i = 0; i < total; i++) {
				lineCount++;
				if (dataTail >= total - i) {
					strLine = line.readLine();
					System.out.println("L" + line.getLineNumber() + ": " + strLine);
				} else {
					strLine = line.readLine();
				}
			}

		} else {
			System.out.println("<---There are only "+(total-linesHeader)+" line records!--->");
			System.out.println("(The header spans "+linesHeader+" line(s))");
		}
		line.close();
	}// eogetDataTail
	
	//Método para que recorra el fichero, divida la línea en campos y cuente los caracteres de cada campo.

}// eoclass
