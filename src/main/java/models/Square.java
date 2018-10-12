package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Square {
	private List<Line> lines;
	
	public Square() {
		lines = new ArrayList<>();
	}
	
	
	
	public List<Line> getLines() {
		return lines;
	}


	@Override
	public String toString() {
		StringBuilder square = new StringBuilder();
		
		for (Line line: lines) {
			square.append(line.toString());
			square.append(String.format("\n"));
		}
		
		return square.toString();
		
	}

}
