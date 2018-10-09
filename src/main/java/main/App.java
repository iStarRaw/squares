package main;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import models.Line;
import models.Square;

public class App {

	public static void main(String[] args) {

		final String FILE_LUNA = "/Users/ilsadejager/git/squares/Luna.txt";
		final String FILE_MERCURY = "/Users/ilsadejager/git/squares/Mercury.txt";

		// open the file,

		readFile(FILE_MERCURY);

		// check that all rows indeed sum to the same constant.

	}

	private static void readFile(File file) {

		int numberOfItems = countTokens(file);
		
		Square square = new Square();

		try (Scanner readLine = new Scanner(new FileReader(file))) {
			while (readLine.hasNextLine()) {

				Line line = new Line();
				
				for (int i = 0; i < numberOfItems; i++) {
				readLine.nextInt();
				
				}

				// put line in square
				square.getLines().add(line);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		System.out.println(square.toString());
	}
	
	private static int countTokens(File file) {
		int count = 0;
		try (Scanner readFile = new Scanner(file)) {
	
			while (readFile.hasNext()) {
				count++;
				readFile.next();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}


}
