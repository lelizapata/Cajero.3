package com.cajerodeleli.atm.controller;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cajerodeleli.atm.entity.Cliente;
import com.cajerodeleli.atm.entity.Cuenta;
import com.cajerodeleli.atm.entity.TipoCuenta;
import com.cajerodeleli.atm.service.ClienteService;
import com.cajerodeleli.atm.service.CuentaService;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ClienteService clienteService;
    private final CuentaService cuentaService;

    @GetMapping
    public String adminHome(){
        return "admin/index";
    }

    @GetMapping("/crear-cliente")
    public String mostrarFormularioCliente(Mode model) {
        model.addAttribute("cliente", new Cliente());
        return "admin/crear-cliente";
    }

    @PostMapping("/crear-cliente")
    public String crearCliente(@ModelAttribute Cliente cliente) {
        clienteService.crearCliente(cliente);      
        return "redirect:/admin";
    }

    @GetMapping("/crear-cuenta")
    public String mostrarFormularioCuenta(Model model) {
        model.addAttribute("cuenta", new Cuenta());     
        return "admin/crear-cuenta";
    }

    @PostMapping("/crear-cuenta")
    public String crearCuenta(@RequestParam String identificacion,
                            @RequestParam String numero,
                            @RequestParam TipoCuenta tipo,
                            @RequestParam double saldo) {
        Cliente cliente = clienteService.buscarPorIdentificacion
        (identificacion).orElseThrow();
        cuentaService.crearCuenta(cliente, numero, tipo, saldo);       
        
        return "redirect:/admin";
    }

    @GetMapping("/desbloquear")
    public String mostrarDesbloqueo() {
        return "admin/desbloquear";
    }

    @PostMapping("/desbloquear")
    public String desbloquearCuenta(@RequestParam String identificacion,
    @RequestParam String nuevoPin) {
        clienteService.desbloquearCliente(identificacion, nuevoPin);
        return "redirect:/admin";
    }
    
    


    
    
    

}

