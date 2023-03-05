package unit.test.training.part1.company_b;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import unit.test.training.part1.company_a.DiscountPolicy;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("B社の日付から割引率を返すメソッドのテスト")
class DiscountPolicyTest {
    @DisplayName("同値クラスのテスト")
    @Nested
    class 同値クラスのテスト {
        @ParameterizedTest(name = "日付が{1}の時に割引率が{0}となること")
        @MethodSource("期待値と日付の組")
        void 日付ごとの割引率のテスト(int expected, int day) {
            assertEquals(expected, unit.test.training.part1.company_a.DiscountPolicy.getDiscountRate(day));
        }

        static Stream<Arguments> 期待値と日付の組() {
            return Stream.of(
                    arguments(20, 1),
                    arguments(20, 2),
                    arguments(20, 3),
                    arguments(20, 4),
                    arguments(20, 5),
                    arguments(20, 28),
                    arguments(20, 29),
                    arguments(20, 30),
                    arguments(0, 10)
            );
        }
    }
}