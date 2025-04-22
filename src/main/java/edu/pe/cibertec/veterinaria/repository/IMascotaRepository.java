package edu.pe.cibertec.veterinaria.repository;


import edu.pe.cibertec.veterinaria.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMascotaRepository extends JpaRepository<Mascota,Integer> {
}
