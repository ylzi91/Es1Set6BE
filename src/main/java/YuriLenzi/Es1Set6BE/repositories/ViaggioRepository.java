package YuriLenzi.Es1Set6BE.repositories;

import YuriLenzi.Es1Set6BE.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
}
