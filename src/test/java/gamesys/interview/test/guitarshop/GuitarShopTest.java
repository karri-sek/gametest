package gamesys.interview.test.guitarshop;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuitarShopTest {

	private List<String[]> data;

	private GuitarShop service;

	@Before
	public void setUp() {
		// TODO read csv file and fill data obj...
		// initialize service
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

}
