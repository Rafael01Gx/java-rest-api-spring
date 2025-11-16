package med.voll.api.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.domain.medico.AtualizarMedicoDto;
import med.voll.api.domain.medico.CadastroMedicoDto;
import med.voll.api.domain.medico.DetalhesMedicoDto;
import med.voll.api.domain.medico.ListagemMedicoDto;
import med.voll.api.domain.medico.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<DetalhesMedicoDto> cadastrar(@RequestBody @Valid CadastroMedicoDto dto, UriComponentsBuilder uriBuilder){
        var medico = medicoService.cadastrar(dto);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesMedicoDto(medico));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemMedicoDto>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return ResponseEntity.ok(medicoService.listar(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesMedicoDto> obter(@PathVariable Long id){
        return ResponseEntity.ok().body(medicoService.detalhar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalhesMedicoDto> atualizar(@PathVariable Long id , @RequestBody @Valid AtualizarMedicoDto dto){
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
