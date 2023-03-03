package unit.test.training.part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("サファリパークの入園料金の計算クラスのテスト")
class SafariParkTest {
    @DisplayName("入園料金の境界値のテスト")
    @Nested
    class 入園料金の境界値のテスト {
        @ParameterizedTest
        @ValueSource(ints = {0, 5})
        void _6歳未満の時に入園料金が0円と表示されること(int age) {
            assertEquals(0, SafariPark.calcEntranceFee(age));
        }

        @ParameterizedTest
        @ValueSource(ints = {6, 12})
        void _6歳以上13歳未満の時に入園料金が500円と表示されること(int age) {
            assertEquals(500, SafariPark.calcEntranceFee(age));
        }

        @ParameterizedTest
        @ValueSource(ints = {13, 17})
        void _13歳以上18歳未満の時に入園料金が1000円と表示されること(int age) {
            assertEquals(1000, SafariPark.calcEntranceFee(age));
        }

        @ParameterizedTest
        @ValueSource(ints = {18})
        void _18歳以上の時に入園料金が1500円と表示されること(int age) {
            assertEquals(1500, SafariPark.calcEntranceFee(age));
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, 141})
        void _マイナスの数値または141以上の数値を入力したときに例外がスローされること(int age) {
            assertThrows(IllegalArgumentException.class, () -> SafariPark.calcEntranceFee(age));
        }
    }

    @DisplayName("入園料金の代表値のテスト")
    @Nested
    class 入園料金の代表値のテスト {
        @ParameterizedTest
        @ValueSource(ints = {3})
        void _6歳未満の時に入園料金が0円と表示されること(int age) {
            assertEquals(0, SafariPark.calcEntranceFee(age));
        }

        @ParameterizedTest
        @ValueSource(ints = {10})
        void _6歳以上13歳未満の時に入園料金が500円と表示されること(int age) {
            assertEquals(500, SafariPark.calcEntranceFee(age));
        }

        @ParameterizedTest
        @ValueSource(ints = {15})
        void _13歳以上18歳未満の時に入園料金が1000円と表示されること(int age) {
            assertEquals(1000, SafariPark.calcEntranceFee(age));
        }

        @ParameterizedTest
        @ValueSource(ints = {18})
        void _18歳以上の時に入園料金が1500円と表示されること(int age) {
            assertEquals(1500, SafariPark.calcEntranceFee(age));
        }

        @ParameterizedTest
        @ValueSource(ints = {-10, 200})
        void _マイナスの数値または141以上の数値を入力したときに例外がスローされること(int age) {
            assertThrows(IllegalArgumentException.class, () -> SafariPark.calcEntranceFee(age));
        }
    }
}