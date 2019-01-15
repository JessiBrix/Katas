public class PwCheck {
    public boolean verify(String password) {
        return password.length() >= 8 && password.trim().length() != 0 && password.matches(".*[a-z]+.*") && password.matches(".*[A-Z]+.*") && password.matches(".*[0-9]+.*");
    }
}
