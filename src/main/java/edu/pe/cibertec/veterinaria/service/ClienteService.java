package edu.pe.cibertec.veterinaria.service;

import edu.pe.cibertec.veterinaria.model.Cliente;
import edu.pe.cibertec.veterinaria.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService  {
    @Autowired
    private IClienteRepository clienteRepository;

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public Cliente  obtener(int id){
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente  guardar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void  eliminar(int id){
        clienteRepository.deleteById(id);
    }




}
