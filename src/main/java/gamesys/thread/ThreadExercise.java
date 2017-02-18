package gamesys.thread;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ThreadExercise {

	/**
	 * Executes the sum in parallel.
	 *
	 * @param words
	 * @return
	 */
	public long calculate(long[] numbers) {
		if (numbers == null)
			return 0;

		final ForkJoinPool pool = new ForkJoinPool(0);
		final RicursiveCalculator task = new RicursiveCalculator(numbers);
		return pool.invoke(task);
	}

	private static final class RicursiveCalculator extends RecursiveTask<Long> {

		private static final long serialVersionUID = -8864910403202141423L;

		private static final int LIMIT = 10;

		private final long[] numbers;

		public RicursiveCalculator(long[] numbers) {
			this.numbers = numbers;
		}

		@Override
		protected Long compute() {
			if (numbers.length < LIMIT) {
				return LongStream.of(numbers).sum();
			} else {
				final int currentLength = numbers.length;
				final int mid = currentLength / 2;

				// splitting tasks
				final RicursiveCalculator subTask = new RicursiveCalculator(Arrays.copyOfRange(numbers, 0, mid));
				subTask.fork();
				final RicursiveCalculator subTask2 = new RicursiveCalculator(Arrays.copyOfRange(numbers, mid + 1, currentLength));

				// combining results
				return subTask.join() + subTask2.compute();
			}
		}

	}

}
