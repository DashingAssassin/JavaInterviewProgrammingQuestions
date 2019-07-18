package com.hugefileprocessinjava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Task implements Callable<Map<String, Integer>> {

	List<String> list;

	public Task(List<String> list) {
		this.list = list;
	}

	@Override
	public Map<String, Integer> call() throws Exception {
		Map<String, Integer> listOfWords = new HashMap<>();
		for (String string : list) {
			String[] delimitorSplit = getSplit(string, " ");
			BiFunction<? super String, ? super Map<String, Integer>, ? super Map<String, Integer>> func = getAction();
			for (String string2 : delimitorSplit) {
				func.apply(string2, listOfWords);
			}
		}

		return listOfWords;
	}

	private BiFunction<? super String, ? super Map<String, Integer>, ? super Map<String, Integer>> getAction() {
		BiFunction<? super String, ? super Map<String, Integer>, ? super Map<String, Integer>> func = (a, b) -> {
			if (b.containsKey(a)) {
				b.put(a, b.get(a) + 1);
			} else {
				b.put(a, 1);
			}
			return b;

		};

		return func;
	}

	private String[] getSplit(String string, String string2) {
		return string.split(string2);
	}
}
