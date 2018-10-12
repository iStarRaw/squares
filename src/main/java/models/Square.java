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
		
		return this.lines.stream().map(e -> e.toString()).collect(Collectors.joining());
		
	}

}
