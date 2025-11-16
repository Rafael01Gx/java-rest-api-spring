package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import med.voll.api.validations.ValidacaoAgendamento;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioDeFuncionamento implements ValidacaoAgendamento {

    public void validar(AgendamentoConsultaDto dto){
        var dataConsulta = dto.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var aberto = dataConsulta.getHour() < 7 ;
        var fechado = dataConsulta.getHour() >= 18;

        if(domingo || aberto || fechado){
            throw new ValidationException("Consulta fora do horário de funcionamento da clínica");
        }

    }
}
