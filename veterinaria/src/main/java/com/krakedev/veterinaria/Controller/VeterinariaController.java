package com.krakedev.veterinaria.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/veterinaria")
public class VeterinariaController {
    @GetMapping("/bienvenida")
    public String bienvenida() {
        return "¡Bienvenido al Sistema de Gestión Veterinaria!";
    }
    
}
