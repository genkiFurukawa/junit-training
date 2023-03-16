package utppp.ch07.domain;

public class UserFactory {
    public static User create(Object[] data) {
        if (data.length < 4) {
            throw new IllegalArgumentException();
        }

        int id = (int) data[0];
        String email = (String) data[1];
        UserType type = UserType.valueOf((int) data[2]);
        boolean isisEmailConfirmed = (boolean) data[3];

        return new User(id, email, type, isisEmailConfirmed);
    }
}
