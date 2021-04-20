package com.epam.rd.java.basic.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Part1 {
	
	public static void main(String[] args) {
		InputStream temp = System.in;
		String data = "asd 43 asdf asd 43\n434 asdf\nkasdf asdf stop asdf\nstop\n";
		InputStream is = new ByteArrayInputStream(data.getBytes());
		System.setIn(is);
		try {
			WordContainer.main(args);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		System.setIn(temp);

		
	}

}
