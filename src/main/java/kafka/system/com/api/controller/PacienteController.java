package kafka.system.com.api.controller;

import kafka.system.com.api.paciente.DadosCadastroPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("paciente")
public class PacienteController {

    @PostMapping
    public void cadastrar(DadosCadastroPaciente dados){
    }
}
