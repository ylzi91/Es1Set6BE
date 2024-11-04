package YuriLenzi.Es1Set6BE.repositories;

import YuriLenzi.Es1Set6BE.entities.Dipendente;
import YuriLenzi.Es1Set6BE.entities.Prenotazione;
import YuriLenzi.Es1Set6BE.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean existsByDipendenteAndViaggio(Dipendente dipendente, Viaggio viaggio);
    List<Prenotazione> findByDipendente(Dipendente dipendente);
}
