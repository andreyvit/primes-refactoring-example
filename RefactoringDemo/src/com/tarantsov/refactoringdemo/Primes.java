package com.tarantsov.refactoringdemo;


public class Primes {

	public static void computePrimes(int limit, NumberConsumer consumer) {
		if (limit < 2)
			return;
		
		int[] primes = new int[limit];
		primes[0] = 2;
		int primeCount = 1;
		consumer.consumeNumber(1, 2);

		for (int candidate = 3; candidate <= limit; candidate += 2) {
			boolean isPrime = candidateIsPrime(primes, primeCount, candidate);
			if (isPrime) {
				primes[primeCount++] = candidate;
				consumer.consumeNumber(primeCount, candidate);
			}
		}
	}

	private static boolean candidateIsPrime(int[] primes, int primeCount,
			int candidate) {
		boolean isPrime = true;
		for (int index = 0; index < primeCount; index++) {
			if (candidate % primes[index] == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	public static void main(String[] args) {
		NumberConsumer consumer = new HtmlNumberPrinter(System.out);
		computePrimes(50, consumer);
		consumer.close();
	}

}
