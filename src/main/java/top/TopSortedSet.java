package top;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.stream.LongStream;

public class TopSortedSet implements TopAlgo {

	@Override
	public Collection<Long> getTop(LongStream stream, int topSize) {

		NavigableSet<Long> top = new TreeSet<>();

		Iterator<Long> dataIte = stream.iterator();

		for (int i = 0; i < topSize; i++)
			top.add(dataIte.next());

		long min = top.pollFirst();

		while (dataIte.hasNext()) {

			long value = dataIte.next();

			if (value > min) {
				top.add(value);
				min = top.pollFirst();
			}

		}

		top.add(min);

		return top;

	}

}