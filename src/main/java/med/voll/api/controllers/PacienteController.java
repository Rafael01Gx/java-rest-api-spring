package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.CadastroPacienteDto;
import med.voll.api.paciente.Paciente;
import med.voll.api.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    @Transactional
    public ResponseEntity<Paciente> cadastrar(@RequestBody @Valid CadastroPacienteDto dto) {
       return ResponseEntity.ok(service.cadastrar(dto));
    }
}