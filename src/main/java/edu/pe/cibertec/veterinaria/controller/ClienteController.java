package edu.pe.cibertec.veterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @GetMapping()
    public String listadoClientes(){
        return "clientes-list";
    }



    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "index";
    }
}

