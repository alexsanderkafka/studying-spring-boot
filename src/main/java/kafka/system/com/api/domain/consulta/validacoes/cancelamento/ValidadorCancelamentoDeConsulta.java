package kafka.system.com.api.domain.consulta.validacoes.cancelamento;

import kafka.system.com.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
    void validadorCancelamento(DadosCancelamentoConsulta dados);
}
