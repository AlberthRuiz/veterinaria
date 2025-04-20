package edu.pe.cibertec.veterinaria.controller;

import edu.pe.cibertec.veterinaria.model.Cliente;
import edu.pe.cibertec.veterinaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.listar();
        model.addAttribute("clientes", clientes);
        return "clientes/clientes-list";
    }



    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "index";
    }
}

