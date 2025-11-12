package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.EnderecoDto;

public record AtualizarMedicoDto(
        String nome,
        String email,
        String telefone,
        EnderecoDto endereco
) {
}
