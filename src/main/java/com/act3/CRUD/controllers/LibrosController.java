/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.act3.CRUD.controllers;

import com.act3.CRUD.Models.Autores;
import com.act3.CRUD.Models.Libros;
import com.act3.CRUD.services.LibrosService;
import com.act3.CRUD.services.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/libros") // Agrupa todas las rutas bajo /libros
public class LibrosController {

    @Autowired
    private LibrosService librosService;

    @Autowired
    private AutoresService autoresService; // Necesario para desplegar los autores en el formulario

    // LISTAR
    @GetMapping({"", "/"})
    public String listar(Model model) {
        model.addAttribute("libros", librosService.obtenerTodos());
        return "libros/index"; // Asumiendo que tendrás una carpeta 'libros' en tus templates
    }

    // FORM NUEVO
    @GetMapping("/nuevo")
    public String nuevo(@RequestParam(value = "autorId", required = false) Long autorId, Model model) {
        Libros libro = new Libros();
        if (autorId != null) {
            libro.setAutor(autoresService.obtenerPorId(autorId));
        }
        model.addAttribute("libro", libro);
        // Pasamos la lista de autores al HTML para llenar un <select>
        model.addAttribute("autores", autoresService.obtenerTodos());
        return "libros/form";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Libros libro, @RequestParam("autorId") Long autorId) {
        Autores autor = autoresService.obtenerPorId(autorId);
        if (autor == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El autor seleccionado no existe");
        }
        libro.setAutor(autor);
        if (libro.getIsbn() != null && libro.getIsbn().isBlank()) {
            libro.setIsbn(null);
        }
        librosService.guardarLibro(libro);
        return "redirect:/libros";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Libros libro = librosService.obtenerPorId(id);
        model.addAttribute("libro", libro);
        // Volvemos a pasar la lista de autores para el <select>
        model.addAttribute("autores", autoresService.obtenerTodos());
        return "libros/form";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        librosService.eliminarPorId(id);
        return "redirect:/libros";
    }
}
