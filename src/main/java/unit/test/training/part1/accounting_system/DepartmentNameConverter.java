package unit.test.training.part1.accounting_system;

public class DepartmentNameConverter {
    /**
     * 1.13
     * 部署コードから部署名を出力する
     * 簡略化のために100,110,120,500,510,520,950,960のみ対応する（書籍の書いてあるもの）。
     *
     * @param code 部署コード
     * @return 部署名。部署コードに該当する部署がない場合は「該当する部署はありません」を返す
     */
    public static String convertDepartmentName(ThreeDigitCode code) {
        if (code == null) {
            throw new IllegalArgumentException("code is null");
        }

        switch (code.getCode()) {
            case 100:
                return "本店総務部";
            case 110:
                return "本店資材部";
            case 120:
                return "本店経理部";
            case 500:
                return "北海道支店";
            case 510:
                return "青森支店";
            case 520:
                return "秋田支店";
            case 940:
                return "宮崎支店";
            case 950:
                return "鹿児島支店";
            case 960:
                return "沖縄支店";
            default:
                return "該当する部署はありません";
        }

    }
}
