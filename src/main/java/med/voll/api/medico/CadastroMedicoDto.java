package med.voll.api.medico;

import med.voll.api.endereco.EnderecoDto;

public record CadastroMedicoDto(String nome, String email, String crm, Especialidade especialidade, EnderecoDto endereco) {
}
