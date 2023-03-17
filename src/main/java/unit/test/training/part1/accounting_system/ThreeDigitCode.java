package unit.test.training.part1.accounting_system;

import java.util.Objects;

public class ThreeDigitCode {
    private int code;

    public ThreeDigitCode(int code) {
        if (code < 100 || code > 999) {
            throw new IllegalArgumentException("Code must be a three-digit integer.");
        }
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ThreeDigitCode)) return false;

        ThreeDigitCode that = (ThreeDigitCode) o;
        return getCode() == that.getCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
