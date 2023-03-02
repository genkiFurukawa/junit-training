package unit.test.training.part1;

/**
 * 1.1 ペット用室温計
 * （前提）室温計の精度は0.1度単位
 * （前提）室内で計測できる下限及び上限を考慮する必要はない
 * <p>
 * （仕様）
 * ①24.0度未満 => 「寒い」
 * ②24.0度以上26.0度未満 => 「快適」
 * ③26.0度以上 => 「暑い」
 */
public class RoomThermometer {
    // NOTE: 仕様は0.1度単位だが、floatで一旦実装する
    private float roomTemperature;

    public RoomThermometer(float roomTemperature) {
        this.roomTemperature = roomTemperature;
    }

    /**
     * 表示メッセージを取得する
     *
     * @return 表示メッセージ
     */
    public String getDisplayMessage() {
        if (this.roomTemperature < 24.0) {
            return "寒い";
        }

        if (24.0 <= this.roomTemperature && this.roomTemperature < 26.0) {
            return "快適";
        }

        if (26.0 <= this.roomTemperature) {
            return "暑い";
        }

        throw new UnsupportedOperationException();
    }
}
