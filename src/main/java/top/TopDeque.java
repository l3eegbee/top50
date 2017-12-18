package top;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.stream.LongStream;

public class TopDeque implements TopAlgo {

	@Override
	public Collection<Long> getTop(LongStream stream, int topSize) {

		LinkedList<Long> deque = new LinkedList<>();

		Iterator<Long> dataIte = stream.iterator();

		for (int i = 0; i < topSize; i++)
			deque.add(dataIte.next());
		deque.sort(Comparator.reverseOrder());

		long min = deque.peekLast();

		while (dataIte.hasNext()) {

			long value = dataIte.next();

			if (value > min) {

				ListIterator<Long> ite = deque.listIterator();
				while (ite.hasNext() && ite.next() > value) {}
				ite.previous();
				ite.add(value);

				deque.removeLast();
				min = deque.peekLast();

			}

		}

		return deque;

	}

}