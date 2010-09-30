package com.tarantsov.refactoringdemo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;

import junit.framework.Assert;

import org.junit.Test;

public class PriceTest {

	private String doItBaby(int limit, Class<?> printerClass) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		Constructor<?> constructor = printerClass.getConstructor(PrintStream.class);
		NumberConsumer consumer = (NumberConsumer) constructor.newInstance(ps);
		
		Primes.computePrimes(limit, consumer);
		consumer.close();
		return new String(baos.toByteArray(), "latin1");
	}

	@Test
	public void listOfPrimesUpTo10NonNumberedIsCorrect() throws Exception {
		String string = doItBaby(10, PlainNumberPrinter.class);
		Assert.assertEquals("2\n3\n5\n7\n", string);
	}

	@Test
	public void listOfPrimesUpTo10NumberedIsCorrect() throws Exception {
		String string = doItBaby(10, IndexedNumberPrinter.class);
		Assert.assertEquals("1) 2\n2) 3\n3) 5\n4) 7\n", string);
	}
	
	@Test
	public void listOfPrimesUpTo10HtmlIsCorrect() throws Exception {
		String string = doItBaby(10, HtmlNumberPrinter.class);
		Assert.assertEquals("<ul>\n<li>2</li>\n<li>3</li>\n<li>5</li>\n" + 
				"<li>7</li>\n</ul>\n", string);
	}
	
	@Test
	public void listOfPrimesShouldIncludeLimit() throws Exception {
		String string = doItBaby(11, IndexedNumberPrinter.class);
		Assert.assertEquals("1) 2\n2) 3\n3) 5\n4) 7\n5) 11\n", string);
	}

	@Test
	public void listOfPrimesUpTo1ShouldBeEmpty() throws Exception {
		String string = doItBaby(1, IndexedNumberPrinter.class);
		Assert.assertEquals("", string);
	}

}
