package med.voll.api.medico;

import jakarta.validation.Valid;
import med.voll.api.endereco.EnderecoDto;

public record AtualizarMedicoDto(
        String nome,
        String email,
        String telefone,
        EnderecoDto endereco
) {
}
