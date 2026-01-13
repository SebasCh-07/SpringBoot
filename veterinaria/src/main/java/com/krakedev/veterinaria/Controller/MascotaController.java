package com.krakedev.veterinaria.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinaria.entity.Mascota;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("/api/mascotas")
@RestController
public class MascotaController {
    private List<Mascota> mascotas = new ArrayList<>();
    public MascotaController() {
        /*mascotas.add(new Mascota(1, "Firulais", "Perro", 3, "Juan Perez", null));
        mascotas.add(new Mascota(2, "Michi", "Gato", 2, "Ana Gomez", null));
        mascotas.add(new Mascota(3, "Nemo", "Pez", 1, "Carlos Lopez", null));
        mascotas.add(new Mascota(4, "Bobby", "Perro", 4, "Laura Martinez", null));
        mascotas.add(new Mascota(5, "Luna", "Gato", 5, "Sofia Rodriguez", null));*/

    }

    @GetMapping
    public List<Mascota> listarMascotas() {
        return mascotas;
    }

    @GetMapping("/{id}")
    public Mascota obtenerMascotaPorId(@PathVariable int id) {
        return mascotas.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @PostMapping
    public Mascota crearMascota(@RequestBody Mascota mascota) {
        mascotas.add(mascota);
        return mascota;
    }

    @DeleteMapping("/{id}")
    public void eliminarMascota(@PathVariable int id) {
        mascotas.removeIf(m -> m.getId() == id);
    }
}
