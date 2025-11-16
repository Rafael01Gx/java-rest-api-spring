package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.validations.ValidacaoAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteAtivo implements ValidacaoAgendamento {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(AgendamentoConsultaDto dto) {
        if(!(pacienteRepository.existsByIdAndAtivoTrue(dto.idPaciente()))){
            throw new ValidationException("Paciente indisponível!");
        }
    }

}
