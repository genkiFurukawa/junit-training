package utppp.ch07.controller;

import utppp.ch07.domain.Company;
import utppp.ch07.domain.User;

public interface IDatabase {
    /**
     * ユーザIDに紐付くユーザ情報を取得
     *
     * @param userId ユーザID
     * @return ユーザ情報
     */
    Object[] getUserById(int userId);

    /**
     * 会社情報を取得する
     *
     * @return 会社情報
     */
    Object[] getCompany();

    /**
     * ユーザを保存 or 更新する
     *
     * @param user user
     */
    void saveUser(User user);

    /**
     * 会社の情報を更新する
     *
     * @param company company
     */
    void saveCompany(Company company);
}
