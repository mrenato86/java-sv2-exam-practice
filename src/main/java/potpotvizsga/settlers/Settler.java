package potpotvizsga.settlers;

public class Settler {

    public static final int INCOME_BY_TONS = 500;

    private long id;
    private final String nameOfSettler;
    private final int amountOfTobacco;
    private final int expectedIncome;

    public Settler(String nameOfSettler, int amountOfTobacco) {
        this.nameOfSettler = nameOfSettler;
        this.amountOfTobacco = amountOfTobacco;
        this.expectedIncome = amountOfTobacco * INCOME_BY_TONS;
    }

    public Settler(long id, String nameOfSettler, int amountOfTobacco, int expectedIncome) {
        this.id = id;
        this.nameOfSettler = nameOfSettler;
        this.amountOfTobacco = amountOfTobacco;
        this.expectedIncome = expectedIncome;
    }

    public long getId() {
        return id;
    }

    public String getNameOfSettler() {
        return nameOfSettler;
    }

    public int getAmountOfTobacco() {
        return amountOfTobacco;
    }

    public int getExpectedIncome() {
        return expectedIncome;
    }
}
