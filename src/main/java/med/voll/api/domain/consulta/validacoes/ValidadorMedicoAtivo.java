package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.AgendamentoConsultaDto;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.validations.ValidacaoAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidacaoAgendamento {

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(AgendamentoConsultaDto dto) {
        if(dto.idMedico() == null){
            return;
        }
       if(!(medicoRepository.existsByIdAndAtivoTrue(dto.idMedico()))){
           throw new ValidationException("Médico não existe ou está inativo no sistema!");
       }
    }
}
