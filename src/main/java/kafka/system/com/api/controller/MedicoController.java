package kafka.system.com.api.controller;

import jakarta.validation.Valid;
import kafka.system.com.api.medico.DadosCadastroMedico;
import kafka.system.com.api.medico.DadosListagemMedico;
import kafka.system.com.api.medico.Medico;
import kafka.system.com.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping // "Mostra" para o método que quando receber um post no /medicos é para chamar esse método
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        Medico medico = new Medico(dados);
        //System.out.println("teste: " + dados.endereco());
        repository.save(medico);
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable pageable){
        return repository.findAll(pageable).map(DadosListagemMedico::new);
    }
}
