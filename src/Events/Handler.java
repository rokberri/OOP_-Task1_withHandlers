package Events;

import RangeSet.Range;
import RangeSet.RangeSet;

@FunctionalInterface
public interface Handler<T,C>{
    public void actionHandler(T rangeSet, C range);

}