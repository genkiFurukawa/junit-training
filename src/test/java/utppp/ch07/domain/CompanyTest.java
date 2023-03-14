package utppp.ch07.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    @ParameterizedTest
    @CsvSource({
            "my-corp.com, email@my-corp.com, true",
            "my-corp.com, email@gmail.com, false"
    })
    void differentiates_a_corporate_email_from_non_corporate(String domain, String email, boolean expected) {
        var sut = new Company(domain, 0);

        var isEmailCorporate = sut.isEmailCorporate(email);

        assertEquals(expected, isEmailCorporate);
    }
}