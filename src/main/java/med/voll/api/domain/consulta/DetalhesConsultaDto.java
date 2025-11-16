package med.voll.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDateTime;

public record DetalhesConsultaDto(
        Long id,
        @JsonAlias("medico_id") Long idMedico,
        @JsonAlias("paciente_id") Long idPaciente,
        LocalDateTime data
) {

    public DetalhesConsultaDto(Consulta consulta){
        this(consulta.getId(), consulta.getMedico().getId(),consulta.getPaciente().getId(),consulta.getData());
    }
}
