    package com.giliane.streamingclientmanager.service;

    import com.giliane.streamingclientmanager.model.Cliente;
    import com.giliane.streamingclientmanager.repository.ClienteRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class ClienteService {

        private final ClienteRepository clienteRepository;

        public ClienteService(ClienteRepository  ClienteRepository){
            this.clienteRepository = ClienteRepository;
        }

        public Cliente salvarCliente(Cliente cliente){
            return clienteRepository.save(cliente);
        }

        public List<Cliente> listarClientes(){
            return clienteRepository.findAll();
        }

    }