/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.act3.CRUD.Models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long idLibro;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(unique = true, length = 20)
    private String isbn;

    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;

    // Relación principal: Muchos libros pertenecen a un Autor
    // 'name' debe coincidir exactamente con el nombre de tu columna FK en MySQL
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable = false)
    private Autores autor;

    // Getters, Setters y Constructores

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }
}

