package edu.pe.cibertec.veterinaria.controller;


import edu.pe.cibertec.veterinaria.model.Cliente;
import edu.pe.cibertec.veterinaria.model.Mascota;
import edu.pe.cibertec.veterinaria.service.ClienteService;
import edu.pe.cibertec.veterinaria.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;

    @GetMapping
    public String listarClientes(Model model) {
        List<Mascota> mascotas = mascotaService.listar();
        model.addAttribute("mascotas", mascotas);
        return "mascotas/mascota-list";
    }

    @GetMapping("/nuevo")
    public String nuevoCliente(Model model){
        model.addAttribute("mascotas", new Mascota());
        return "mascotas/mascotas-form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model){
        Mascota mascota = mascotaService.obtener(id);
        if(mascota == null )
            return "redirect:/mascota";
        model.addAttribute("mascota", mascota);
        return "mascota/mascota-form";
    }

    @PostMapping("/guardar")
    public String guardar(Mascota mascota){
        mascotaService.guardar(mascota);
        return "redirect:/mascota";
    }

    @GetMapping("/{id}")
    public String ver(@PathVariable("id") int id, Model model){
        Mascota mascota = mascotaService.obtener(id);
        if(mascota == null )
            return "redirect:/mascota";
        model.addAttribute("mascota", mascota);
        return "mascota/mascota-detail";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") int id) {
        mascotaService.eliminar(id);
        return "redirect:/clientes";
    }

}
