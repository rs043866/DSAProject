package com.cts.handson.day52;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class HandsOn2 {

	/*
	 * Complete the timeConversion function below.
	 */
	static String timeConversion(String s) {
		/*
		 * Write your code here.
		 */

		if (s.substring(8, 10).equals("PM")) {
			if (!s.substring(0, 2).equals("12")) {
				s = (Integer.parseInt(s.substring(0, 2)) + 12) + s.substring(2, 8);
			} else {
				s = s.substring(0, 8);
			}
		} else if (s.substring(0, 2).equals("12") && s.substring(8, 10).equals("AM")) {
			s = "00" + s.substring(2, 8);

		} else {
			s = s.substring(0, 8);
		}

		return s;
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String s = null;
		s = scan.nextLine();
		String ans = timeConversion(s);
	}
}
