package io;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class FileHandler {
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

	public static boolean skipToShortLines = true;
	public static int headerLinesSkipped = 1;

	public static List<String[]> parseCSV(String fileName, char seperator,
			char quote) {

		try {
			// , is seperator and " is quote by default
			CSVReader reader = new CSVReader(new InputStreamReader(
					new FileInputStream(fileName), "UTF-8"), seperator, quote);
			List<String[]> list = new ArrayList<>();
			int nrOfFields = 0;
			int row = 0;
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				// skip first n lines
				if (row >= headerLinesSkipped) {

					// take the number of fields in the first line as indicator
					if (nrOfFields == 0)
						nrOfFields = nextLine.length;
					// add line if you don't skip lines or if the line has the
					// correct length
					if (!FileHandler.skipToShortLines
							|| nextLine.length == nrOfFields) {
						list.add(nextLine);
					}

				}
				row++;

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

	/*
	 * parse csv without quotes only works for unquoted single line csv files
	 */
	public static List<String[]> parseCSV(String fileName, String seperator) {
		BufferedReader in = null;
		List<String[]> list = new ArrayList<>();
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(
					fileName), "UTF8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String str;
		int row = 0;
		int nrOfFields = 0;
		String[] line;
		try {
			while ((str = in.readLine()) != null) {
				// skip first n lines
				if (row >= headerLinesSkipped) {
					// split line on ;
					line = str.split(seperator);
					// take the number of fields in the first line as indicator
					System.out.println(nrOfFields);
					if (nrOfFields == 0)
						nrOfFields = line.length;
					// add line if you don't skip lines or if the line has the
					// correct length
					if (!FileHandler.skipToShortLines
							|| line.length == nrOfFields) {
						list.add(line);
					}
				}
				row++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static List<String[]> parseCSV(String fileName) {
		return parseCSV(fileName, ";");
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

	public static List<String[]> parseCSVCommaAndQuotes(String fileName) {
		return parseCSV(fileName, ',', '"');
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
