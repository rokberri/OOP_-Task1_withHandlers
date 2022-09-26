package RangeSet;

public interface RangeSetInterface {
    public int add(Range range);
    public int remove(int index);
    public Range getEl(int index);
    public int getSize();
    public void printRanges();


}
