/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.act3.CRUD.controllers;

import com.act3.CRUD.Models.Libros;
import com.act3.CRUD.Models.Autores;
import com.act3.CRUD.services.AutoresService;
import com.act3.CRUD.services.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class AutoresController {

    @Autowired
    private AutoresService service; // Inyectamos el Service, ya no el Repository

    @Autowired
    private LibrosService librosService;
    // LISTAR
    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("autores", service.obtenerTodos());
        return "index";
    }

    // FORM NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("autor", new Autores());
        return "form";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Autores autor) {
        service.guardarAutor(autor);
        return "redirect:/"; // Redirige a la ruta principal ("/") tras guardar
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Autores autor = service.obtenerPorId(id);
        model.addAttribute("autor", autor);
        return "form";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminarPorId(id);
        return "redirect:/"; // Redirige a la ruta principal ("/") tras eliminar
    }
    @GetMapping("/ver-libros/{id}")
    public String verLibrosDeAutor(@PathVariable Long id, Model model){
        Autores autor= service.obtenerPorId(id);
        
        if(autor !=null){
            List<Libros> librosDelAutor=librosService.obtenerLibrosPorAutor(autor);
            model.addAttribute("autor", autor);
            model.addAttribute("libros", librosDelAutor);
            return "libros_autor";
        }
        return "redirect:/";
    }
}


