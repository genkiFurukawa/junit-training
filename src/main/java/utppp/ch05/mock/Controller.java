package utppp.ch05.mock;

/**
 * 5.1.2
 *
 */
public class Controller {
    private EmailGateway emailGateway;

    public Controller(EmailGateway emailGateway) {
        this.emailGateway = emailGateway;
    }

    public void greetUser(String email) {
        emailGateway.sendGreetingsMail(email);
    }
}
