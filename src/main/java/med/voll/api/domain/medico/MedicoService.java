package med.voll.api.domain.medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public Medico cadastrar(CadastroMedicoDto dto) {

        return medicoRepository.save(new Medico(dto));
    }

    public Page<ListagemMedicoDto> listar(Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(ListagemMedicoDto::new);
    }

    @Transactional
    public DetalhesMedicoDto atualizar(Long id, AtualizarMedicoDto dto) {
        var medico = this.obterMedico(id);
        medico.atualizar(dto);
        return new DetalhesMedicoDto(medico);

    }


    @Transactional
    public void excluir(Long id) {
        medicoRepository.deleteById(id);
    }

    @Transactional
    public void desativar(Long id) {
        var medico = this.obterMedico(id);
        medico.desativar();
    }

    public DetalhesMedicoDto detalhar(Long id) {
        return new DetalhesMedicoDto(this.obterMedico(id));
    }

    private Medico obterMedico(Long idMedico) {
        return medicoRepository.getReferenceById(idMedico);
    }

}
