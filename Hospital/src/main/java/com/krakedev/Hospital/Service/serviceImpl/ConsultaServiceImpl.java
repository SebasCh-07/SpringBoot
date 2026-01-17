package com.krakedev.Hospital.Service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.Hospital.Entity.ConsultaEntity;
import com.krakedev.Hospital.Entity.DoctorEntity;
import com.krakedev.Hospital.Repository.ConsultaRepository;
import com.krakedev.Hospital.Repository.DoctorRepository;
import com.krakedev.Hospital.Service.ConsutaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsutaService {
    
    private final ConsultaRepository consultaRepository;
    private final DoctorRepository doctorRepository; 
    
    @Override
    public ConsultaEntity registrarConsulta(ConsultaEntity consulta) {
        Long idDoctor = consulta.getDoctor().getIdDoctor();
        
        DoctorEntity doctorEncontrado = doctorRepository.findByIdDoctor(idDoctor)
            .orElseThrow(() -> new RuntimeException("Doctor no encontrado con ID: " + idDoctor));
        consulta.setDoctor(doctorEncontrado);
        return consultaRepository.save(consulta);
    }

    @Override
    public List<ConsultaEntity> listarConsultas() {
        return consultaRepository.findAll();
    }

}
