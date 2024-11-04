package YuriLenzi.Es1Set6BE.payloadsDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewViaggioDTO(
        @NotEmpty(message = "La destinazione non può essere vuota")
        @Size(min = 4, max = 30, message = "Minimo 4 caratteri e massimo 30")
        String destinazione,
        @NotEmpty(message = "La data non può essere vuota")
        String dataViaggio
) {}
