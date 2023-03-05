package unit.test.training.part1.company_a;

/**
 * 1.10 の問題文に記載されたコードをJavaに変換して写経
 */
public class DiscountPolicy {
    public static int getDiscountRate(int day) {
        if ((1 <= day) && (day <= 5)) {
            return 20;
        } else if ((28 <= day) && (day <= 30)) {
            return 20;
        } else {
            return 0;
        }
    }
}
