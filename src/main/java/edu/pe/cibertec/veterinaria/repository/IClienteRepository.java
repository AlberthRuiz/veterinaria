package edu.pe.cibertec.veterinaria.repository;

import edu.pe.cibertec.veterinaria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente,Integer> {

}
