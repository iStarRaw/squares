package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Square {
	private List<Line> lines;

	private List<Integer> column0;
	private List<Integer> column1;
	private List<Integer> column2;
	private List<Integer> column3;
	private List<Integer> column4;
	private List<Integer> column5;
	private List<Integer> column6;
	private List<Integer> column7;

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

	//TODO gebruik maken van multi-dimensional array
	public boolean eachColumnEqualSum() {
		Map<Integer, List<Integer>> columns = new HashMap<>(lines.size());

		// columns aanmaken
		column0 = new ArrayList<>();
		column1 = new ArrayList<>();
		column2 = new ArrayList<>();
		column3 = new ArrayList<>();
		column4 = new ArrayList<>();
		column5 = new ArrayList<>();
		column6 = new ArrayList<>();
		column7 = new ArrayList<>();

		// columns vullen met alle indexen van square met corresponderende indexen.
		fillColumn(column0, 0);
		fillColumn(column1, 1);
		fillColumn(column2, 2);
		fillColumn(column3, 3);
		fillColumn(column4, 4);
		fillColumn(column5, 5);
		fillColumn(column6, 6);
		fillColumn(column7, 7);

		// som uitrekenen van alle int met waarde 0.
		int sum0 = column0.stream().mapToInt(Integer::intValue).sum();
		int sum1 = column1.stream().mapToInt(Integer::intValue).sum();
		int sum2 = column2.stream().mapToInt(Integer::intValue).sum();
		int sum3 = column3.stream().mapToInt(Integer::intValue).sum();
		int sum4 = column4.stream().mapToInt(Integer::intValue).sum();
		int sum5 = column5.stream().mapToInt(Integer::intValue).sum();
		int sum6 = column6.stream().mapToInt(Integer::intValue).sum();
		int sum7 = column7.stream().mapToInt(Integer::intValue).sum();

		// totalen en kolommen in hashmap stoppen
		columns.put(sum0, column0);
		columns.put(sum1, column1);
		columns.put(sum2, column2);
		columns.put(sum3, column3);
		columns.put(sum4, column4);
		columns.put(sum5, column5);
		columns.put(sum6, column6);
		columns.put(sum7, column7);

		for (Integer sum : columns.keySet()) {
			if (sum != sum0) {
				return false;
			}
		}

		return true;
	}

	private void fillColumn(List<Integer> columnName, int index) {
		for (Line line : lines) {
			columnName.add(line.getLine().get(index));
		}
	}

	public boolean eachDiagonalEqualSum() {
		int sum1 = 0;
		int sum2 = 0;
		// som van 1e lijn eerste index tot laatste lijn laatste index
		for (int i = 0; i < lines.size(); i++) {
			sum1 += lines.get(i).getLine().get(i);
		}

		// som van: laatste lijn 1e index tot 1e lijn laatste index
		for (int i = lines.size() - 1; i >= 0; i--) {
			sum2 += lines.get(i).getLine().get(i);
		}

		// vergelijken 2 sommen
		return (sum1 == sum2);
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
