package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

import models.Line;
import models.Square;

public class App {

	public static void main(String[] args) {
		//MAC
//		final String FILE_LUNA = "/Users/ilsadejager/git/squares/Luna.txt";
//		final String FILE_MERCURY = "/Users/ilsadejager/git/squares/Mercury.txt";
		
		//Windows
		final String FILE_LUNA = "D:\\Repos\\squares\\Luna.txt";
		final String FILE_MERCURY = "D:\\Repos\\squares\\Mercury.txt";
		

		Square squareMercury = new Square();
		Square squareLuna = new Square();

		// open the file
		readFile(FILE_MERCURY, squareMercury);

		// check that all horizontal rows sum to the same constant.
		boolean equalHorMercury = squareMercury.eachLineEqualSum();
		System.out.println(equalHorMercury);
		
		//check that all vertical rows sum to the same constant.
		
		boolean equalVerMercury = squareMercury.eachColumnEqualSum();
		System.out.println(equalVerMercury);

		// open the file
		readFile(FILE_LUNA, squareLuna);

		// check that all rows indeed sum to the same constant.
		boolean equalSumLuna = squareLuna.eachLineEqualSum();
		System.out.println(equalSumLuna);
		
		
		
		

	}

	
	
	private static void readFile(String fileName, Square square) {

		int numberOfItems = countLines(fileName);

		try (Scanner readLine = new Scanner(new FileReader(fileName))) {

			while (readLine.hasNextLine()) {
				Line line = new Line();

				for (int i = 0; i < numberOfItems; i++) {
					int temp = readLine.nextInt();
					line.getLine().add(temp);
				}
				square.getLines().add(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found!\n");
		} catch (NoSuchElementException e) {
			System.out.println("End of file has been reached\n");
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
			System.out.println("Reached end of line\n");
		}
		return count;
	}

}
