package edu.pe.cibertec.veterinaria.service;

import edu.pe.cibertec.veterinaria.model.Cliente;
import edu.pe.cibertec.veterinaria.model.Mascota;
import edu.pe.cibertec.veterinaria.repository.IMascotaRepository;
import edu.pe.cibertec.veterinaria.service.Impl.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MascotaService {
    @Autowired
    private IMascotaRepository mascotaService;

    public List<Mascota> listar(){
        return mascotaService.findAll();
    }

    public Mascota  obtener(int id){
        return mascotaService.findById(id).orElse(null);
    }

    public Mascota  guardar(Mascota mascota){
        return mascotaService.save(mascota);
    }

    public void  eliminar(int id){
        mascotaService.deleteById(id);
    }

}
