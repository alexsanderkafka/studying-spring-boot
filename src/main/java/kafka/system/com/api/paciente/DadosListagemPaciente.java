package kafka.system.com.api.paciente;

import kafka.system.com.api.medico.DadosListagemMedico;

public record DadosListagemPaciente(String nome, String email, String cpf) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
