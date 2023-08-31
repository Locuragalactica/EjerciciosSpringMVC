package com.biblioteca.Biblioteca.controladores;

import com.biblioteca.Biblioteca.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private LibroServicio libroservicio;

    @GetMapping("/")
    public String index() {

        return "index.html";
    }
}
