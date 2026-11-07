package com.giliane.streamingclientmanager.controller;
import org.springframework.web.bind.annotation.RestController;
import com.giliane.streamingclientmanager.model.Cliente;
import com.giliane.streamingclientmanager.service.ClienteService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente){
        return clienteService.salvarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }

}