package med.voll.api.domain.consulta;

import jakarta.validation.ValidationException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.validations.ValidacaoAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private List<ValidacaoAgendamento> validadores;

    public DetalhesConsultaDto agendar(AgendamentoConsultaDto dto) {
        validadores.forEach(v -> v.validar(dto));
        var medico = this.getMedico(dto);
        var paciente = this.getPacienteById(dto.idPaciente());
        var consult = new Consulta(null, medico, paciente, dto.data());
        Consulta consulta = consultaRepository.save(consult);
        return new DetalhesConsultaDto(consulta);
    }

    private Medico getMedico(AgendamentoConsultaDto dto) {
        if (dto.idMedico() != null) {
            return this.medicoRepository.findById(dto.idMedico()).orElseThrow(ValidationException::new);
        } else if (dto.especialidade() != null) {
            return this.medicoRepository.escolherMedicoAleatorioLivreNaData(dto.especialidade(), dto.data()).orElseThrow(ValidationException::new);
        }

        throw new ValidationException("Especialidade é obrigatória se nenhum médico for escolhido!");
    }

    private Paciente getPacienteById(Long id) {
        var paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente == null) {
            throw new ValidationException("Paciente informado não existe!");
        }
        return paciente;
    }
}
