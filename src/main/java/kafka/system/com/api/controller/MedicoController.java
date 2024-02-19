package kafka.system.com.api.controller;

import jakarta.validation.Valid;
import kafka.system.com.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());

        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        //Delete do banco repository.deleteById(id);

        var medico = repository.getReferenceById(id);
        medico.desativarMedico();
    }
}
