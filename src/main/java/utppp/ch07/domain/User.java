package utppp.ch07.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User {
    private int userId;
    private String email;
    private UserType type;
    private List<EmailChangedEvent> emailChangedEvents;

    public User(int userId, String email, UserType type) {
        this.userId = userId;
        this.email = email;
        this.type = type;
        this.emailChangedEvents = new ArrayList<>();
    }

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
        emailChangedEvents.add(new EmailChangedEvent(userId, newEmail));
    }
}
