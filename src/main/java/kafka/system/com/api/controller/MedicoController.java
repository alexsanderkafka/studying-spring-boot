package kafka.system.com.api.controller;

import kafka.system.com.api.endereco.Endereco;
import kafka.system.com.api.medico.DadosCadastroMedico;
import kafka.system.com.api.medico.Medico;
import kafka.system.com.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping // "Mostra" para o método que quando receber um post no /medicos é para chamar esse método
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }
}
