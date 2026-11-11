/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.act3.CRUD.services;

import com.act3.CRUD.Models.Autores;
import com.act3.CRUD.Models.Libros;
import com.act3.CRUD.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibrosService {

    @Autowired
    private LibroRepository repo;

    public List<Libros> obtenerTodos() {
        return repo.findAll();
    }

    public void guardarLibro(Libros libro) {
        repo.save(libro);
    }

    public Libros obtenerPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminarPorId(Long id) {
        repo.deleteById(id);
    }
    
    public List<Libros> obtenerLibrosPorAutor(Autores autor) {
        return repo.findByAutor(autor);
    }
}
