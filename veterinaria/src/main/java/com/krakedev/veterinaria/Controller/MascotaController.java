package com.krakedev.veterinaria.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinaria.Service.MascotaService;
import com.krakedev.veterinaria.entity.EstadoMascota;
import com.krakedev.veterinaria.entity.Mascota;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


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

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarMascota (@PathVariable long id, @RequestBody Mascota mascota) {
        try {
            Mascota mascotaActualizada = new Mascota();
            mascotaActualizada.setNombre(mascota.getNombre());
            mascotaActualizada.setEspecie(mascota.getEspecie());;
            mascotaActualizada.setEdad(mascota.getEdad());
            mascotaActualizada.setFechaRegistro(mascota.getFechaRegistro());
            mascotaActualizada.setNombreDueno(mascota.getNombreDueno());
            mascotaActualizada.setEstado(mascota.getEstado());
            
            Mascota mascotaBDD = mascotaService.actualizarMascota(id, mascotaActualizada);
            return ResponseEntity.ok(mascotaBDD);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarMascota (@PathVariable long id) {
        try {
            mascotaService.eliminarMascota(id);
            return ResponseEntity.ok("Mascota eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Mascota>> ListarPorEstado (@PathVariable EstadoMascota estado) {
        List<Mascota> mascotas = mascotaService.obtenerPorEstado(estado);
        return ResponseEntity.ok(mascotas);
    }

    @PutMapping("/estado/{id}")
    public ResponseEntity<?> cambiarEstadoMascota (@PathVariable long id, @RequestBody EstadoMascota nuevoEstado) {
        try {
            Mascota mascota = mascotaService.cambiarEstado(id, nuevoEstado);
            return ResponseEntity.ok(mascota);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    

}
