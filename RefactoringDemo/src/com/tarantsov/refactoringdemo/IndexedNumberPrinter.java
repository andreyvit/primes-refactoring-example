package com.tarantsov.refactoringdemo;

import java.io.PrintStream;

public class IndexedNumberPrinter implements NumberConsumer {

	private final PrintStream out;

	public IndexedNumberPrinter(PrintStream out) {
		this.out = out;
	}

	public void consumeNumber(int index, int number) {
		out.println(index + ") " + number);
	}

	@Override
	public void close() {
	}

}
