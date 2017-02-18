package gamesys.interview.test.guitarshop;

import gamesys.guitarshop.GuitarShop;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GuitarShopTest {

	private List<String[]> data;

	private GuitarShop service;
	@Before
	public void setUp() throws IOException, URISyntaxException {
		service = new GuitarShop();
		data = Files.readAllLines(Paths.get("src/main/resources/META-INF/csv/guitar-db.csv"))
				.stream().skip(1).map(line -> line.split(";"))
				.collect(Collectors.toList());
	}

	@Test
	public void testAvarageWithNullData() {
		double avg = service.getAvgPriceByType(null, null);
		Assert.assertEquals(0, avg, 0);
	}

	@Test
	public void testAvarageWithEmptyData() {
		double avg = service.getAvgPriceByType(Collections.<String[]>emptyList(), null);
		Assert.assertEquals(0, avg, 0);
	}

	@Test
	public void testAvarageWithSpacesFilter() {
		double avg = service.getAvgPriceByType(data, "	");
		Assert.assertEquals(0, avg, 0);
	}

	@Test
	public void testAvarageWithEmptyFilter() throws IOException {
		double avg = service.getAvgPriceByType(data, "");
		Assert.assertEquals(1259.53, avg, 0.01);
	}

	@Test
	public void testAvarageAcoustic() {
		double avg = service.getAvgPriceByType(data, "acoustic");
		Assert.assertEquals(981.57, avg, 0.01);
	}

	@Test
	public void testAvarageElectric() {
		double avg = service.getAvgPriceByType(data, "electric");
		Assert.assertEquals(3011.21, avg, 0.01);
	}


	@After
	public void tearDown() {
		service = null;
		data = null;
	}

}
