package kafka.system.com.api.domain.consulta.validacoes;

import kafka.system.com.api.domain.ValidacaoException;
import kafka.system.com.api.domain.consulta.DadosAgendamentoConsulta;
import kafka.system.com.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{


    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        //Escolha do medico opcionaç
        if(dados.idMedico() == null){
            return;
        }

        var medicoAtivo = repository.findAtivoById(dados.idMedico());

        if(!medicoAtivo){
            throw new ValidacaoException("Médico não pode realizar a consulta, ele está inativo");
        }
    }
}
