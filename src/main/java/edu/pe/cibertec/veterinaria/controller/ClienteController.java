package edu.pe.cibertec.veterinaria.controller;

import edu.pe.cibertec.veterinaria.model.Cliente;
import edu.pe.cibertec.veterinaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/nuevo")
    public String nuevoCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        return "clientes/cliente-form";
    }
    @PostMapping("/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.guardar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "index";
    }

    @GetMapping("/{id}")
    public String verCliente(@PathVariable("id") int id, Model model){
        Cliente cliente = clienteService.obtener(id);
        if(cliente == null )
            return "redirect:/clientes";
        model.addAttribute("cliente", cliente);
        return   "clientes/cliente-detail";
    }
}

