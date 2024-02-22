package kafka.system.com.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import kafka.system.com.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
