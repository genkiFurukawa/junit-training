package unit.test.training.part1.chick_courier_service;

/**
 * NOTE: ChatGPTを使って生成したものを生成
 * (Prompt)
 * 60サイズ、80サイズ、100サイズの3種類の荷物サイズを表すJavaのEnumを書いてください。
 * <p>
 * This enum represents the different package sizes.
 */
public enum PackageSize {
    SIZE_60(60, 2),
    SIZE_80(80, 5),
    SIZE_100(100, 10);

    private final int totalLength;
    private final int weight;

    PackageSize(int totalLength, int weight) {
        this.totalLength = totalLength;
        this.weight = weight;
    }

    /**
     * Returns the size of the package.
     *
     * @return The size of the package.
     */
    public int getTotalLength() {
        return totalLength;
    }

    public int getWeight() {
        return weight;
    }
}
