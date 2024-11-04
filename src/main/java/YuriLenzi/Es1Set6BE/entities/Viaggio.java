package YuriLenzi.Es1Set6BE.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "viaggi")
public class Viaggio {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private String destinazione;
    private LocalDate dataViaggio;
    @Enumerated(EnumType.STRING)
    private Stato statoViaggio;
    @OneToMany(mappedBy = "viaggio", cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Prenotazione> prenotazioneList;


    public Viaggio(String destinazione, LocalDate dataViaggio) {
        this.destinazione = destinazione;
        this.dataViaggio = dataViaggio;
        this.statoViaggio = Stato.IN_PROGRAMMA;
    }
}
