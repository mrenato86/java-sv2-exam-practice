package cleaning;

public class House implements Cleanable {

    private static final int PRICE_PER_SQUARE_METER = 80;

    private final String address;
    private final int area;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    @Override
    public int clean() {
        return area * PRICE_PER_SQUARE_METER;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
