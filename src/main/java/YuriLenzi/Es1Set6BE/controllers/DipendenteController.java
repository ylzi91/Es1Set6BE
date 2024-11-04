package YuriLenzi.Es1Set6BE.controllers;


import YuriLenzi.Es1Set6BE.entities.Dipendente;
import YuriLenzi.Es1Set6BE.exceptions.BadRequestException;
import YuriLenzi.Es1Set6BE.payloadsDTO.NewDipendenteDTO;
import YuriLenzi.Es1Set6BE.payloadsDTO.NewImgDTO;
import YuriLenzi.Es1Set6BE.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {
    @Autowired
    DipendenteService dipendenteService;

    @GetMapping
    public List<Dipendente> getAllDipendenti(){
        return dipendenteService.findAll();
    }

    @GetMapping("/{username}")
    public Dipendente findById(@PathVariable String username){
        return dipendenteService.findByUsername(username);
    }

    @PostMapping
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

    @DeleteMapping("/{username}")
    public void deleteById(@PathVariable String username){
        dipendenteService.deleteDipendente(username);
    }

    @PatchMapping("/{username}/avatar")
    public NewImgDTO uploadAvatar(@RequestParam("avatar") MultipartFile file, @PathVariable String username){
        return dipendenteService.uploadAvatar(file, username);
    }


}