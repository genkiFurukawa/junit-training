package utppp.ch07.controller;

import lombok.AllArgsConstructor;
import utppp.ch07.domain.UserFactory;

@AllArgsConstructor
public class UserController {
    private final IDatabase database;
    private final IMessageBus messageBus;

    /**
     * メールアドレスを変更する
     *
     * @param userId   userId
     * @param newEmail newEmail
     */
    public void changEmail(int userId, String newEmail) {
        var data = database.getUserById(userId);
        var user = UserFactory.create(data);

        var companyData = database.getCompany();
        var companyDomainName = (String) companyData[0];
        int numberOfEmployees = (int) companyData[1];

        var newNumberOfEmployees = user.changeEmail(newEmail, companyDomainName, numberOfEmployees);
        database.saveCompany(newNumberOfEmployees);
        database.saveUser(user);
        messageBus.sendEmailChangedMessage(userId, newEmail);
    }
}
