package utppp.ch07.domain;

public class UserFactory {
    public static User create(Object[] data) {
        if (data.length < 3) {
            throw new IllegalArgumentException();
        }

        int id = (int) data[0];
        String email = (String) data[1];
        UserType type = UserType.valueOf((int) data[2]);

        return new User(id, email, type);
    }
}
