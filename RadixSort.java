//Lab 7
//Lab Partners:

//Xiaoxiang "Steven" Liu
//xliu102@u.rochester.edu
//MW 6:15PM - 7:30PM

//Grant Yap
//gyap@u.rochester.edu
//MW 2:00 - 3:15PM

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class RadixSort{
	
	
	//Base 10
	static int maxDigit(Integer[] A) {
		int biggest = A[0];
		int digits = 0;
		for(int i = 0; i < A.length; i++) {
			//System.out.println("x");
			if(A[i] > biggest) {
				biggest = A[i];
			}
		}
		//System.out.println(biggest);
		while(biggest > 0) {
			digits += 1;
			biggest = biggest/10;
		}
		return digits;
	}
	
	static int maxDigit2(Integer[] A) {
		int biggest = A[0];
		int digits = 0;
		for(int i = 0; i < A.length; i++) {
			//System.out.println("x");
			if(A[i] > biggest) {
				biggest = A[i];
			}
		}
		String bin = toBinary(biggest);
		return bin.length();
	}
	
	static String toBinary(int n) {
	       if (n == 0) {
	           return "0";
	       }
	       String binary = "";
	       while (n > 0) {
	           int rem = n % 2;
	           binary = rem + binary;
	           n = n / 2;
	       }
	       return binary;
	}
	
	static void radix(Integer[] A, int digit) {
		Integer[] B = new Integer[A.length];
		int[] count = new int[A.length];
		// Count[i] stores number of records in bin[i]
		int i, j, rtok;
		for (i=0, rtok=1; i<digit; i++, rtok*=10) { // For k digits
			for (j=0; j<10; j++) count[j] = 0;    // Initialize count
			// Count the number of records for each bin on this pass
			for (j=0; j<A.length; j++) count[(A[j]/rtok)%10]++;
			// count[j] will be index in B for last slot of bin j.
			for (j=1; j<10; j++) count[j] = count[j-1] + count[j];
			// Put records into bins, working from bottom of bin
			// Since bins fill from bottom, j counts downwards
			for (j=A.length-1; j>=0; j--)
				B[--count[(A[j]/rtok)%10]] = A[j];
			for (j=0; j<A.length; j++) A[j] = B[j]; // Copy B back
		}
	}
	//Base 2
	static void radix2(Integer[] A, int digit) {
		Integer[] B = new Integer[A.length];
		int[] count = new int[A.length];
		// Count[i] stores number of records in bin[i]
		int i, j;
		for (i=0; i<digit; i++) { // For k digits
			for (j=0; j<2; j++) count[j] = 0;    // Initialize count
			// Count the number of records for each bin on this pass
			for (j=0; j<A.length; j++) count[(A[j]>>i)&1]++;
			// count[j] will be index in B for last slot of bin j.
			for (j=1; j<2; j++) count[j] = count[j-1] + count[j];
			// Put records into bins, working from bottom of bin
			// Since bins fill from bottom, j counts downwards
			for (j=A.length-1; j>=0; j--)
				B[--count[(A[j]>>i)&1]] = A[j];
			for (j=0; j<A.length; j++) A[j] = B[j]; // Copy B back
		}
	}
	
	public static void main(String[] args) {
		//1K
		System.out.println("1K");
		Integer[] arr1 = new Integer[1000];
		Integer[] arr2 = new Integer[1000];
		for(int i = 0; i < 1000; i++) {
			arr1[i] = (int)(Math.random() * 100);
			arr2[i] = arr1[i];
		}
		int d1 = maxDigit(arr1);
		int d2 = maxDigit2(arr2);
		Stopwatch timer = new Stopwatch();
		radix(arr1, d1);
        double time = timer.elapsedTimeMillis();
		System.out.println(time);
        timer = new Stopwatch();
		radix2(arr2, d2);
        double time2 = timer.elapsedTimeMillis();
		System.out.println(time2);
		/*
		for(int i = 0; i < 1000; i++) {
			System.out.println(arr1[i] + " " + arr2[i]);
		}
		*/
		
		//8K
		System.out.println("8K");
		Integer[] arr3 = new Integer[8000];
		Integer[] arr4 = new Integer[8000];
		for(int i = 0; i < 8000; i++) {
			arr3[i] = (int)(Math.random() * 100);
			arr4[i] = arr3[i];
		}
		int d3 = maxDigit(arr3);
		int d4 = maxDigit2(arr4);
		timer = new Stopwatch();
		radix(arr3, d3);
        double time3 = timer.elapsedTimeMillis();
		System.out.println(time3);
		
        timer = new Stopwatch();
		radix2(arr4, d4);
        double time4 = timer.elapsedTimeMillis();
		System.out.println(time4);
		
		
		
		//32K
		System.out.println("32K");
		Integer[] arr5 = new Integer[32000];
		Integer[] arr6 = new Integer[32000];
		for(int i = 0; i < 32000; i++) {
			arr5[i] = (int)(Math.random() * 1000);
			arr6[i] = arr5[i];
		}
		int d5 = maxDigit(arr5);
		int d6 = maxDigit2(arr6);
		timer = new Stopwatch();
		radix(arr5, d5);
        double time5 = timer.elapsedTimeMillis();
		System.out.println(time5);
		
        timer = new Stopwatch();
		radix2(arr6, d6);
        double time6 = timer.elapsedTimeMillis();
		System.out.println(time6);
		
		//64K
		System.out.println("64K");
		Integer[] arr7 = new Integer[64000];
		Integer[] arr8 = new Integer[64000];
		for(int i = 0; i < 64000; i++) {
			arr7[i] = (int)(Math.random() * 1000);
			arr8[i] = arr7[i];
		}
		int d7 = maxDigit(arr7);
		int d8 = maxDigit2(arr8);
		timer = new Stopwatch();
		radix(arr7, d7);
        double time7 = timer.elapsedTimeMillis();
		System.out.println(time7);
				
		timer = new Stopwatch();
		radix2(arr8, d8);
		double time8 = timer.elapsedTimeMillis();
		System.out.println(time8);
		
		//1M
		System.out.println("1M");
		Integer[] arr9 = new Integer[1000000];
		Integer[] arr10 = new Integer[1000000];
		for(int i = 0; i < 1000000; i++) {
			arr9[i] = (int)(Math.random() * 1000);
			arr10[i] = arr9[i];
		}
		int d9 = maxDigit(arr7);
		int d10 = maxDigit2(arr8);
		timer = new Stopwatch();
		radix(arr9, d9);
		double time9 = timer.elapsedTimeMillis();
		System.out.println(time9);
						
		timer = new Stopwatch();
		radix2(arr10, d10);
		double time10 = timer.elapsedTimeMillis();
		System.out.println(time10);
		
	}
	
	
	class StdOut {

	    // force Unicode UTF-8 encoding; otherwise it's system dependent
	    private static final String CHARSET_NAME = "UTF-8";

	    // assume language = English, country = US for consistency with StdIn
	    private final Locale LOCALE = Locale.US;

	    // send output here
	    private PrintWriter out;

	    // this is called before invoking any methods
	    {
	        try {
	            out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME), true);
	        }
	        catch (UnsupportedEncodingException e) {
	            System.out.println(e);
	        }
	    }

	    // don't instantiate
	    private StdOut() { }

	   /**
	     * Closes standard output.
	     */
	    public void close() {
	        out.close();
	    }

	   /**
	     * Terminates the current line by printing the line-separator string.
	     */
	    public void println() {
	        out.println();
	    }

	   /**
	     * Prints an object to this output stream and then terminates the line.
	     *
	     * @param x the object to print
	     */
	    public void println(Object x) {
	        out.println(x);
	    }

	   /**
	     * Prints a boolean to standard output and then terminates the line.
	     *
	     * @param x the boolean to print
	     */
	    public void println(boolean x) {
	        out.println(x);
	    }

	   /**
	     * Prints a character to standard output and then terminates the line.
	     *
	     * @param x the character to print
	     */
	    public void println(char x) {
	        out.println(x);
	    }

	   /**
	     * Prints a double to standard output and then terminates the line.
	     *
	     * @param x the double to print
	     */
	    public void println(double x) {
	        out.println(x);
	    }

	   /**
	     * Prints an integer to standard output and then terminates the line.
	     *
	     * @param x the integer to print
	     */
	    public void println(float x) {
	        out.println(x);
	    }

	   /**
	     * Prints an integer to standard output and then terminates the line.
	     *
	     * @param x the integer to print
	     */
	    public void println(int x) {
	        out.println(x);
	    }

	   /**
	     * Prints a long to standard output and then terminates the line.
	     *
	     * @param x the long to print
	     */
	    public void println(long x) {
	        out.println(x);
	    }

	   /**
	     * Prints a short integer to standard output and then terminates the line.
	     *
	     * @param x the short to print
	     */
	    public void println(short x) {
	        out.println(x);
	    }

	   /**
	     * Prints a byte to standard output and then terminates the line.
	     * <p>
	     * To write binary data, see {@link BinaryStdOut}.
	     *
	     * @param x the byte to print
	     */
	    public void println(byte x) {
	        out.println(x);
	    }

	   /**
	     * Flushes standard output.
	     */
	    public void print() {
	        out.flush();
	    }

	   /**
	     * Prints an object to standard output and flushes standard output.
	     * 
	     * @param x the object to print
	     */
	    public void print(Object x) {
	        out.print(x);
	        out.flush();
	    }

	   /**
	     * Prints a boolean to standard output and flushes standard output.
	     * 
	     * @param x the boolean to print
	     */
	    public void print(boolean x) {
	        out.print(x);
	        out.flush();
	    }

	   /**
	     * Prints a character to standard output and flushes standard output.
	     * 
	     * @param x the character to print
	     */
	    public void print(char x) {
	        out.print(x);
	        out.flush();
	    }

	   /**
	     * Prints a double to standard output and flushes standard output.
	     * 
	     * @param x the double to print
	     */
	    public void print(double x) {
	        out.print(x);
	        out.flush();
	    }

	   /**
	     * Prints a float to standard output and flushes standard output.
	     * 
	     * @param x the float to print
	     */
	    public void print(float x) {
	        out.print(x);
	        out.flush();
	    }

	   /**
	     * Prints an integer to standard output and flushes standard output.
	     * 
	     * @param x the integer to print
	     */
	    public void print(int x) {
	        out.print(x);
	        out.flush();
	    }

	   /**
	     * Prints a long integer to standard output and flushes standard output.
	     * 
	     * @param x the long integer to print
	     */
	    public void print(long x) {
	        out.print(x);
	        out.flush();
	    }

	   /**
	     * Prints a short integer to standard output and flushes standard output.
	     * 
	     * @param x the short integer to print
	     */
	    public void print(short x) {
	        out.print(x);
	        out.flush();
	    }

	   /**
	     * Prints a byte to standard output and flushes standard output.
	     *
	     * @param x the byte to print
	     */
	    public void print(byte x) {
	        out.print(x);
	        out.flush();
	    }

	   /**
	     * Prints a formatted string to standard output, using the specified format
	     * string and arguments, and then flushes standard output.
	     *
	     *
	     * @param format the <a href = "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format string</a>
	     * @param args   the arguments accompanying the format string
	     */
	    public void printf(String format, Object... args) {
	        out.printf(LOCALE, format, args);
	        out.flush();
	    }

	   /**
	     * Prints a formatted string to standard output, using the locale and
	     * the specified format string and arguments; then flushes standard output.
	     *
	     * @param locale the locale
	     * @param format the <a href = "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format string</a>
	     * @param args   the arguments accompanying the format string
	     */
	    public void printf(Locale locale, String format, Object... args) {
	        out.printf(locale, format, args);
	        out.flush();
	    }

	   /**
	     * Unit tests some of the methods in {@code StdOut}.
	     *
	     * @param args the command-line arguments
	     */
	}

	/******************************************************************************
	 *  Copyright 2002-2016, Robert Sedgewick and Kevin Wayne.
	 *
	 *  This file is part of algs4.jar, which accompanies the textbook
	 *
	 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
	 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
	 *      http://algs4.cs.princeton.edu
	 *
	 *
	 *  algs4.jar is free software: you can redistribute it and/or modify
	 *  it under the terms of the GNU General Public License as published by
	 *  the Free Software Foundation, either version 3 of the License, or
	 *  (at your option) any later version.
	 *
	 *  algs4.jar is distributed in the hope that it will be useful,
	 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
	 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	 *  GNU General Public License for more details.
	 *
	 *  You should have received a copy of the GNU General Public License
	 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
	 ******************************************************************************/

	/*  Compilation:  javac Stopwatch.java
	 *  Execution:    java Stopwatch n
	 *  Dependencies: none
	 *
	 *  A utility class to measure the running time (wall clock) of a program.
	 *
	 *  % java8 Stopwatch 100000000
	 *  6.666667e+11  0.5820 seconds
	 *  6.666667e+11  8.4530 seconds
	 *
	 ******************************************************************************/

	/**
	 *  The {@code Stopwatch} data type is for measuring
	 *  the time that elapses between the start and end of a
	 *  programming task (wall-clock time).
	 *
	 *  See {@link StopwatchCPU} for a version that measures CPU time.
	 *  For additional documentation,
	 *  see <a href="http://algs4.cs.princeton.edu/14analysis">Section 1.4</a> of
	 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
	 *
	 *  @author Robert Sedgewick
	 *  @author Kevin Wayne
	 */


	static class Stopwatch { 

	    private final long start;

	    /**
	     * Initializes a new stopwatch.
	     */
	    public Stopwatch() {
	        start = System.currentTimeMillis();
	    } 


	    /**
	     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
	     *
	     * @return elapsed CPU time (in seconds) since the stopwatch was created
	     */
	    public double elapsedTime() {
	        long now = System.currentTimeMillis();
	        return (now - start) / 1000.0;
	    }

	    /**
	     * Returns the elapsed CPU time (in miliseconds) since the stopwatch was created.
	     *
	     * @return elapsed CPU time (in miliseconds) since the stopwatch was created
	     */
	    public double elapsedTimeMillis() {
	        long now = System.currentTimeMillis();
	        return (now - start) /1.0;
	    }

	    
	    /**
	     * Unit tests the {@code Stopwatch} data type.
	     * Takes a command-line argument {@code n} and computes the 
	     * sum of the square roots of the first {@code n} positive integers,
	     * first using {@code Math.sqrt()}, then using {@code Math.pow()}.
	     * It prints to standard output the sum and the amount of time to
	     * compute the sum. Note that the discrete sum can be approximated by
	     * an integral - the sum should be approximately 2/3 * (n^(3/2) - 1).
	     *
	     * @param args the command-line arguments
	     */
	} 
}

