package utppp.ch05.stub;

/**
 * リスト5.2のテスト写経用
 */
public class Controller {
    private IDatabase database;

    public Controller(IDatabase database) {
        this.database = database;
    }

    public int createReport() {
        return database.getNumberOfUsers();
    }
}
