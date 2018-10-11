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
	

	public int sumLine() {
		for (Integer number: line) {
			sum += number;
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Integer number: line) {
			sb.append(number + " ");
		}
		return null;
	}
	
}
