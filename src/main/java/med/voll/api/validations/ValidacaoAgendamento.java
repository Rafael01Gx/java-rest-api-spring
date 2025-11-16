package med.voll.api.validations;

import med.voll.api.domain.consulta.AgendamentoConsultaDto;

public interface ValidacaoAgendamento {
    void validar(AgendamentoConsultaDto dto);
}
