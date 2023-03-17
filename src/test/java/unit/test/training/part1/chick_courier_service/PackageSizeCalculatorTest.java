package unit.test.training.part1.chick_courier_service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * NOTE:
 * 3辺の合計のカテゴリは0~60,61~80,81~100,101~の4カテゴリ
 * 重量のカテゴリは0~2,3~5,6~10,11~の4カテゴリ
 * なので、代表値のテストは4 * 4の16パターン
 * 境界値のテストは上限と下限があるので、
 * （※ただし、101~と11~のカテゴリは下限しか考慮しなくて良い）
 * 7 * 7 = 49パターン 4 * （下限・上限） - 1（最後のカテゴリは下限しかないので）= 7
 */
@DisplayName("ヒヨコ宅急便の荷物サイズの決定ロジックのテスト")
class PackageSizeCalculatorTest {
    @Nested
    class calculatePackageSizeのテスト {
        @Nested
        class 境界値テスト {
            @ParameterizedTest(name = "3辺の合計が{0}、重量が{1}の時に{2}となること")
            @MethodSource("有効値のテストケース")
            void 有効値のテスト(int totalLength, int weight, PackageSize expected) {
                var result = PackageSizeCalculator.calculatePackageSize(totalLength, weight);

                assertEquals(expected, result);
            }

            static Stream<Arguments> 有効値のテストケース() {
                return Stream.of(
                        arguments(0, 0, PackageSize.SIZE_60),
                        arguments(0, 2, PackageSize.SIZE_60),
                        arguments(0, 3, PackageSize.SIZE_80),
                        arguments(0, 5, PackageSize.SIZE_80),
                        arguments(0, 6, PackageSize.SIZE_100),
                        arguments(0, 10, PackageSize.SIZE_100),
                        arguments(60, 0, PackageSize.SIZE_60),
                        arguments(60, 2, PackageSize.SIZE_60),
                        arguments(60, 3, PackageSize.SIZE_80),
                        arguments(60, 5, PackageSize.SIZE_80),
                        arguments(60, 6, PackageSize.SIZE_100),
                        arguments(60, 10, PackageSize.SIZE_100),
                        arguments(61, 0, PackageSize.SIZE_80),
                        arguments(61, 2, PackageSize.SIZE_80),
                        arguments(61, 3, PackageSize.SIZE_80),
                        arguments(61, 5, PackageSize.SIZE_80),
                        arguments(61, 6, PackageSize.SIZE_100),
                        arguments(61, 10, PackageSize.SIZE_100),
                        arguments(80, 0, PackageSize.SIZE_80),
                        arguments(80, 2, PackageSize.SIZE_80),
                        arguments(80, 3, PackageSize.SIZE_80),
                        arguments(80, 5, PackageSize.SIZE_80),
                        arguments(80, 6, PackageSize.SIZE_100),
                        arguments(80, 10, PackageSize.SIZE_100),
                        arguments(81, 0, PackageSize.SIZE_100),
                        arguments(81, 2, PackageSize.SIZE_100),
                        arguments(81, 3, PackageSize.SIZE_100),
                        arguments(81, 5, PackageSize.SIZE_100),
                        arguments(81, 6, PackageSize.SIZE_100),
                        arguments(81, 10, PackageSize.SIZE_100),
                        arguments(100, 0, PackageSize.SIZE_100),
                        arguments(100, 2, PackageSize.SIZE_100),
                        arguments(100, 3, PackageSize.SIZE_100),
                        arguments(100, 5, PackageSize.SIZE_100),
                        arguments(100, 6, PackageSize.SIZE_100),
                        arguments(100, 10, PackageSize.SIZE_100)
                );
            }

            @ParameterizedTest(name = "3辺の合計が{0}、重量が{1}の時にIllegalArgumentExceptionがスローされること")
            @MethodSource("無効値のテストケース")
            void 無効値のテスト(int totalLength, int weight) {
                assertThrows(IllegalArgumentException.class, () -> {
                    PackageSizeCalculator.calculatePackageSize(totalLength, weight);
                });
            }

            static Stream<Arguments> 無効値のテストケース() {
                return Stream.of(
                        arguments(0, 11),
                        arguments(60, 11),
                        arguments(61, 11),
                        arguments(80, 11),
                        arguments(81, 11),
                        arguments(100, 11),
                        arguments(101, 0),
                        arguments(101, 2),
                        arguments(101, 3),
                        arguments(101, 5),
                        arguments(101, 6),
                        arguments(101, 10),
                        arguments(101, 11)
                );
            }
        }

        @Nested
        class 代表値テスト {
            @ParameterizedTest(name = "3辺の合計が{0}、重量が{1}の時に{2}となること")
            @MethodSource("有効値のテストケース")
            void 有効値のテスト(int totalLength, int weight, PackageSize expected) {
                var result = PackageSizeCalculator.calculatePackageSize(totalLength, weight);

                assertEquals(expected, result);
            }

            static Stream<Arguments> 有効値のテストケース() {
                return Stream.of(
                        arguments(30, 1, PackageSize.SIZE_60),
                        arguments(30, 3, PackageSize.SIZE_80),
                        arguments(30, 7, PackageSize.SIZE_100),
                        arguments(70, 1, PackageSize.SIZE_80),
                        arguments(70, 3, PackageSize.SIZE_80),
                        arguments(70, 7, PackageSize.SIZE_100),
                        arguments(90, 7, PackageSize.SIZE_100),
                        arguments(90, 7, PackageSize.SIZE_100),
                        arguments(90, 7, PackageSize.SIZE_100)
                );
            }

            @ParameterizedTest(name = "3辺の合計が{0}、重量が{1}の時にIllegalArgumentExceptionがスローされること")
            @MethodSource("無効値のテストケース")
            void 無効値のテスト(int totalLength, int weight) {
                assertThrows(IllegalArgumentException.class, () -> {
                    PackageSizeCalculator.calculatePackageSize(totalLength, weight);
                });
            }

            static Stream<Arguments> 無効値のテストケース() {
                return Stream.of(
                        arguments(110, 1),
                        arguments(110, 3),
                        arguments(110, 7),
                        arguments(30, 15),
                        arguments(70, 15),
                        arguments(90, 15),
                        arguments(110, 15)
                );
            }
        }
    }
}