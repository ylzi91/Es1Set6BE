package YuriLenzi.Es1Set6BE.payloadsDTO;

import jakarta.validation.constraints.NotEmpty;

public record NewStatoDTO(
        @NotEmpty(message = "Lo stato non può essere vuoto")
        String stato) { }
