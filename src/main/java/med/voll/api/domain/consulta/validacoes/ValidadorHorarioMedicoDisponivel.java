package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.validations.ValidacaoAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorHorarioMedicoDisponivel implements ValidacaoAgendamento {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(AgendamentoConsultaDto dto) {
        var medicoPossuiConsultaNoHorario = consultaRepository.existsByMedicoIdAndData(dto.idMedico(),dto.data());

        if (medicoPossuiConsultaNoHorario) {
            throw new ValidationException("Medico já possui outra consulta agendada neste horario!");
        }

    }

}
