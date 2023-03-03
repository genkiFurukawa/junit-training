package unit.test.training.part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("布の長さから値段を計算するツールのテスト")
class ClothPriceCalculatorTest {
    @DisplayName("値段計算の境界値のテスト")
    @Nested
    class 値段計算の境界値のテスト {
        @ParameterizedTest
        @ValueSource(doubles = {0.0, 100.1})
        void 下限値と上限値を超えたときに例外がスローされること(double clothLength) {
            assertThrows(IllegalArgumentException.class, () -> ClothPriceCalculator.getPrice(clothLength));
        }

        @ParameterizedTest
        @MethodSource("_3m以下の時のテストパラメータ")
        void _3m以下の時に1mあたり400円の単価が適用されること(int expected, double clothLength) {
            assertEquals(expected, ClothPriceCalculator.getPrice(clothLength));
        }

        static Stream<Arguments> _3m以下の時のテストパラメータ() {
            return Stream.of(
                    arguments(40, 0.1),
                    arguments(1_200, 3.0)
            );
        }

        @ParameterizedTest
        @MethodSource("_3mより大きいの時のテストパラメータ")
        void _3mより大きい時に1mあたり350円の単価が適用されること(int expected, double clothLength) {
            assertEquals(expected, ClothPriceCalculator.getPrice(clothLength));
        }

        static Stream<Arguments> _3mより大きいの時のテストパラメータ() {
            return Stream.of(
                    arguments(1_085, 3.1),
                    arguments(35_000, 100.0)
            );
        }
    }

    @DisplayName("値段計算の代表値のテスト")
    @Nested
    class 値段計算の代表値のテスト {
        @ParameterizedTest
        @ValueSource(doubles = {-10.5, 150.1})
        void 下限値と上限値を超えたときに例外がスローされること(double clothLength) {
            assertThrows(IllegalArgumentException.class, () -> ClothPriceCalculator.getPrice(clothLength));
        }

        @ParameterizedTest
        @MethodSource("_3m以下の時のテストパラメータ")
        void _3m以下の時に1mあたり400円の単価が適用されること(int expected, double clothLength) {
            assertEquals(expected, ClothPriceCalculator.getPrice(clothLength));
        }

        static Stream<Arguments> _3m以下の時のテストパラメータ() {
            return Stream.of(
                    arguments(920, 2.3)
            );
        }

        @ParameterizedTest
        @MethodSource("_3mより大きいの時のテストパラメータ")
        void _3mより大きい時に1mあたり350円の単価が適用されること(int expected, double clothLength) {
            assertEquals(expected, ClothPriceCalculator.getPrice(clothLength));
        }

        static Stream<Arguments> _3mより大きいの時のテストパラメータ() {
            return Stream.of(
                    arguments(15_575, 44.5)
            );
        }
    }
}