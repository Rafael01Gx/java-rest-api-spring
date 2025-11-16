package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.validations.ValidacaoAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemConsultaNoDIa implements ValidacaoAgendamento {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(AgendamentoConsultaDto dto) {
        var primeiroHorario = dto.data().withHour(7);
        var ultimoHorario = dto.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween(dto.idPaciente(),primeiroHorario,ultimoHorario);
        if(pacientePossuiOutraConsultaNoDia){
            throw new ValidationException("Paciente possui outra consulta neste dia!");
        }
    }
}
