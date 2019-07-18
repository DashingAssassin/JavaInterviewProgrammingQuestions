package com.hugefileprocessinjava;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessFile {

	public static void main(String[] args) {
		ReaderObject reader = new ReaderObject(new File("/abc.txt"));
		List<String> lists = null;
		do {
			lists = reader.readLines();
			ExecutorService service = Executors.newFixedThreadPool(3);
			Task task = new Task(lists);
			service.submit(task);
			service.shutdown();
		} while (lists != null);
	}

}
