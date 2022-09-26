package Events;

import RangeSet.Range;
import RangeSet.RangeSet;

public class EventHandler<T> {

    public static void addHandler(RangeSet rangeSet, Range range) {
        if (rangeSet.add(range) == 0) {
            System.out.print("Element ");
            range.printRange();
            System.out.println(" added successfully");
        }else{
            System.out.println("ERROR");
        }
        rangeSet.printRanges();
        System.out.println("\n---------------------------------------------------------------");
    }

    public static void removeHandler(RangeSet rangeSet, int index){
        try {
            if(rangeSet.remove(index) == 0) {
                System.out.print("Element " + index + " has been deleted successfully");
            }
            rangeSet.printRanges();
            System.out.println("\n---------------------------------------------------------------");
        }catch (IndexOutOfBoundsException er){
            System.out.println("ERROR \nCant' remove " + index + " element");
        }

    }

}
