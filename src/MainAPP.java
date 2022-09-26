import Events.EventHandler;
import Events.Handler;
import RangeSet.RangeSet;

import RangeSet.Range;
import RangeSet.RangeMap;

public class MainAPP {
    public static void main(String[] args) {
//        Range range1 = new Range(1,3,true,false);
//        range1.printRange();
//        Range range2 = new Range(2,7,true,false);
//        range2.printRange();
//        System.out.println(Range.canJoinRanges(range1,range2));
//        range1.joinRanges(range2).printRange();
// -----------------------------------------------------------------------------------------
        RangeSet rangeSet = new RangeSet();
        Handler<RangeSet,Range> actionAdd = EventHandler::addHandler;
        Handler<RangeSet,Integer> actionRemove = EventHandler::removeHandler;
        actionAdd.actionHandler(rangeSet,new Range(1,3,true,false));
        actionAdd.actionHandler(rangeSet,new Range(12,15,true,false));
        actionAdd.actionHandler(rangeSet,new Range(2,7,true,false));
        actionAdd.actionHandler(rangeSet,new Range(6,13,true,false));
        actionRemove.actionHandler(rangeSet,1);


//        rangeSet.add(new Range(1,3,true,false));
//        rangeSet.printRanges();
//        System.out.println("---------------------------------------------------------------");
//        rangeSet.add(new Range(12,15,true,false));
//        rangeSet.printRanges();
//        System.out.println("---------------------------------------------------------------");
//        rangeSet.add(new Range(2,7,true,false));
//        rangeSet.printRanges();
//        System.out.println("---------------------------------------------------------------");
//        rangeSet.add(new Range(6,13,true,false));
//        rangeSet.printRanges();
//        System.out.println("---------------------------------------------------------------");
//-----------------------------------------------------------------------------------------
//        RangeMap<Integer, String> experienceRangeDesignationMap = TreeRangeMap.create();
//
//        experienceRangeDesignationMap.put(Range.closed(0, 2), "Associate");
//        experienceRangeDesignationMap.put(Range.closed(3, 5), "Senior Associate");
//        experienceRangeDesignationMap.put(Range.closed(6, 8),  "Vice President");
//        experienceRangeDesignationMap.put(Range.closed(9, 15), "Executive Director");
//
//        System.out.println(experienceRangeDesignationMap.get(5));
//-----------------------------------------------------------------------------------------
        RangeMap rangeMap = new RangeMap();
        rangeMap.add(new Range(0,2,true,true),"A");
        rangeMap.add(new Range(3,5,true,true),"B");
        rangeMap.add(new Range(6,8,true,true),"C");

        //rangeMap.printRanges();

        System.out.println(rangeMap.remove("A"));

        rangeMap.printRanges();

        System.out.println(rangeMap.get(5));

    }
}
