package com.krakedev.veterinaria.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinaria.Service.MascotaService;
import com.krakedev.veterinaria.entity.Mascota;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api/mascotas")
@RestController
@RequiredArgsConstructor
public class MascotaController {

    private final MascotaService mascotaService;

    @GetMapping
    public ResponseEntity<List<Mascota>> ListarMascotas() {
        List<Mascota> mascotas = mascotaService.listarMascotas();
        return ResponseEntity.ok(mascotas);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarMascota(@RequestBody Mascota mascota) {
        Mascota nuevaMascota = mascotaService.registrarMascota(mascota);
        return ResponseEntity.status(201).body(nuevaMascota);
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre) {
       Optional<Mascota> mascota = mascotaService.BuscarPorNombre(nombre);
       return mascota.isPresent() ? ResponseEntity.ok(mascota.get()) 
               : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada");
    }

    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
       Optional<Mascota> mascota = mascotaService.BuscarPorId(id);
       return mascota.isPresent() ? ResponseEntity.ok(mascota.get()) 
               : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada");
    }

}
