package models;

import java.util.ArrayList;
import java.util.List;


public class Line {
	private List<Integer> line;
	private int sum = 0;
	
	public Line() {
		line = new ArrayList<>();
	}

	
	public List<Integer> getLine() {
		return line;
	}
	

	public int getSum() {
		return sum;
	}

	public int sumLine() {
		for (Integer number: line) {
			sum += number;
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder lineString = new StringBuilder();
		
		for (Integer number: line) {
			lineString.append(number + " ");
		}
				
		return lineString.toString();
	}
	
}
