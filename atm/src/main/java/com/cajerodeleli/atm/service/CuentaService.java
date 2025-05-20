package com.cajerodeleli.atm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.stereotype.Service;

import com.cajerodeleli.atm.entity.Cliente;
import com.cajerodeleli.atm.entity.Cuenta;
import com.cajerodeleli.atm.entity.TipoCuenta;
import com.cajerodeleli.atm.repository.CuentaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaService {
    private final CuentaRepository cuentaRepository;

    public Cuenta crearCuenta(Cliente cliente, String numer, TipoCuenta tipo, double saldoInicial){
        Cuenta cuenta= Cuenta.builder()
        .cliente(null)
        .numero(numer)
        .tipo(null)
        .saldo(saldoInicial)
        .saldo(saldoInicial)
        .build();
        return cuentaRepository.save(cuenta);  
        
    }

    public Optional <Cuenta>buscarPorNumero(String numero){
        return cuentaRepository.findByNumero(numero);
    }

    public double consultarSaldo(Cuenta cuenta){
        return cuenta.getSaldo();
    }

    public List<Cuenta> obtenerCuentasCliente(Cliente cliente){
        return cliente.getCuentas();
    }

}
