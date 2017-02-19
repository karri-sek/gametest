package gamesys.guitarshop;

import gamesys.model.Guitar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

	@RequestMapping(value="/get-average-price",method = RequestMethod.GET)
	public @ResponseBody
	Guitar getAvgPriceByType(@RequestParam(value="type",defaultValue = "classic") String type) throws IOException, URISyntaxException {

		Guitar guitar = new Guitar();
		List<String[]> data = getData();
		double average = data.stream().map(arr -> new DataLine(arr[2], Double.parseDouble(arr[3])))
				.filter(line -> type.equalsIgnoreCase(line.type) || type.isEmpty())
				.collect(Collectors.averagingDouble(line -> line.cost));
		guitar.setType(type);
		guitar.setAveragePrice(average);
		return guitar;
	}

	private List<String[]> getData() throws IOException {
		return Files.readAllLines(Paths.get("src/main/resources/META-INF/csv/guitar-db.csv"))
				.stream().skip(1).map(line -> line.split(";"))
				.collect(Collectors.toList());
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
