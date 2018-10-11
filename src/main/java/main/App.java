package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

import models.Line;
import models.Square;

public class App {

	public static void main(String[] args) {

		final String FILE_LUNA = "/Users/ilsadejager/git/squares/Luna.txt";
		final String FILE_MERCURY = "/Users/ilsadejager/git/squares/Mercury.txt";

		// open the file,

		leesFile(FILE_MERCURY);

		// check that all rows indeed sum to the same constant.

	}
	
	private static void leesFile(String fileName) {
		
		Square square = new Square();
		
		try (Scanner leesRegel = new Scanner(new FileReader(fileName))){
			while (leesRegel.hasNextLine()) {
				Line line = new Line();
				System.out.println(leesRegel.nextInt());
				line.getLine().add(leesRegel.nextInt());
				
				square.getLines().add(line);
			}
		
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (NoSuchElementException e) {
			System.out.println("End of file has been reached");
		}
		
		System.out.println(square.toString());
		
	}
	

	private static void readFile(String fileName) {

		int numberOfItems = countTokens(fileName);
		System.out.println(numberOfItems);

		Square square = new Square();

//		try {
//			Files.lines(Paths.get(fileName)).forEach(System.out::println);
//		} catch (IOException e) {
//			
//		}

		try (Scanner readLine = new Scanner(new FileReader(fileName))) {
			while (readLine.hasNextLine()) {

				Line line = new Line();
				
				for (int i = 0; i < numberOfItems; i++) {
					int temp = readLine.nextInt();
					line.getLine().add(temp);

				}

				// put line in square
				square.getLines().add(line);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(square.toString());
	}
	
		

	private static int countTokens(String fileName) {
		int count = 0;
		try (Scanner readFile = new Scanner(new FileReader(fileName))) {

			int line = readFile.nextInt();

			while (line != -1) {
				count++;
				line = readFile.nextInt();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			System.out.println("Reached end of line");
		}
		return count;
	}

}
