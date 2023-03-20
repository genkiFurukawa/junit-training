package unit.test.training.part2.part2_02;

import java.time.LocalDateTime;

public class WithdrawalCalculator {

    /**
     * ATMの引き出し手数料を計算する
     *
     * @param customer customer
     * @param dateTime dateTime
     * @return ATMの引き出し手数料
     */
    public static int calculateWithdrawal(Customer customer, LocalDateTime dateTime) {
        if (customer.isSpecialMember()) {
            return 0;
        }

        if (LocalDateTimeChecker.isWeekend(dateTime)) {
            return 110;
        }

        if (LocalDateTimeChecker.isBusinessHours(dateTime)) {
            return 0;
        }

        return 110;
    }
}
