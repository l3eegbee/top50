package top;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainTop {

	private static final long SEED = 42l;

	private static final long DATA_SIZE = 1_000_000_000l;

	private static final int TOP_SIZE = 30;

	public static void testTop(TopAlgo algo) {
		
		Instant start = Instant.now();
		Collection<Long> toplist = algo.getTop(new Random(SEED).longs(DATA_SIZE), TOP_SIZE);
		Instant end = Instant.now();

		Duration elapased = Duration.between(start, end);

		System.out.println("----");
		System.out.println("Algo: " + algo.getClass().getCanonicalName());
		System.out.println("Duration: " + elapased.toMillis() + "ms");

		List<Long> sortedTopList = new ArrayList<>(toplist);
		Collections.sort(sortedTopList);
		//System.out.println("Top: " + sortedTopList);

	}

	public static void main(String... args) throws Exception {

		//new Random(SEED).longs(DATA_SIZE).forEach(System.out::println);
		testTop(new TopDeque());
		testTop(new TopSortedSet());

	}

}
