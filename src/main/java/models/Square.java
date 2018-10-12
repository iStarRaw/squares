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
			int sum1 = lines.get(i).getSum();
			int sum2 = lines.get(i + 1).getSum();

			if (sum1 != sum2) {
				return false;
			}
		}

		return true;
	}

	public boolean eachColumnEqualSum() {
		
		List<Integer> column = new ArrayList<>();
//		List<Integer> column1 = new ArrayList<>();
//		List<Integer> column2 = new ArrayList<>();
//		List<Integer> column3 = new ArrayList<>();
//		List<Integer> column4 = new ArrayList<>();
//		List<Integer> column5 = new ArrayList<>();
//		List<Integer> column6 = new ArrayList<>();
//		List<Integer> column7 = new ArrayList<>();
//		
		fillColumn(column, 0);
//		fillColumn(column1, 1);
//		fillColumn(column2, 2);
//		fillColumn(column3, 3);
//		fillColumn(column4, 4);
//		fillColumn(column5, 5);
//		fillColumn(column6, 6);
//		fillColumn(column7, 7);
		
//		for (Line line : lines) {
//			column.add(line.getLine().get(0));
//		}
//		
		int sum = column.stream().mapToInt(Integer::intValue).sum();
		
		
		
		

		return false;
	}

	private void fillColumn(List<Integer> columnName, int index) {

		for (Line line : lines) {
			columnName.add(line.getLine().get(index));
		}
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
