package unit.test.training.part2.part2_02;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeChecker {
    /**
     * 土日かどうかチェックする
     *
     * @param dateTime dateTime
     * @return 土日のどちらかであればtrueを返す
     */
    public static boolean isWeekend(LocalDateTime dateTime) {
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();

        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    /**
     * 営業時間かどうかをチェックする
     *
     * @param dateTime dateTime
     * @return 平日の営業時間内であればtrueを返す
     */
    public static boolean isBusinessHours(LocalDateTime dateTime) {
        LocalTime time = dateTime.toLocalTime();
        LocalTime openTime = LocalTime.of(8, 44);
        LocalTime closeTime = LocalTime.of(18, 00);

        return !isWeekend(dateTime) && time.isAfter(openTime) && time.isBefore(closeTime);
    }
}
