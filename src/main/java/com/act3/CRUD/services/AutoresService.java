/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.act3.CRUD.services;

import com.act3.CRUD.Models.Autores;
import com.act3.CRUD.repository.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutoresService {

    @Autowired
    private AutoresRepository repo;

    // Método para listar
    public List<Autores> obtenerTodos() {
        return repo.findAll();
    }

    // Método para guardar
    public void guardarAutor(Autores autor) {
        repo.save(autor);
    }

    // Método para buscar por ID (necesario para editar)
    public Autores obtenerPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Método para eliminar
    public void eliminarPorId(Long id) {
        repo.deleteById(id);
    }
}