package med.voll.api.services;

import med.voll.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public Paciente cadastrar(CadastroPacienteDto dto) {
        return pacienteRepository.save(new Paciente(dto));
    }


    public Page<ListagemPacienteDto> listar(Pageable paginacao) {
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(ListagemPacienteDto::new);
    }


    public DetalhesPacienteDto atualizar (AtualizacaoPacienteDto dto) {
        var paciente = pacienteRepository.getReferenceById(dto.id());
        paciente.atualizarInformacoes(dto);

        return new DetalhesPacienteDto(paciente);
    }

    @Transactional
    public void excluir(Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }


    public DetalhesPacienteDto detalhar(Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        return  new DetalhesPacienteDto(paciente);
    }



}
