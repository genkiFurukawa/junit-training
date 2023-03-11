package utppp.ch05.mock;

/**
 * 5.1.2
 * Mockitoでvoidのメソッドが呼ばれていることを確認するためのサンプルクラス
 */
public class EmailGateway {
    public void sendGreetingsMail(String email) {
        return;
    }
}
