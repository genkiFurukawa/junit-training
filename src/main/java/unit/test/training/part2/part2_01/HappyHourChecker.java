package unit.test.training.part2.part2_01;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * ChatGPTで生成
 * [プロンプト]
 * ハッピアワーであることを判定するクラスをJavaで生成してください。
 * 引数の型はLocalDateTimeです。
 * 仕様は引数の値が16:00から17:59であれば、返り値の型がbooleanでハッピアワーであることをtrueとして返します。
 */
public class HappyHourChecker {
    /**
     * 引数で渡された時刻が、16:00から17:59までの間であれば true を返す。
     *
     * @param dateTime チェックする日時
     * @return 引数で渡された日時がハッピーアワーであるかどうか
     */
    public static boolean isHappyHour(LocalDateTime dateTime) {
        LocalTime time = dateTime.toLocalTime();
        return time.isAfter(LocalTime.of(15, 59)) && time.isBefore(LocalTime.of(18, 0));
    }
}
