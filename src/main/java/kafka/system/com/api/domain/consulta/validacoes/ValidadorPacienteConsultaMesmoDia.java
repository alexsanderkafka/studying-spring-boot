package kafka.system.com.api.domain.consulta.validacoes;

import kafka.system.com.api.domain.ValidacaoException;
import kafka.system.com.api.domain.consulta.ConsultaRepository;
import kafka.system.com.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteConsultaMesmoDia implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);

        var pacienteTemConsultaNoMesmoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if(pacienteTemConsultaNoMesmoDia){
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }



}
