package io;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class FileHandler {
	private static String configPath="./config";
	public static void overwriteFile(String filename, String text) {
		FileOutputStream fos = null;
		try {
			// don't append, but overwrite
			fos = new FileOutputStream(filename, false);
			fos.write(text.getBytes("UTF-8"));
		} catch (IOException e) {
			FileHandler.close(fos);
		}
	}

	public static void appendToFile(String filename, String text) {
		FileOutputStream fos = null;
		try {
			// append
			fos = new FileOutputStream(filename, true);
			fos.write(text.getBytes("UTF-8"));
		} catch (IOException e) {
			FileHandler.close(fos);
		}
	}

	private static InputStream getInputStream(String path) {
		System.out.println(path);
		return FileHandler.class.getClassLoader().getResourceAsStream(path);
	}

	// private static OutputStream getOutpuStream(String path){
	// return FileHandler.class.getClassLoader()
	// .getResourceAsStream(path);
	// }
	public static List<String[]> parseCSV(String fileName, char seperator,
			char quote, int headerLinesSkipped, boolean skipTooShortLines) {

		try {
			// , is seperator and " is quote by default
			CSVReader reader = new CSVReader(new InputStreamReader(
					new FileInputStream(fileName), "UTF-8"), seperator, quote,
					headerLinesSkipped);
			List<String[]> list = new ArrayList<>();
			int nrOfFields = 0;
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				// take the number of fields in the first line as indicator
				if (nrOfFields == 0)
					nrOfFields = nextLine.length;
				// add line if you don't skip lines or if the line has the
				// correct length
				if (!skipTooShortLines || nextLine.length == nrOfFields) {
					list.add(nextLine);
				}

			}
			reader.close();
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// error
		return null;
	}

	public static List<String[]> parseCSV(String fileName) {
		return parseCSV(fileName, ',', '\"', 1, true);
	}

	public static void writeCSV(String fileName, List<String[]> lines,
			boolean append) {
		CSVWriter writer;
		try {
			OutputStreamWriter stream = new OutputStreamWriter(
					new FileOutputStream(fileName, append), "UTF-8");
			writer = new CSVWriter(stream);
			writer.writeAll(lines);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void cacheCSVMapping(List<String[]> csv,
			Map<String, String> map) {
		for (String[] line : csv) {
			map.put(line[0], line[1]);
		}
	}

	public static void flushCSVMapping(Map<String, String> map,
			String[] header, String fileName) {
		List<String[]> mapping = new ArrayList<>();
		mapping.add(header);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			mapping.add(new String[] { entry.getKey(), entry.getValue() });

		}
		// overwrite
		writeCSV(fileName, mapping, false);
	}

	private static void close(Closeable closeable) {
		try {
			closeable.close();
		} catch (IOException ignored) {
		}
	}

	public static void openFileSaverForText(String text) {
		// save drawing as txt;
		FileDialog fc = new FileDialog(new Frame(), "Save", FileDialog.SAVE);
		fc.setFile("*.txt");
		fc.setVisible(true);
		String fn = fc.getFile();
		String path = fc.getDirectory();
		if (fn != null && fn != "") {
			try {
				FileWriter fw = new FileWriter(path + "/" + fn);
				fw.write(text);
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
