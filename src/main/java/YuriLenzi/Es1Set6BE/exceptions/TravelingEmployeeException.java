package YuriLenzi.Es1Set6BE.exceptions;

public class TravelingEmployeeException extends RuntimeException {
    public TravelingEmployeeException() {
        super("Il dipendente è già in viaggio");
    }
}
