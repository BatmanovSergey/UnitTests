package seminars.third.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    static UserRepository repository;

    @BeforeAll
    static void setUp() {

        repository = new UserRepository();
    }

    @Test
    void checkAuthentificateUserPositive() {
        String name = "name";
        String password = "password";
        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, password);

        assertTrue(accept);
    }

    @Test
    void checkAuthentificateUserNegative() {
        String name = "name";
        String password = "password";
        String wrongPassword = "wrongPassword";
        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, wrongPassword);

        assertFalse(accept);
    }

    @Test
    void checkRepositoryAddAuthentificatedUserPositive() {
        String name = "name";
        String password = "password";
        User user = new User(name, password, false);
        user.authenticate(name, password);

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size()).isEqualTo(currentCount + 1);

        User userInRepository = repository.data.get(repository.data.size() - 1);

        assertEquals(user, userInRepository);

    }

    @Test
    void checkRepositoryNotAddAuthentificatedUserNegative() {
        String name = "name";
        String password = "password";
        String wrongPassword = "wrongPassword";
        User user = new User(name, password, false);
        user.authenticate(name, wrongPassword); // или можно просто удалить строчку аутентификации

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size()).isEqualTo(currentCount);
    }

    @Test
    void checkLogOutUser() {
        String name = "name";
        String password = "password";
        User user = new User(name, password, false);
        user.authenticate(name, password);
        boolean accept = user.logOut(name, password);
        assertTrue(accept);
    }

    @Test
    void checkNotLogOutUserAdmin() {
        String name = "name";
        String password = "password";
        User user = new User(name, password, true);
        user.authenticate(name, password);
        boolean accept = user.logOut(name, password);
        assertFalse(accept);
    }

    @Test
    void checkRepositoryDeleteAuthentificatedUser() {
        String name = "name";
        String password = "password";
        User user = new User(name, password, false);
        user.authenticate(name, password);
        repository.addUser(user);

        int currentCount = repository.data.size();
        boolean accept = repository.deleteUser(user);

        assertTrue(accept);
        assertThat(repository.data.size()).isEqualTo(currentCount - 1);
    }

    @Test
    void checkRepositoryNotDeleteAuthentificatedUserAdmin() {
        String name = "name";
        String password = "password";
        User user = new User(name, password, true);
        user.authenticate(name, password);
        repository.addUser(user);

        int currentCount = repository.data.size();
        boolean accept = repository.deleteUser(user);

        assertFalse(accept);
        assertThat(repository.data.size()).isEqualTo(currentCount);

        User userInRepository = repository.data.get(repository.data.size() - 1);
        assertEquals(user, userInRepository);

    }

}