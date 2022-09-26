package RangeSet;

import java.util.HashMap;
import java.util.Map;

public class RangeMap implements RangeMapInterface {
    private HashMap<Range, String> rangeMap = new HashMap<>();


    @Override
    public int add(Range range, String value) {
        if(rangeMap.isEmpty()){
            rangeMap.put(range,value);
            return 0;
        }else{
            for (Map.Entry<Range, String> entry : rangeMap.entrySet()){
                if(Range.canJoinRanges(entry.getKey(),range)){
                    return 1;
                }
            }
            rangeMap.put(range,value);
        }
        return 0;
    }

    @Override
    public int remove(String value) {
        for (Map.Entry<Range, String> entry : rangeMap.entrySet()){
            if(entry.getValue().equals(value)){
                rangeMap.remove(entry.getKey());
                return 0;
            }
        }
        return 1;
    }

    @Override
    public String get(int index) {
        for (Map.Entry<Range, String> entry : rangeMap.entrySet()){
            if(Range.numInRange(index,entry.getKey())){
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return rangeMap.size();
    }

    @Override
    public void printRanges() {
        for (Map.Entry<Range, String> entry : rangeMap.entrySet()) {
            entry.getKey().printRange();
            System.out.println(entry.getValue());
        }
    }
}
