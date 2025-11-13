package med.voll.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AutenticacaoDto(
        @NotBlank
        @NotNull
        String login,
        @NotBlank
        @NotNull
        String senha
) {
}
