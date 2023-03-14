package utppp.ch07.controller;

public interface IMessageBus {
    /**
     * メールアドレス変更通知を行う
     *
     * @param userId   userId
     * @param newEmail newEmail
     */
    void sendEmailChangedMessage(int userId, String newEmail);
}
