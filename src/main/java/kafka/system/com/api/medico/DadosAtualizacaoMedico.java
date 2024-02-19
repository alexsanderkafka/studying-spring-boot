package kafka.system.com.api.medico;

import jakarta.validation.constraints.NotNull;
import kafka.system.com.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
