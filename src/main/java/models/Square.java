package models;

import java.util.ArrayList;
import java.util.List;

public class Square {
	private List<Line> lines;

	public Square() {
		lines = new ArrayList<>();
	}

	public List<Line> getLines() {
		return lines;
	}

	public boolean eachLineEqualSum() {
		for (int i = 0; i < lines.size() - 1; i++) {
			int sum = lines.get(i).getSum();

			if (sum != lines.get(i + 1).getSum()) {
				return false;
			}
		}

		return true;
	}
	
	public boolean eachColumnEqualSum() {
		return false;
	}

	@Override
	public String toString() {
		StringBuilder square = new StringBuilder();

		for (Line line : lines) {
			square.append(line.toString());
			square.append(String.format("\n"));
		}

		return square.toString();
	}

}
