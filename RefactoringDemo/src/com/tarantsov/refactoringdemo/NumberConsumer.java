package com.tarantsov.refactoringdemo;

public interface NumberConsumer {

	void consumeNumber(int index, int number);

	void close();

}