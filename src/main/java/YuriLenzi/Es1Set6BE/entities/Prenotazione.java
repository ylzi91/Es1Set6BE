package YuriLenzi.Es1Set6BE.entities;

import YuriLenzi.Es1Set6BE.exceptions.InconsistencyDateException;
import YuriLenzi.Es1Set6BE.exceptions.TravelingEmployeeException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate dataRichiesta;
    private String noteDipendente;
    @ManyToOne
    Dipendente dipendente;
    @ManyToOne
    Viaggio viaggio;

    public Prenotazione(LocalDate dataRichiesta, String noteDipendente, Dipendente dipendente, Viaggio viaggio) {
        checkData(viaggio, dataRichiesta);
        checkInViaggio(viaggio);
        this.dataRichiesta = dataRichiesta;
        this.noteDipendente = noteDipendente;
        this.dipendente = dipendente;
        this.viaggio = viaggio;
    }

    private void checkData(Viaggio checkViaggio, LocalDate data){
       if(checkViaggio.getDataViaggio().isBefore(data))
           throw new InconsistencyDateException();
    }
    private void checkInViaggio(Viaggio viaggio){
        if(viaggio.getStatoViaggio() == Stato.IN_CORSO){
            throw new TravelingEmployeeException();
        }
    }
}
