package unit.test.training.part1.company_b;

/**
 * 1.11 の問題文に記載されたコードをJavaに変換して写経
 */
public class DiscountPolicy {
    public static int getDiscountRate(int day) {
        if (day == 1) return 20;
        if (day == 2) return 20;
        if (day == 3) return 20;
        if (day == 4) return 20;
        if (day == 5) return 20;
        if (day == 28) return 20;
        if (day == 29) return 20;
        if (day == 30) return 20;

        return 0;
    }
}
