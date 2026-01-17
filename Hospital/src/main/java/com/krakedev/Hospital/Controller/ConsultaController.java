package com.krakedev.Hospital.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.Hospital.Entity.ConsultaEntity;
import com.krakedev.Hospital.Service.ConsutaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor
public class ConsultaController {
    private final ConsutaService consultaService;
    
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarConsulta(@RequestBody ConsultaEntity consulta) {
        ConsultaEntity nuvaConsulta = consultaService.registrarConsulta(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuvaConsulta);
    }
    
    @GetMapping()
    public ResponseEntity<List<ConsultaEntity>> listarConsultas() {
        List<ConsultaEntity> consultas = consultaService.listarConsultas();
        return ResponseEntity.ok(consultas);
    }

}
