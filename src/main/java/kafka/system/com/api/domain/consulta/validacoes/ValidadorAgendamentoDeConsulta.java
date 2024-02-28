package kafka.system.com.api.domain.consulta.validacoes;

import kafka.system.com.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosAgendamentoConsulta dados);
}
