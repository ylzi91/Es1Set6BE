package YuriLenzi.Es1Set6BE.exceptions;

public class InconsistencyDateException extends RuntimeException {
    public InconsistencyDateException() {
        super(
                "La data di prenotazione non può essere successiva a quella di viaggio"
        );
    }
}
