package com.tarantsov.refactoringdemo;

import java.io.PrintStream;

public class PlainNumberPrinter implements NumberConsumer {

	private final PrintStream out;

	public PlainNumberPrinter(PrintStream out) {
		this.out = out;
	}

	public void consumeNumber(int index, int number) {
		out.println("" + number);
	}

	@Override
	public void close() {
	}

}
