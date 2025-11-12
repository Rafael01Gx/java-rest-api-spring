package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDto endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();

    }


    public void atualizar(EnderecoDto endereco) {
        Optional.ofNullable(endereco.logradouro()).ifPresent(logradouro-> { this.logradouro = logradouro;});
        Optional.ofNullable(endereco.bairro()).ifPresent(bairro-> { this.bairro = bairro;});
        Optional.ofNullable(endereco.cep()).ifPresent(cep-> { this.cep = cep;});
        Optional.ofNullable(endereco.numero()).ifPresent(numero-> { this.numero = numero;});
        Optional.ofNullable(endereco.complemento()).ifPresent(complemento-> { this.complemento = complemento;});
        Optional.ofNullable(endereco.cidade()).ifPresent(cidade-> { this.cidade = cidade;});
        Optional.ofNullable(endereco.uf()).ifPresent(uf-> { this.uf = uf;});
    }
}
