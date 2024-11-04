package YuriLenzi.Es1Set6BE.repositories;

import YuriLenzi.Es1Set6BE.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository <Dipendente, String> {
    boolean existsByemail(String email);
}
