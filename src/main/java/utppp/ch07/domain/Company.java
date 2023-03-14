package utppp.ch07.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Company {
    private String domainName;
    private int numberOfEmployees;

    /**
     * 従業員数を変更する
     *
     * @param delta delta
     */
    public void changeNumberOfEmployees(int delta) {
        if (numberOfEmployees + delta < 0) {
            throw new IllegalArgumentException();
        }

        numberOfEmployees += delta;
    }

    /**
     * ユーザのメールアドレスに自社のドメイン名が含まれているかどうか確認する
     *
     * @param email
     * @return ユーザのメールアドレスに自社のドメイン名が含まれているかどうか
     */
    public boolean isEmailCorporate(String email) {
        var emailDomain = email.split("@")[1];
        return emailDomain.equals(domainName);
    }
}
