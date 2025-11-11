package med.voll.api.services;

import med.voll.api.medico.CadastroMedicoDto;
import med.voll.api.medico.ListagemMedicoDto;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico cadastrar(CadastroMedicoDto dto) {

        return medicoRepository.save(new Medico(dto));
    }

    public Page<ListagemMedicoDto> listar(Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(ListagemMedicoDto::new);
    }
}
