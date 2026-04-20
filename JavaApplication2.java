package JavaApplication2;  

public class JavaApplication2 {

    private String username;
    private String password;
    private String phoneNumber;
  
    // Check username format
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Check password complexity
    public boolean checkPasswordComplexity(String password) {
        return password.matches("(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}");
    }

    // Check South African phone number
    public boolean checkCellPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\+27\\d{9}");
    }

    // Register user
    public String registerUser(String username, String password, String phoneNumber) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted. Please ensure it contains an underscore and is no more than 5 characters.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted. It must contain at least 8 characters, a capital letter, a number and a special character.";
        }

        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;

        return "User registered successfully.";
    }

    // Login check
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Login message
    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Welcome user, it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
