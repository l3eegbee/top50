package top;

import java.util.Collection;
import java.util.stream.LongStream;

public interface TopAlgo {

	public Collection<Long> getTop(LongStream stream, int topSize);

}