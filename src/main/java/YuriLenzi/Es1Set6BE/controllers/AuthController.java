package YuriLenzi.Es1Set6BE.controllers;

import YuriLenzi.Es1Set6BE.payloadsDTO.DipendenteLoginDTO;
import YuriLenzi.Es1Set6BE.payloadsDTO.DipendeteLoginResponseDTO;
import YuriLenzi.Es1Set6BE.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    DipendenteService dipendenteService;

    @PostMapping("/login")
    public DipendeteLoginResponseDTO login(@RequestBody DipendenteLoginDTO dipendenteLoginDTO){
        return null;
    }
}
