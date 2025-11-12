package med.voll.api.services;

import med.voll.api.domain.paciente.CadastroPacienteDto;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente cadastrar(CadastroPacienteDto dto) {
        return pacienteRepository.save(new Paciente(dto));
    }
}
