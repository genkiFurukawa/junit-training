package utppp.ch05.mock;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Mockitoの素振りをするためのテストコード
 * Mockitoでvoidのメソッドが呼ばれていることを確認するためのサンプルクラス
 */
public class ControllerTest {

    /**
     * p.134のテストをJavaで書き換えたもの
     */
    @Test
    void sending_a_greetings_email() {
        var mock = Mockito.mock(EmailGateway.class);// <- テストダブルとしてのモックを作る
        doNothing().when(mock).sendGreetingsMail(isA(String.class));
        var sut = new Controller(mock);

        sut.greetUser("user@email.com");

        // NOTE: テスト対象システムからテストダブルに対して行われた呼び出しを検証する
        verify(mock, atMostOnce()).sendGreetingsMail("user@email.com");
    }
}
