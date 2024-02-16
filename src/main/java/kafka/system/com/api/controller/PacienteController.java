package kafka.system.com.api.controller;

import jakarta.validation.Valid;
import kafka.system.com.api.paciente.DadosCadastroPaciente;
import kafka.system.com.api.paciente.DadosListagemPaciente;
import kafka.system.com.api.paciente.Paciente;
import kafka.system.com.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosCadastroPaciente){
        repository.save(new Paciente(dadosCadastroPaciente));
    }

    @GetMapping
    public List<DadosListagemPaciente> listar(){
        return repository.findAll().stream().map(DadosListagemPaciente::new).toList();
    }
}
