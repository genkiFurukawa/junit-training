package unit.test.training.part1;

import java.math.BigDecimal;

/**
 * 1.4 手芸用品点の値段計算
 */
public class ClothPriceCalculator {
    /**
     * 布の長さから値段を計算する
     *
     * @param clothLength 布の長さ
     * @return 布の値段
     */
    public static int getPrice(double clothLength) {
        // 上限は100.0m、下限は0.1m
        if (clothLength < 0.1 || clothLength > 100) {
            throw new IllegalArgumentException();
        }
        // 小数点第一位まで有効なので、BigDecimal型で小数点第一位まで扱う
        var truncatedClothLength = new BigDecimal(String.valueOf((Math.floor(clothLength * 10)) / 10));

        System.out.println("変換前: " + clothLength + ",変換後: " + truncatedClothLength);

        // 3.0mより大きいの時は1mあたり350円の単価が適用される
        if ((new BigDecimal("3.0")).compareTo(truncatedClothLength) == -1) {
            var price = ((new BigDecimal("350")).multiply(truncatedClothLength));
            return price.intValue();
        }

        // 3.0m以下の時は1mあたり400円の単価が適用される
        var price = ((new BigDecimal("400")).multiply(truncatedClothLength));
        System.out.println(price);
        return price.intValue();
    }
}
