package utppp.ch07.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    @DisplayName("メールアドレスを非従業員のものから従業員のものに変更する")
    void changing_email_from_non_corporate_to_corporate() {
        var company = new Company("my-corp.com", 1);
        var sut = new User(1, "user@gmail.com", UserType.CUSTOMER);

        sut.changeEmail("new@my-corp.com", company);

        assertEquals(2, company.getNumberOfEmployees());
        assertEquals("new@my-corp.com", sut.getEmail());
        assertEquals(UserType.EMPLOYEE, sut.getType());
        assertEquals(1, sut.getEmailChangedEvents().size());
        assertEquals(true, sut.getEmailChangedEvents().contains(new EmailChangedEvent(1, "new@my-corp.com")));
    }

    @Test
    @DisplayName("メールアドレスを従業員のものから非従業員のものに変更する")
    void changing_email_from_corporate_to_non_corporate() {
        var company = new Company("my-corp.com", 1);
        var sut = new User(1, "user@my-corp.com", UserType.EMPLOYEE);

        sut.changeEmail("user@gmail.com", company);

        assertEquals(0, company.getNumberOfEmployees());
        assertEquals("user@gmail.com", sut.getEmail());
        assertEquals(UserType.CUSTOMER, sut.getType());
        assertEquals(true, sut.getEmailChangedEvents().contains(new EmailChangedEvent(1, "user@gmail.com")));
    }

    @Test
    @DisplayName("ユーザの種別を変えずにメールアドレスを変更する")
    void changing_email_without_changing_user_type() {
        var company = new Company("my-corp.com", 1);
        var sut = new User(1, "user@gmail.com", UserType.EMPLOYEE);

        sut.changeEmail("new@my-corp.com", company);

        assertEquals(1, company.getNumberOfEmployees());
        assertEquals("new@my-corp.com", sut.getEmail());
        assertEquals(UserType.EMPLOYEE, sut.getType());
        assertEquals(true, sut.getEmailChangedEvents().contains(new EmailChangedEvent(1, "new@my-corp.com")));
    }

    @Test
    @DisplayName("メールアドレスを同じメールアドレスに変更する")
    void changing_email_to_the_same_one() {
        var company = new Company("my-corp.com", 1);
        var sut = new User(1, "user@gmail.com", UserType.CUSTOMER);

        sut.changeEmail("user@gmail.com", company);

        assertEquals(1, company.getNumberOfEmployees());
        assertEquals("user@gmail.com", sut.getEmail());
        assertEquals(UserType.CUSTOMER, sut.getType());
        assertEquals(0, sut.getEmailChangedEvents().size());
    }
}