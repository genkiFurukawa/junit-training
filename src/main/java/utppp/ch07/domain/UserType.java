package utppp.ch07.domain;

public enum UserType {
    CUSTOMER(0),
    EMPLOYEE(1);

    private int id;

    UserType(int id) {
        this.id = id;
    }
}
