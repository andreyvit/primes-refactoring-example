package com.tarantsov.refactoringdemo;

public class Primes {
	
    private static void computePrimes(int limit, boolean numbered) {
        int[] p = new int[limit];
        p[0] = 2;
        int n = 1;
        if (numbered)
        	System.out.println("1) 2");
        else
        	System.out.println("2");
        
        for (int k = 3; k < limit; k += 2) {
        	boolean prime = true;
            for (int i = 0; i < n; i++) {
                if (k % p[i] == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                p[n++] = k;
                if (numbered)
                	System.out.println(n + ") " + k);
                else
                	System.out.println("" + k);
            }
        }
    }
    
    public static void main(String[] args) {
    	computePrimes(50, true);
    }

}
