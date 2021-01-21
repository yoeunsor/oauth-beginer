package com.sokkheang.huo.common.utils;

import java.nio.charset.Charset;
import java.util.Random;

/*
 * @Author Sokkheang Huo
 * */

public class RandomWordWithNumber {

	static String RequiredStrings(int n)
	{
		// length declaration
		byte[] array = new byte[256];
		new Random().nextBytes(array);
		String randomString
				= new String(array, Charset.forName("UTF-8"));
		// Creating a StringBuffer
		StringBuffer ra = new StringBuffer();
		// Appending first 20 alphanumeric characters
		for (int i = 0; i < randomString.length(); i++)
		{
			char ch = randomString.charAt(i); if (((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) && (n > 0))
			{
				ra.append(ch);
				n--;
			}
		}
		// returning the resultant string
		return ra.toString();
	}

	static String getAlphaNumericString(int n)
	{
		// length declaration
		byte[] array = new byte[256];
		new Random().nextBytes(array);
		String randomString
				= new String(array, Charset.forName("UTF-8"));
		// Creating a StringBuffer
		StringBuffer ra = new StringBuffer();
		// remove all spacial char
		String AlphaNumericString
				= randomString
				.replaceAll("[^A-Za-z0-9]", "");
		// Append first 20 alphanumeric characters
		// from the generated random String into the result
		for (int k = 0; k < AlphaNumericString.length(); k++) {
			if (Character.isLetter(AlphaNumericString.charAt(k))
					&& (n > 0)
					|| Character.isDigit(AlphaNumericString.charAt(k))
					&& (n > 0)) {
				ra.append(AlphaNumericString.charAt(k));
				n--;
			}
		}
		// returning the resultant string
		return ra.toString();
	}

	static String RequiredString(int n)
	{
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz"
				+ "!@#$%^&*()_-=_+[]\';,./?><:|";
		// create StringBuffer size of AlphaNumericString
		StringBuilder s = new StringBuilder(n);
		int y;
		for ( y = 0; y < n; y++) {
		// generating a random number
			int index
					= (int)(AlphaNumericString.length()
					* Math.random());
			// add Character one by one in end of s
			s.append(AlphaNumericString
					.charAt(index));
		}
		return s.toString();
	}

	public static String[] generateRandomWords(int numberOfWords)
	{
		String[] randomStrings = new String[numberOfWords];
		Random random = new Random();
		for(int i = 0; i < numberOfWords; i++)
		{
			char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
			for(int j = 0; j < word.length; j++)
			{
				word[j] = (char)('a' + random.nextInt(26));
			}
			randomStrings[i] = new String(word);
		}
		return randomStrings;
	}

	String generateRandomWord(int wordLength) {
		Random r = new Random(); // Intialize a Random Number Generator with SysTime as the seed
		StringBuilder sb = new StringBuilder(wordLength);
		for(int i = 0; i < wordLength; i++) { // For each letter in the word
			char tmp = (char) ('a' + r.nextInt('z' - 'a')); // Generate a letter between a and z
			sb.append(tmp); // Add it to the String
		}
		return sb.toString();
	}
	
}
