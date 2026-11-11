/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.act3.CRUD.repository;

import com.act3.CRUD.Models.Autores;
import com.act3.CRUD.Models.Libros;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gansi
 */
@Repository
public interface LibroRepository extends JpaRepository<Libros, Long>  {
    
    List<Libros> findByAutor(Autores  autor);
}
