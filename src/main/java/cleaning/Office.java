package cleaning;

public class Office implements Cleanable {

    private static final int PRICE_PER_SQUARE_METER = 100;

    private final String address;
    private final int area;
    private final int levels;

    public Office(String address, int area, int levels) {
        this.address = address;
        this.area = area;
        this.levels = levels;
    }

    @Override
    public int clean() {
        return area * levels * PRICE_PER_SQUARE_METER;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
