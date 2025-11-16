package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import med.voll.api.validations.ValidacaoAgendamento;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioDeAntecedencia implements ValidacaoAgendamento {

    public void validar(AgendamentoConsultaDto dto) {
        var dataConsulta = dto.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidationException("Consulta deve ser agendada com antecedência mínima de 30 minutos!");
        }

    }
}
