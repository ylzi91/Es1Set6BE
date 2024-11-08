package YuriLenzi.Es1Set6BE.exceptions;

import YuriLenzi.Es1Set6BE.payloadsDTO.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(InconsistencyDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleBadRequest(InconsistencyDateException  ex){
        return new ErrorResponseDTO(ex.getMessage());
    }

    @ExceptionHandler(TravelingEmployeeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleBadRequest(TravelingEmployeeException  ex){
        return new ErrorResponseDTO(ex.getMessage());
    }

    @ExceptionHandler(DateTimeParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleBadRequest(DateTimeParseException  ex){
        return new ErrorResponseDTO("Il formato della data e sbagliato yyyy-mm-dd");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleBadRequest(IllegalArgumentException ex){
        return new ErrorResponseDTO("Lo stato può essere impostato solo con:  IN_PROGRAMMA, IN_CORSO, COMPLETATO");
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleBadRequest(BadRequestException  ex){
        return new ErrorResponseDTO(ex.getMessage());
    }

    @ExceptionHandler(SameUsernameorEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleBadRequest(SameUsernameorEmailException  ex){
        return new ErrorResponseDTO(ex.getMessage());
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponseDTO handleBadRequest(AuthorizationDeniedException ex){
        return new ErrorResponseDTO("Non sei un utente autorizzato!!");
    }



    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleNotFoundRequest(NotFoundException  ex){
        return new ErrorResponseDTO(ex.getMessage());
    }
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponseDTO handleNotFoundRequest(UnauthorizedException  ex){
        return new ErrorResponseDTO(ex.getMessage());
    }



}
