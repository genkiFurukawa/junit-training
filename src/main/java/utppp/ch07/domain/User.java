package utppp.ch07.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    private int userId;
    private String email;
    private UserType type;

    /**
     * メールアドレスを変更する
     *
     * @param newEmail          newEmail
     * @param companyDomainName companyDomainName
     * @param numberOfEmployees numberOfEmployees
     * @return 従業員数
     */
    public int changeEmail(String newEmail, String companyDomainName, int numberOfEmployees) {
        if (email.equals(newEmail)) {
            return numberOfEmployees;
        }

        var emailDomain = newEmail.split("@")[1];
        var isEmailCorporate = emailDomain.equals(companyDomainName);

        var newType = isEmailCorporate ? UserType.EMPLOYEE : UserType.CUSTOMER;

        if (!type.equals(newType)) {
            var delta = newType.equals(UserType.EMPLOYEE) ? 1 : -1;
            var newNumber = numberOfEmployees + delta;
            numberOfEmployees = newNumber;
        }

        this.email = newEmail;
        this.type = newType;

        return numberOfEmployees;
    }
}
