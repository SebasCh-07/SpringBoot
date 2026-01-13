package com.krakedev.inventario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*Controlador Rest: es una clase en java que expone rutas http que expone rutas para que otros sistemas 
puedan enviarle peticones y recibir respuestas en JSON*/

//@RestController // Indica que esta clase es un controlador REST
//@RequestMapping("/micontroller") // Ruta base para todas las peticiones en este controlador
public class SaludoCOntroller {

    @GetMapping("/saludo") // Ruta para el método de saludo
    public String saludar() {
        return "¡Hola desde el controlador de saludo!";
    }
}
