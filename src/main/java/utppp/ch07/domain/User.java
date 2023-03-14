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
     * @param newEmail newEmail
     * @param company  company
     * @return 従業員数
     */
    public void changeEmail(String newEmail, Company company) {
        if (email.equals(newEmail)) {
            return;
        }

        var newType = company.isEmailCorporate(newEmail) ? UserType.EMPLOYEE : UserType.CUSTOMER;

        if (!type.equals(newType)) {
            var delta = newType.equals(UserType.EMPLOYEE) ? 1 : -1;
            company.changeNumberOfEmployees(delta);
        }

        this.email = newEmail;
        this.type = newType;
    }
}
