package com.hugefileprocessinjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

public class ReaderObject {

	private Reader is;

	private BufferedReader reader;

	public ReaderObject(File file) {
		try {
			is = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.reader = new BufferedReader(is);
	}

	public List<String> readLines() {
		List<String> lines = new LinkedList<>();
		try {
			String line = null;

			int count = 0;
			// read 1000 lines and give result back to thread for processing
			while ((line = reader.readLine()) != null && count < 1000) {
				lines.add(line);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
