package YuriLenzi.Es1Set6BE.services;

import YuriLenzi.Es1Set6BE.entities.Dipendente;
import YuriLenzi.Es1Set6BE.exceptions.BadRequestException;
import YuriLenzi.Es1Set6BE.exceptions.NotFoundException;
import YuriLenzi.Es1Set6BE.exceptions.SameUsernameorEmailException;
import YuriLenzi.Es1Set6BE.payloadsDTO.NewDipendenteDTO;
import YuriLenzi.Es1Set6BE.payloadsDTO.NewImgDTO;
import YuriLenzi.Es1Set6BE.repositories.DipendenteRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DipendenteService {
    @Autowired
    DipendenteRepository dipendenteRepository;

    @Autowired
    Cloudinary cloudinaryUploader;

    @Autowired
    private PasswordEncoder bcrypt;

    public List<Dipendente> findAll(){
        return dipendenteRepository.findAll();
    }

    public Dipendente findByUsername(String username){
        Dipendente found = null;
        found = dipendenteRepository.findById(username).orElseThrow(() -> new NotFoundException(username));
        return found;
    }

    public Dipendente saveDipendente(NewDipendenteDTO body){
        if(dipendenteRepository.findById(body.username()).isPresent())
            throw new SameUsernameorEmailException(body.username());
        else if(dipendenteRepository.existsByemail(body.email()))
            throw new SameUsernameorEmailException(body.email());
        else{
            Dipendente nuovoDipendente = new Dipendente(body.username(), body.nome(), body.cognome(), body.email());
            nuovoDipendente.setPassword(bcrypt.encode(body.password()));
            dipendenteRepository.save(nuovoDipendente);
            return nuovoDipendente;
        }
    }

    public void deleteDipendente(String username){
        Dipendente found = findByUsername(username);
        dipendenteRepository.delete(found);
    }

    public NewImgDTO uploadAvatar(MultipartFile file, String username) {
        Dipendente found = findByUsername(username);
        String url = null;
        try {
            url = (String) cloudinaryUploader.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        } catch (IOException e) {
            throw new BadRequestException("Errore nell'upload dell'immagine");
        }
        found.setUrlImg(url);
        dipendenteRepository.save(found);
        return new NewImgDTO("Ecco l'url dell'immagine", url);
    }

}
