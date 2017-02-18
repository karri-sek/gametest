package gamesys.interview.test.thread;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import gamesys.thread.ThreadExercise;

public class ThreadExerciseTest {

	private ThreadExercise service;

	@Before
	public void setUp() {
		service = new ThreadExercise();
	}

	@Test
	public void testWithNull() {
		long sum = service.calculate(null);
		Assert.assertEquals(0, sum);
	}

	@Test
	public void testWithEmpty() {
		long sum = service.calculate(new long[] {});
		Assert.assertEquals(0, sum);
	}

	@Test
	public void testWithAllNegative() {
		long[] n = new long[] { 0, -10, -345, -983479, -6518, -98719879, -9187987, -987105, Long.MIN_VALUE, -98719879, -9187987, -987105, -4985,
				3215 };

		long sum = service.calculate(n);
		Assert.assertEquals(9223372036635993744l, sum);
	}

	@Test
	public void testWithLongNumbers() {
		long[] n = new long[] { 0, 10, 345, 983479, 6518, 98719879, 9187987, 987105, -8986, 987416, -69819898, 6518, 9879, 9187987, 987105, -8986,
				987416, -69819898, 0, 10, 345, 983479, 6518, 98719879, 9187987, 987105, -8986, 987416, -69819898, 0, 10, 345, 983479, 6518, 98719879,
				9187987, 987105, -8986, 987416, -69819898, 0, 10, 345, 983479, 6518, 98719879, 9187987, 987105, -8986, 987416, -69819898, 0, 10, 345,
				983479, 6518, 98719879, 9187987, 987105, -8986, 987416, -69819898, 6548, 98791065, 6549, 65846, 3210, 6879 };

		long sum = service.calculate(n);

		Assert.assertEquals(245449393, sum);
	}

	@Test
	public void testBigNumbers() {
		long[] n = new long[] { 0, 10, 345, 983479, 6518, 98719879, 9187987, 987105, -8986, 987416, -69819898, 6518, 9879, 9187987, 987105, -8986,
				987416, -69819898, 0, 10, 345, 983479, 6518, 98719879, 9187987, 987105, -8986, 987416, -69819898, 0, 10, 345, 983479, 6518, 98719879,
				9187987, 987105, -8986, 987416, -69819898, 0, 10, 345, 983479, 6518, 98719879, 9187987, 987105, -8986, 987416, -69819898, 0, 10, 345,
				983479, 6518, 98719879, 9187987, 987105, -8986, 987416, -69819898, Long.MAX_VALUE };

		long sum = service.calculate(n);

		Assert.assertEquals(-9223372036708206513l, sum);
	}

}
