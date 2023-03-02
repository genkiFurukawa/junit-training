package unit.test.training.part1;

/**
 * 1.2 キッチンスケール
 * （前提）1g単位で測定
 * （前提）2,000gを超えた場合は表示欄に「EEEE」が表示される
 * （前提）重さがマイナスの場合は表示欄に「EEEE」が表示される
 * <p>
 * （仕様）
 * 1g単位で計測した重さを表示する
 */
public class KitchenScale {
    private int weight;

    public KitchenScale(int weight) {
        this.weight = weight;
    }

    public String getDisplayMessage() {
        if (0 <= this.weight && this.weight <= 2000) {
            return String.valueOf(this.weight);
        } else {
            return "EEEE";
        }
    }
}
