package utppp.ch07.controller;

import lombok.AllArgsConstructor;
import utppp.ch07.domain.CompanyFactory;
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
    public String changEmail(int userId, String newEmail) {
        var data = database.getUserById(userId);
        var user = UserFactory.create(data);

        var error = user.canChangeEmail();
        if (error != null) {
            return "error";
        }

        var companyData = database.getCompany();
        var company = CompanyFactory.create(companyData);

        user.changeEmail(newEmail, company);

        database.saveCompany(company);
        database.saveUser(user);
        for (var ev : user.getEmailChangedEvents()) {
            messageBus.sendEmailChangedMessage(ev.getUserId(), ev.getNewEmail());
        }
        return "OK";
    }
}
