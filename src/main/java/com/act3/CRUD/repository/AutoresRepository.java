/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.act3.CRUD.repository;

import com.act3.CRUD.Models.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gansi
 */
@Repository
public interface AutoresRepository extends JpaRepository<Autores, Long> {
  
    
}
