package unit.test.training.part1.chick_courier_service;

/**
 * NOTE: ChatGPTで生成したコードを修正
 * (Prompt)
 * Javaでクラスを生成してください。
 * 引数がint型の3辺合計(cm)とint型の重量(kg)で返り値は荷物サイズを返します。
 * 荷物サイズは60サイズ、80サイズ、100サイズの3種類です。
 * 3辺合計が60または重量が2kg以下の時は60サイズ、3辺合計が80または重量が5kg以下の時は80サイズ、3辺合計が100または重量が10kg以下の時は80サイズとなります。
 * <p>
 * This class provides a method for calculating the package size based on the total length and weight of the package.
 */
public class PackageSizeCalculator {
    /**
     * Calculates the package size based on the total length and weight of the package.
     *
     * @param totalLength The total length of the package in centimeters.
     * @param weight      The weight of the package in kilograms.
     * @return The package size, which can be 60, 80, or 100.
     * @throws IllegalArgumentException If the package size is invalid.
     */
    public static PackageSize calculatePackageSize(int totalLength, int weight) throws IllegalArgumentException {
        if (0 <= totalLength && totalLength <= 60 && 0 <= weight && weight <= 2) {
            return PackageSize.SIZE_60;
        } else if (totalLength <= 80 && weight <= 5) {
            return PackageSize.SIZE_80;
        } else if (totalLength <= 100 && weight <= 10) {
            return PackageSize.SIZE_100;
        } else {
            throw new IllegalArgumentException("Invalid package size. totalLength: " + totalLength + ", weight" + weight);
        }
    }
}
