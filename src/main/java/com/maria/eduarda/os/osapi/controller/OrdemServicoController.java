package com.maria.eduarda.os.osapi.controller;

import com.maria.eduarda.os.osapi.domain.model.OrdemServico;
import com.maria.eduarda.os.osapi.domain.repository.OrdemServicoRepository;
import com.maria.eduarda.os.osapi.domain.service.GestaoOrdemServicoService;
import com.maria.eduarda.os.osapi.model.OrdemServicoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServicoService;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@Valid @RequestBody OrdemServico ordemServico){
        return gestaoOrdemServicoService.criar(ordemServico);
    }

    @GetMapping
    public List<OrdemServico> listar(){
        return ordemServicoRepository.findAll();
    }

    @GetMapping("/{ordemServicoId}")
    public ResponseEntity<OrdemServicoModel> buscar(@PathVariable Long ordemServicoId){
        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);

        if(ordemServico.isPresent()){
            OrdemServicoModel ordemServicoModel = modelMapper.map(ordemServico.get(), OrdemServicoModel.class);
            return ResponseEntity.ok(ordemServicoModel);
        }
        return ResponseEntity.notFound().build();
    }
}
