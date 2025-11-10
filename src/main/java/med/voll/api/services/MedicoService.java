package med.voll.api.services;

import med.voll.api.medico.CadastroMedicoDto;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico cadastrar(CadastroMedicoDto dto) {
        return medicoRepository.save(new Medico(dto));
    }
}
