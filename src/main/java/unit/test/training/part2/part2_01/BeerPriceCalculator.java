package unit.test.training.part2.part2_01;

public class BeerPriceCalculator {
    /**
     * 1杯目のビールの価格を計算する
     *
     * @param isHappyHour ハッピアワーかどうか
     * @param hasCoupon   クーポンを所持しているかどうか
     * @return 1杯目のビールの価格
     */
    public static int calculateFirstBeerPrice(boolean isHappyHour, boolean hasCoupon) {
        if (hasCoupon) {
            return BeerPrice.HAPPY_HOUR.getPrice();
        }

        if (isHappyHour) {
            return BeerPrice.COUPON.getPrice();
        }

        return BeerPrice.REGULAR.getPrice();
    }
}
