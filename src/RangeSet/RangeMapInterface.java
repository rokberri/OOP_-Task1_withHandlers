package RangeSet;

public interface RangeMapInterface {

    public int add(Range range,String value);

    public int remove(String value);

    public String get(int value);

    public int getSize();

    public void printRanges();

}
