package seminars.third.tdd;

import java.util.Objects;

public class User {
    String name;
    String password;
    boolean isAdmin;
    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
   /* Разработайте класс User с методом аутентификации по логину и паролю. Метод должен возвращать true, если
    введенные логин и пароль корректны, иначе false. Протестируйте все методы
   */
    public boolean authenticate(String name, String password) {
        isAuthenticate = Objects.equals(this.name, name) && Objects.equals(this.password, password);
        return isAuthenticate;
    }

    public boolean logOut(String name, String password) {
        if (Objects.equals(this.name, name) && Objects.equals(this.password, password) && !isAdmin) {
            isAuthenticate = false;
            return true;
        }
        return false;
    }
}