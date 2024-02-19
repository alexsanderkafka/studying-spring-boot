package kafka.system.com.api.paciente;

import jakarta.validation.constraints.NotNull;
import kafka.system.com.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
