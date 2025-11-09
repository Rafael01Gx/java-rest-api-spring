package med.voll.api.controller;

import med.voll.api.medico.CadastroMedicoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody CadastroMedicoDto dto){
        IO.println(dto);
        return ResponseEntity.ok().build();
    }
}
