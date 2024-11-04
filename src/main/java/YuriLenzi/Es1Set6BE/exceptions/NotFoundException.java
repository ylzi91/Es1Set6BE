package YuriLenzi.Es1Set6BE.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String username) {
        super(username + "Non trovato");
    }

    public NotFoundException(Long id) {
        super(id + " non trovato");
    }
}
