package unit.test.training.part2.part2_01;

public enum BeerPrice {
    HAPPY_HOUR(100),
    COUPON(290),
    REGULAR(490);

    private final int price;

    BeerPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
