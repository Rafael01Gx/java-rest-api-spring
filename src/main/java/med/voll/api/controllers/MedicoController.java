package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.medico.AtualizarMedicoDto;
import med.voll.api.medico.CadastroMedicoDto;
import med.voll.api.medico.ListagemMedicoDto;
import med.voll.api.medico.Medico;
import med.voll.api.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Medico> cadastrar(@RequestBody @Valid CadastroMedicoDto dto){
        return ResponseEntity.ok(medicoService.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemMedicoDto>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return ResponseEntity.ok(medicoService.listar(paginacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListagemMedicoDto> atualizar(@PathVariable Long id ,@RequestBody @Valid AtualizarMedicoDto dto){
        return ResponseEntity.ok(medicoService.atualizar(id,dto));
    }

    @DeleteMapping("/desativar/{id}")
    public ResponseEntity<String> desativar(@PathVariable Long id){
        medicoService.desativar(id);
        return ResponseEntity.ok("Médico desativado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id){
        medicoService.excluir(id);
        return ResponseEntity.ok("Médico excluído com sucesso!");
    }
}
