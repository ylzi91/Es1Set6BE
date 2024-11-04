package YuriLenzi.Es1Set6BE.exceptions;

public class SameUsernameorEmailException extends RuntimeException {
    public SameUsernameorEmailException(String usOrMail) {
        super(usOrMail + " già presente");
    }

}
