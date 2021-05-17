package com.maria.eduarda.os.osapi.domain.service;

import com.maria.eduarda.os.osapi.domain.exception.NegocioException;
import com.maria.eduarda.os.osapi.domain.model.Cliente;
import com.maria.eduarda.os.osapi.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class CadastroClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());

        if(clienteExistente != null && !clienteExistente.equals(cliente)){
            throw new NegocioException("Já existe um cliente cadastrado com esse email");
        }
        return clienteRepository.save(cliente);
    }

    public  void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}
