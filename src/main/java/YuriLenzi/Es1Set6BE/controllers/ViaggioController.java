package YuriLenzi.Es1Set6BE.controllers;

import YuriLenzi.Es1Set6BE.entities.Viaggio;
import YuriLenzi.Es1Set6BE.exceptions.BadRequestException;
import YuriLenzi.Es1Set6BE.payloadsDTO.NewStatoDTO;
import YuriLenzi.Es1Set6BE.payloadsDTO.NewViaggioDTO;
import YuriLenzi.Es1Set6BE.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {
    @Autowired
    ViaggioService viaggioService;

    @GetMapping
    List<Viaggio> getAllViaggi(){
        return viaggioService.findAll();
    }

    @GetMapping("/{idViaggio}")
    public Viaggio findById(@PathVariable Long idViaggio){
        return viaggioService.findByid(idViaggio);
    }

    @PostMapping
    public Viaggio saveViaggio(@RequestBody @Validated NewViaggioDTO body, BindingResult validationResult){
        if(validationResult.hasErrors()){
            String message = validationResult.getAllErrors().
                    stream().
                    map(DefaultMessageSourceResolvable::getDefaultMessage).
                    collect(Collectors.joining(". "));
            throw new BadRequestException(message);
        }
        return viaggioService.saveViaggio(body);
    }

    @PatchMapping("/{idViaggio}")
    public Viaggio aggiornaStato(@RequestBody @Validated NewStatoDTO body, BindingResult validation, @PathVariable Long idViaggio){
        if(validation.hasErrors()){
            String message = validation.
                    getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(". "));
            throw new BadRequestException(message);
        }
        return viaggioService.cambiaStato(body, idViaggio);

    }

    @DeleteMapping("/{idViaggio}")
    public void deleteById(@PathVariable Long idViaggio){
        viaggioService.deleteViaggio(idViaggio);
    }

}
