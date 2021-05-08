package com.savaz.rd.java.basic.practice6;

import com.epam.rd.java.basic.practice6.part1.Part1;
import com.epam.rd.java.basic.practice6.part2.Part2;
import com.epam.rd.java.basic.practice6.part3.Part3;
import com.epam.rd.java.basic.practice6.part4.Part4;
import com.epam.rd.java.basic.practice6.part5.Part5;
import com.epam.rd.java.basic.practice6.part6.Part6;

public class Demo {

	public static void main(String[] args) {
		Part1.main(args);
		Part2.main(args);
		Part3.main(args);
		Part4.main(args);
		Part5.main(args);
		System.out.println("~~~~~~~~~~~~Part6");

		String fileName = "part6.txt";
		String fullTitle = "--task";
		String fullInput = "--input";
		Part6.main(new String[] {fullInput, fileName, fullTitle,"frequency"});
		System.out.println("_______________");
		Part6.main(new String[] {fullInput, fileName, fullTitle,"length"});
		System.out.println("----------------");
		Part6.main(new String[] {fullInput, fileName, fullTitle,"duplicates"});

	}

}
