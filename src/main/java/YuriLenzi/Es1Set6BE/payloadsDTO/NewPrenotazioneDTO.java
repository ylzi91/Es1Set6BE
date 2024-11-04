package YuriLenzi.Es1Set6BE.payloadsDTO;

import jakarta.validation.constraints.NotEmpty;

public record NewPrenotazioneDTO(
        @NotEmpty(message = "La data non può essere vuota")
        String dataRichiesta,
        String noteDipendente
      ) {
}
