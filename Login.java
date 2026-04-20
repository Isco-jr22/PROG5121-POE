package JavaApplication2;

public class Login {
public static void main(String[]args) {
    
}
    private String storedUsername;
    private String storedPassword;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        boolean length = password.length() >= 8;
        boolean capital = password.matches(".[A-Z].");
         boolean number = password.matches(".[0-9].");
        boolean special = password.matches(".[!@#$%^&()].*");

        return length && capital && number && special;
    }

    public boolean checkCellPhoneNumber(String phone) {
        return phone.matches("\\+27\\d{9}");
    }

    public String registerUser(String username, String password, String phone) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted.";
        }

        if (!checkCellPhoneNumber(phone)) {
            return "Cell phone number incorrectly formatted.";
        }

        storedUsername = username;
        storedPassword = password;

        return "User successfully registered.";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    public String returnLoginStatus(boolean status) {
        if (status) {
            return "Login successful";
        } else {
            return "Username or password incorrect";
        }
    }
}