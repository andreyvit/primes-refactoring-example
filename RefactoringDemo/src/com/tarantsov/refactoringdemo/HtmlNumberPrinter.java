package com.tarantsov.refactoringdemo;

import java.io.PrintStream;

public class HtmlNumberPrinter implements NumberConsumer {

	private final PrintStream out;

	public HtmlNumberPrinter(PrintStream out) {
		this.out = out;
		out.println("<ul>");
	}

	public void consumeNumber(int index, int number) {
		out.println("<li>" + number + "</li>");
	}

	@Override
	public void close() {
		out.println("</ul>");
	}

}
