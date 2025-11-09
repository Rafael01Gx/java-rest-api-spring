package med.voll.api.medico;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Especialidade {
    ORTOPEDIA("Ortopedia"),
    CARDIOLOGIA("Cardiologia"),
    GINECOLOGIA("Ginecologia"),
    DERMATOLOGIA("Dermatologia");

    private String especialidades;

    Especialidade(String especialidades) {
        this.especialidades = especialidades;
    }

    @JsonCreator
    public static Especialidade fromString(String especialidade) {
        for (Especialidade e : Especialidade.values()) {
            if (e.especialidades.equalsIgnoreCase(especialidade)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Nenhum especialidade foi encontrada.");
    }

    @JsonValue
    public String getEspecialidades() {
        return especialidades;
    }
}
