package kafka.system.com.api.domain.consulta.validacoes;

import kafka.system.com.api.domain.ValidacaoException;
import kafka.system.com.api.domain.consulta.DadosAgendamentoConsulta;
import kafka.system.com.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{


    @Autowired
    private PacienteRepository repository;
    public void validar(DadosAgendamentoConsulta dados){
        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());

        if(!pacienteAtivo){
            throw new ValidacaoException("Paciente não pode marcar a consulta, ele está inativo");
        }
    }
}
