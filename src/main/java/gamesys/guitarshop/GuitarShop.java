package gamesys.guitarshop;

import java.util.List;
import java.util.stream.Collectors;

public class GuitarShop {

	public double getAvgPriceByType(List<String[]> data, String type) {
		if(data == null || type == null) return 0.0;
		double average = data.stream().map(arr -> new DataLine(arr[2], Double.parseDouble(arr[3])))
				.filter(line -> type.equalsIgnoreCase(line.type) || type.isEmpty())
				.collect(Collectors.averagingDouble(line -> line.cost));
		return average;
	}


	//Contains fields that are needed only for the problem statement.
	private class DataLine {
		private String type;
		private double cost;

		public DataLine(String type, double cost) {
			this.type = type;
			this.cost = cost;
		}

	}



}
