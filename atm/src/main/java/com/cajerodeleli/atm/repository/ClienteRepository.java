package com.cajerodeleli.atm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cajerodeleli.atm.entity.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByIdentificacion(String identificacion);


}
