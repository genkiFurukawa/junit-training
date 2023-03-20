package unit.test.training.part2.part2_02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WithdrawalCalculatorTest {

    @ParameterizedTest(name = "通常会員かつ日時が{1}のとき、手数料が{2}円となること")
    @MethodSource("通常会員の平日のテストケース")
    void 通常会員の平日の手数料計算のテスト(Customer customer, LocalDateTime dateTime, int expected) {
        int result = WithdrawalCalculator.calculateWithdrawal(customer, dateTime);

        assertEquals(expected, result);
    }

    static Stream<Arguments> 通常会員の平日のテストケース() {
        return Stream.of(
                arguments(new Customer(), LocalDateTime.of(2023, 3, 13, 0, 0), 110),
                arguments(new Customer(), LocalDateTime.of(2023, 3, 13, 8, 44), 110),
                arguments(new Customer(), LocalDateTime.of(2023, 3, 13, 8, 45), 0),
                arguments(new Customer(), LocalDateTime.of(2023, 3, 13, 17, 59), 0),
                arguments(new Customer(), LocalDateTime.of(2023, 3, 13, 18, 0), 110),
                arguments(new Customer(), LocalDateTime.of(2023, 3, 13, 23, 59), 110)
        );
    }

    @ParameterizedTest(name = "通常会員かつ日時が{1}のとき、手数料が{2}円となること")
    @MethodSource("通常会員の土日のテストケース")
    void 通常会員の土日の手数料計算のテスト(Customer customer, LocalDateTime dateTime, int expected) {
        int result = WithdrawalCalculator.calculateWithdrawal(customer, dateTime);

        assertEquals(expected, result);
    }

    static Stream<Arguments> 通常会員の土日のテストケース() {
        return Stream.of(
                arguments(new Customer(), LocalDateTime.of(2023, 3, 11, 0, 0), 110),
                arguments(new Customer(), LocalDateTime.of(2023, 3, 12, 0, 0), 110)
        );
    }

    @ParameterizedTest(name = "特別会員かつ日時が{1}のとき、手数料が{2}円となること")
    @MethodSource("特別会員の平日のテストケース")
    void 特別会員の平日の手数料計算のテスト(Customer customer, LocalDateTime dateTime, int expected) {
        int result = WithdrawalCalculator.calculateWithdrawal(customer, dateTime);

        assertEquals(expected, result);
    }

    static Stream<Arguments> 特別会員の平日のテストケース() {
        return Stream.of(
                arguments(new Customer(true), LocalDateTime.of(2023, 3, 13, 0, 0), 0),
                arguments(new Customer(true), LocalDateTime.of(2023, 3, 13, 8, 44), 0),
                arguments(new Customer(true), LocalDateTime.of(2023, 3, 13, 8, 45), 0),
                arguments(new Customer(true), LocalDateTime.of(2023, 3, 13, 17, 59), 0),
                arguments(new Customer(true), LocalDateTime.of(2023, 3, 13, 18, 0), 0),
                arguments(new Customer(true), LocalDateTime.of(2023, 3, 13, 23, 59), 0)
        );
    }

    @ParameterizedTest(name = "特別会員かつ日時が{1}のとき、手数料が{2}円となること")
    @MethodSource("特別会員の土日のテストケース")
    void 特別会員の土日の手数料計算のテスト(Customer customer, LocalDateTime dateTime, int expected) {
        int result = WithdrawalCalculator.calculateWithdrawal(customer, dateTime);

        assertEquals(expected, result);
    }

    static Stream<Arguments> 特別会員の土日のテストケース() {
        return Stream.of(
                arguments(new Customer(true), LocalDateTime.of(2023, 3, 11, 0, 0), 0),
                arguments(new Customer(true), LocalDateTime.of(2023, 3, 12, 0, 0), 0)
        );
    }
}