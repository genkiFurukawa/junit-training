package unit.test.training.part2.part2_01;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BeerPriceCalculatorTest {

    @ParameterizedTest(name = "ハッピアワーが{0}で、クーポンを所持しているかが{1}のとき、1杯目のビールの価格が{2}円となること")
    @CsvSource({
            "true, true, 100",
            "true, false, 290",
            "false, true, 100",
            "false, false, 490",
    })
    void calculateFirstBeerPrice(boolean isHappyHour, boolean hasCoupon, int expected) {
        int result = BeerPriceCalculator.calculateFirstBeerPrice(isHappyHour, hasCoupon);

        assertEquals(expected, result);
    }
}