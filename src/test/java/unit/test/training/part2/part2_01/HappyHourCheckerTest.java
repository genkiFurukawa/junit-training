package unit.test.training.part2.part2_01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HappyHourCheckerTest {
    @DisplayName("16:00から17:59の間はハッピーアワーであること（境界値）")
    @ParameterizedTest(name="{0}年{1}月{2}日{3}時{4}分の時trueを返すこと")
    @CsvSource({
            "2023,3,17,16,0",
            "2023,3,17,17,59"
    })
    void _16時00分から17時59分の間はハッピーアワーであること_境界値(int year, int month, int day, int hour, int minute) {
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);

        boolean result = HappyHourChecker.isHappyHour(localDateTime );

        assertTrue(result);
    }

    @DisplayName("16:00から17:59の間以外はハッピーアワーではないこと（境界値）")
    @ParameterizedTest(name="{0}年{1}月{2}日{3}時{4}分の時falseを返すこと")
    @CsvSource({
            "2023,3,17,15,59",
            "2023,3,17,18,0"
    })
    void _16時00分から17時59分の間以外はハッピーアワーではないこと_境界値(int year, int month, int day, int hour, int minute) {
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);

        boolean result = HappyHourChecker.isHappyHour(localDateTime );

        assertFalse(result);
    }

    @DisplayName("16:00から17:59の間はハッピーアワーであること（代表値）")
    @ParameterizedTest(name="{0}年{1}月{2}日{3}時{4}分の時trueを返すこと")
    @CsvSource({
            "2023,3,17,17,0",
    })
    void _16時00分から17時59分の間はハッピーアワーであること_代表値(int year, int month, int day, int hour, int minute) {
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);

        boolean result = HappyHourChecker.isHappyHour(localDateTime );

        assertTrue(result);
    }

    @DisplayName("16:00から17:59の間以外はハッピーアワーではないこと（代表値）")
    @ParameterizedTest(name="{0}年{1}月{2}日{3}時{4}分の時falseを返すこと")
    @CsvSource({
            "2023,3,17,10,0",
            "2023,3,17,21,0"
    })
    void _16時00分から17時59分の間以外はハッピーアワーではないこと_代表値(int year, int month, int day, int hour, int minute) {
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);

        boolean result = HappyHourChecker.isHappyHour(localDateTime );

        assertFalse(result);
    }
}