package com.krakedev.inventario.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.inventario.entity.Message;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




//@RestController
//@RequestMapping("/api/messages")
public class MessageController {
    
    private List<Message> mensajes = new ArrayList<>();

    public MessageController() {
        mensajes.add(new Message(1, "KrakeDev Escuela de Programacion"));
        mensajes.add(new Message(2, "Spring Boot desde 0"));
    }

    @GetMapping
    public List<Message> ListarMensajes() {
        return mensajes;
    }

    // /mensajes/id
    @GetMapping("/{id}")
    public Message ObtenerMensajePorId(@PathVariable int id) {
        Optional<Message> mensaje = mensajes.stream()
                .filter(m -> m.getId() == id)
                .findFirst();

        return mensaje.orElse(null);
    }

    @PostMapping
    public Message crearMessage(@RequestBody Message message) {
        mensajes.add(message);
        return message;
    }

    @DeleteMapping("/{id}")
    public void eliminarMensaje(@PathVariable int id) {
        mensajes.removeIf(m -> m.getId() == id);
    }
}
