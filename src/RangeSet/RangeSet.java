package RangeSet;

import java.util.ArrayList;

public class RangeSet implements RangeSetInterface{
    private ArrayList<Range> rangeSet = new ArrayList<>();
    public int add(Range range){
        if(rangeSet.isEmpty()){
            rangeSet.add(range);
            return 0;
        }else{
            for (int i = 0; i < rangeSet.size(); i++) {
                if (Range.canJoinRanges(rangeSet.get(i), range)) {
                    Range newRange = Range.joinRanges(rangeSet.get(i),range);
                    rangeSet.remove(i);
                    rangeSet.add(i,newRange);
                    checkForUnic();
                    return 0;
                }
            }
        }
        rangeSet.add(range);
        return 0;
    }


    private int checkForUnic(){
        for (int i = 0; i < rangeSet.size(); i++) {
            for(int j=i+1; j< rangeSet.size(); j++) {
                Range range1 = rangeSet.get(i);
                Range range2 = rangeSet.get(j);
                if(Range.canJoinRanges(range1,range2)){
                    Range newRange = Range.joinRanges(range1,range2);
                    rangeSet.remove(i);
                    rangeSet.add(i,newRange);
                    rangeSet.remove(j);
                    return 0;
                }
            }
        }
        return 0;
    }
    public int remove(int index) throws IndexOutOfBoundsException{
        rangeSet.remove(index);
        return 0;
    }

    public Range getEl(int index){
        return rangeSet.get(index);
    }

    public int getSize(){
        return rangeSet.size();
    }
    public void printRanges(){
        for(Range r : rangeSet){
            r.printRange();
        }
    }
}
