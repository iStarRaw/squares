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

		int numberOfItems = countLines(fileName);

		Square square = new Square();

		try (Scanner leesRegel = new Scanner(new FileReader(fileName))) {

			while (leesRegel.hasNextLine()) {
				Line line = new Line();

				for (int i = 0; i < numberOfItems; i++) {

					int temp = leesRegel.nextInt();
					line.getLine().add(temp);	
					
				}
				square.getLines().add(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (NoSuchElementException e) {
			System.out.println("End of file has been reached");
		}

		System.out.println(square.toString());

	}

	private static int countLines(String fileName) {
		int count = 0;
		try (Scanner readFile = new Scanner(new FileReader(fileName))) {

			while (readFile.hasNextLine()) {

				if (readFile.nextLine() != "\n") {
					count++;
					readFile.nextLine();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			System.out.println("Reached end of line");
		}
		return count;
	}

}
