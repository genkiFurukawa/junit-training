package unit.test.training.part1.chick_courier_service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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
                        arguments(60, 0, PackageSize.SIZE_60),
                        arguments(0, 2, PackageSize.SIZE_60),
                        arguments(60, 2, PackageSize.SIZE_60),
                        arguments(61, 3, PackageSize.SIZE_80),
                        arguments(80, 3, PackageSize.SIZE_80),
                        arguments(61, 5, PackageSize.SIZE_80),
                        arguments(80, 5, PackageSize.SIZE_80),
                        arguments(81, 6, PackageSize.SIZE_100),
                        arguments(100, 6, PackageSize.SIZE_100),
                        arguments(81, 10, PackageSize.SIZE_100),
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
                        arguments(70, 3, PackageSize.SIZE_80),
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
                        arguments(101, 11)
                );
            }
        }
    }
}