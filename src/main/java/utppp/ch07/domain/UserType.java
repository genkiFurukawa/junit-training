package utppp.ch07.domain;

public enum UserType {
    CUSTOMER(0),
    EMPLOYEE(1);

    private int id;

    UserType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static UserType valueOf(int id) {
        // values() で、列挙したオブジェクトをすべて持つ配列が得られる
        for (var userType : values()) {
            if (userType.getId() == id) { // id が一致するものを探す
                return userType;
            }
        }

        throw new IllegalArgumentException("no such enum object for the id: " + id);
    }
}
