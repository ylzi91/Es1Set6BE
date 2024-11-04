package YuriLenzi.Es1Set6BE.services;

import YuriLenzi.Es1Set6BE.entities.Dipendente;
import YuriLenzi.Es1Set6BE.exceptions.UnauthorizedException;
import YuriLenzi.Es1Set6BE.payloadsDTO.DipendenteLoginDTO;
import YuriLenzi.Es1Set6BE.tools.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private DipendenteService dipendenteService;
    @Autowired
    private JWT jwt;

    public String checkCredentialsAndGenerateToken(DipendenteLoginDTO body){
        Dipendente found = dipendenteService.findByUsername(body.username());
        if(found.getPassword().equals(body.password())){
            String accesToken = jwt.createToken(found);
            return accesToken;
        }
        else {
            throw new UnauthorizedException("Credenziali errate");
        }
    }
}
