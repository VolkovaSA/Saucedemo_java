package user;

import utilis.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withLockedUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.locked_out_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withProblemUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.problem_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withErrorUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.error_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withGlitchUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.glitch_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmptyUsername() {
        return new User(PropertyReader.getProperty("saucedemo.empty_username"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmptyPassword() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.empty_password"));
    }
}
