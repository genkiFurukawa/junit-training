package utppp.ch07.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    private final int userId;
    private final String email;
    private final UserType type;

    /**
     * メールアドレスを変更する
     *
     * @param newEmail          newEmail
     * @param companyDomainName companyDomainName
     * @param numberOfEmployees numberOfEmployees
     * @return 従業員数
     */
    public int changeEmail(String newEmail, String companyDomainName, int numberOfEmployees) {
        return 0;
    }
}
