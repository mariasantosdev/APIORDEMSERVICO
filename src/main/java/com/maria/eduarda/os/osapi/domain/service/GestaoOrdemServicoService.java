package com.maria.eduarda.os.osapi.domain.service;

import com.maria.eduarda.os.osapi.domain.exception.NegocioException;
import com.maria.eduarda.os.osapi.domain.model.Cliente;
import com.maria.eduarda.os.osapi.domain.model.OrdemServico;
import com.maria.eduarda.os.osapi.domain.model.StatusOrdemServico;
import com.maria.eduarda.os.osapi.domain.repository.ClienteRepository;
import com.maria.eduarda.os.osapi.domain.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public OrdemServico criar(OrdemServico ordemServico){
        Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));

        ordemServico.setCliente(cliente);
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(OffsetDateTime.now());

        return ordemServicoRepository.save(ordemServico);
    }
}
