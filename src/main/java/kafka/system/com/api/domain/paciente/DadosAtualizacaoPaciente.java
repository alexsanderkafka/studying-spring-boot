package kafka.system.com.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import kafka.system.com.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
