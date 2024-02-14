package kafka.system.com.api.controller;

import kafka.system.com.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @PostMapping // "Mostra" para o método que quando receber um post no /medicos é para chamar esse método
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        System.out.println(dados);
    }
}
