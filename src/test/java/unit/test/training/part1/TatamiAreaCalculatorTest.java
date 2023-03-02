package unit.test.training.part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("畳の枚数から面積を計算するツールのテスト")
class TatamiAreaCalculatorTest {
    @DisplayName("面積計算の境界値のテスト")
    @Nested
    class 面積計算の境界値のテスト {
        @ParameterizedTest
        @ValueSource(ints = {1, 127})
        void _1から127を入力したときに1_65掛ける入力の値が計算されること(int number) {
            var tatamiAreaCalculator = new TatamiAreaCalculator(number);
            assertEquals((number * 165) / 100, tatamiAreaCalculator.getTatamiArea());
        }

        @ParameterizedTest
        @ValueSource(ints = {-128, 0})
        void マイナス129から0を入力したときにエラーとなること(int number) {
            var tatamiAreaCalculator = new TatamiAreaCalculator(number);
            assertThrows(IllegalStateException.class, () -> tatamiAreaCalculator.getTatamiArea());
        }

        @ParameterizedTest
        @ValueSource(ints = {-129, 128})
        void byteの範囲外を入力したときにエラーとなること(int number) {
            var tatamiAreaCalculator = new TatamiAreaCalculator(number);
            assertThrows(IllegalStateException.class, () -> tatamiAreaCalculator.getTatamiArea());
        }
    }

    @DisplayName("面積計算の代表値のテスト")
    @Nested
    class 面積計算の代表値のテスト {
        @ParameterizedTest
        @ValueSource(ints = {10})
        void _1から127を入力したときに1_65掛ける入力の値が計算されること(int number) {
            var tatamiAreaCalculator = new TatamiAreaCalculator(number);
            assertEquals((number * 165) / 100, tatamiAreaCalculator.getTatamiArea());
        }

        @ParameterizedTest
        @ValueSource(ints = {-64})
        void マイナス129から0を入力したときにエラーとなること(int number) {
            var tatamiAreaCalculator = new TatamiAreaCalculator(number);
            assertThrows(IllegalStateException.class, () -> tatamiAreaCalculator.getTatamiArea());
        }

        @ParameterizedTest
        @ValueSource(ints = {-130, 130})
        void byteの範囲外を入力したときにエラーとなること(int number) {
            var tatamiAreaCalculator = new TatamiAreaCalculator(number);
            assertThrows(IllegalStateException.class, () -> tatamiAreaCalculator.getTatamiArea());
        }
    }
}