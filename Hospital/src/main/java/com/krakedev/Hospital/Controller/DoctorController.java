package com.krakedev.Hospital.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.Hospital.Entity.DoctorEntity;
import com.krakedev.Hospital.Service.DoctorService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarDoctor(@RequestBody DoctorEntity doctor) {
        DoctorEntity nuevoDoctor = doctorService.registrarDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDoctor);
    }
    
    @GetMapping()
    public ResponseEntity<List<DoctorEntity>> listarDoctores() {
        List<DoctorEntity> doctores = doctorService.listarDoctores();
        return ResponseEntity.ok(doctores);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarDoctor(@PathVariable Long id, @RequestBody DoctorEntity doctor) {
        try {
            DoctorEntity doctorActualizado = new DoctorEntity();
            doctorActualizado.setNameDoctor(doctor.getNameDoctor());
            
            DoctorEntity doctorBDD = doctorService.actualizarDoctorInfo(id, doctorActualizado);
            return ResponseEntity.ok(doctorBDD);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarDoctor(@PathVariable Long id) {
        try {
            doctorService.eliminarDoctor(id);
            return ResponseEntity.ok("Doctor Eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
