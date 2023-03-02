package unit.test.training.part1;

/**
 * 1.3 畳の枚数から面積を計算するツール
 * （前提）入力は整数
 * （前提）枚数は整数
 * （前提）byte型を超えるとエラーが発生する
 * （前提）- 128 ~ 0を入力するとエラーが発生する
 *
 * （仕様）面積 = 1.65 * 畳数
 */
public class TatamiAreaCalculator {
    private int number;

    public TatamiAreaCalculator(final int number) {
        this.number = number;
    }

    public float getTatamiArea() {
        if (-128 <= this.number && this.number <= 0) {
            throw new IllegalStateException("畳数は1以上を入力してください");
        }

        if (this.number < -128 || this.number > 127) {
            throw new IllegalStateException();
        }

        // NOTE: floatで計算すると数値が誤差により数値が会わなくなるので整数で計算してから100で割る
        return (float) ((this.number * 165) / 100);
    }
}
