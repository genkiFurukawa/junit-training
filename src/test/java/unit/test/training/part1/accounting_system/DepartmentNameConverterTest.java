package unit.test.training.part1.accounting_system;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("部署コードから部署名に変換するメソッドのテスト")
class DepartmentNameConverterTest {

    @ParameterizedTest(name = "部署コードが「{0}」の時、部署名が「{1}」となること")
    @MethodSource("有効値のテストケース")
    void 有効値のテスト(int departmentCode, String expected) {
        var code = new ThreeDigitCode(departmentCode);

        var result = DepartmentNameConverter.convertDepartmentName(code);

        assertEquals(expected, result);

    }

    @ParameterizedTest(name = "部署コードが「{0}」の時、IllegalArgumentExceptionがスローされること")
    @MethodSource("無効値のテストケース")
    void 無効値のテスト(int departmentCode) {
        assertThrows(IllegalArgumentException.class, () -> {
           var code = new ThreeDigitCode(departmentCode);
           DepartmentNameConverter.convertDepartmentName(code);
        });
    }

    static Stream<Arguments> 有効値のテストケース() {
        return Stream.of(
                arguments(100, "本店総務部"),
                arguments(101, "該当する部署はありません"),
                arguments(110, "本店資材部"),
                arguments(960, "沖縄支店"),
                arguments(999, "該当する部署はありません")
        );
    }

    static Stream<Arguments> 無効値のテストケース() {
        return Stream.of(
                arguments(0),
                arguments(99),
                arguments(1000),
                arguments(1500)
        );
    }
}