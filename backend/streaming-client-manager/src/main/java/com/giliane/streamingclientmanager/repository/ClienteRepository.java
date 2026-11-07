package com.giliane.streamingclientmanager.repository;

import com.giliane.streamingclientmanager.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}