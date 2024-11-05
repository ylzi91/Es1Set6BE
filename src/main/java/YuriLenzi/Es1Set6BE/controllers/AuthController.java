package YuriLenzi.Es1Set6BE.controllers;

import YuriLenzi.Es1Set6BE.entities.Dipendente;
import YuriLenzi.Es1Set6BE.exceptions.BadRequestException;
import YuriLenzi.Es1Set6BE.payloadsDTO.DipendenteLoginDTO;
import YuriLenzi.Es1Set6BE.payloadsDTO.DipendeteLoginResponseDTO;
import YuriLenzi.Es1Set6BE.payloadsDTO.NewDipendenteDTO;
import YuriLenzi.Es1Set6BE.services.AuthService;
import YuriLenzi.Es1Set6BE.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    DipendenteService dipendenteService;

    @PostMapping("/login")
    public DipendeteLoginResponseDTO login(@RequestBody DipendenteLoginDTO dipendenteLoginDTO){
        return new DipendeteLoginResponseDTO(authService.checkCredentialsAndGenerateToken(dipendenteLoginDTO));
    }

    @PostMapping("/register")
    public Dipendente saveDipendente(@RequestBody @Validated NewDipendenteDTO body, BindingResult validationResult){
        if(validationResult.hasErrors()){
            String message = validationResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(". "));
            throw new BadRequestException(message);
        }
        return dipendenteService.saveDipendente(body);
    }
}
