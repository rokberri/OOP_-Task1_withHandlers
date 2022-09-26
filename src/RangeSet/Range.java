package RangeSet;

import java.io.IOException;

public class Range {
    private int highBound;
    private int lowBound;

    //1-closed 0-open
    private boolean statusH;
    private boolean statusL;

    public Range(int lowBound, int highBound,  boolean statusL, boolean statusH) {
        if (lowBound<highBound) {
            this.highBound = highBound;
            this.lowBound = lowBound;
            this.statusH = statusH;
            this.statusL = statusL;
        }else{
            System.out.println("ERROR");
        }
    }
    private boolean higherThenLowBound(int num) {
        if (this.statusL) {
            return num >= this.lowBound;
        }else{
            return num > this.lowBound;
        }
    }
    private boolean lowerThenHighBound( int num){
        if(this.statusH){
            return this.highBound >= num;
        }else{
            return this.highBound > num;
        }
    }
    public static boolean numInRange(int num, Range range){
        return range.higherThenLowBound(num) && range.lowerThenHighBound(num);
    }
    public static boolean rangeInRange(Range range1, Range range2){
        return range2.higherThenLowBound(range1.lowBound) && range2.lowerThenHighBound(range1.highBound);
    }

    //написал с первого раза без ошибок, перепроверить
    public static boolean canJoinRanges(Range range1, Range range2){
        if(rangeInRange(range1,range2)){
            return true;
        }else {
            if(numInRange(range2.lowBound, range1) || numInRange( range2.highBound, range1)){
                return true;
            }
        }
        return false;
    }

    public Range joinRanges( Range range){
        if(rangeInRange(this,range)) {
            return range;
        }
        if(rangeInRange(range,this)){
            return this;
        }
        if(numInRange(range.lowBound, this)){
            return new Range(this.lowBound, range.highBound, this.statusL,range.statusH);
        }
        if(numInRange(this.lowBound, range)){
            return new Range(range.lowBound, this.highBound, range.statusL,this.statusH);
        }
        return new Range(0,1,false,false);
    }

    public static Range joinRanges(Range range1, Range range2){
        if(rangeInRange(range1,range2)) {
            return range2;
        }
        if(rangeInRange(range2,range1)){
            return range1;
        }
        if(numInRange(range2.lowBound, range1)){
            return new Range(range1.lowBound, range2.highBound, range1.statusL,range2.statusH);
        }
        if(numInRange(range1.lowBound, range2)){
            return new Range(range2.lowBound, range1.highBound, range2.statusL,range1.statusH);
        }
        return new Range(0,1,false,false);
    }


    public void printRange(){
        char openBracket = '(';
        char closeBracket = ')';
        if(statusL){
            openBracket = '[';
        }
        if(statusH){
            closeBracket = ']';
        }
        System.out.print(openBracket);
        System.out.print(this.lowBound + ".." + this.highBound);
        System.out.print(closeBracket);
    }

}
