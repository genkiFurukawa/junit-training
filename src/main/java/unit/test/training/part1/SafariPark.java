package unit.test.training.part1;

/**
 * 1.5 年齢によって変わる入園料金
 * <p>
 * （前提）整数以外の入力を考慮する必要はないものとする
 */
public class SafariPark {
    public static int CATEGORY_01_FEE = 0;
    public static int CATEGORY_02_FEE = 500;
    public static int CATEGORY_03_FEE = 1000;
    public static int CATEGORY_04_FEE = 1500;

    public static int calcEntranceFee(int age) {
        if (0 <= age && age <= 5) {
            return CATEGORY_01_FEE;
        }

        if (6 <= age && age <= 12) {
            return CATEGORY_02_FEE;
        }

        if (13 <= age && age <= 17) {
            return CATEGORY_03_FEE;
        }

        if (18 <= age && age <= 140) {
            return CATEGORY_04_FEE;
        }

        throw new IllegalArgumentException("入力された年齢の値がどのカテゴリーにも属しません age: " + age);
    }
}
