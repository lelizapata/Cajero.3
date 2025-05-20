package com.cajerodeleli.atm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cajerodeleli.atm.entity.Cliente;
import com.cajerodeleli.atm.entity.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta , Long> {
    Optional<Cuenta> findByNumero(String numero);
    List<Cuenta> findByCliente(Cliente cliente);

}
