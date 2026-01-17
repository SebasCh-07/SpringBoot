package com.krakedev.Hospital.Service.serviceImpl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.krakedev.Hospital.Entity.DoctorEntity;
import com.krakedev.Hospital.Repository.DoctorRepository;
import com.krakedev.Hospital.Service.DoctorService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository DoctorRepository;
    
    @Override
    public DoctorEntity registrarDoctor(DoctorEntity doctor) {
       return DoctorRepository.save(doctor);
    }

    @Override
    public List<DoctorEntity> listarDoctores() {
        return DoctorRepository.findAll();
    }

    @Override
    @SneakyThrows
    public DoctorEntity actualizarDoctorInfo(Long idDoctor, DoctorEntity doctorActualizado) {
        DoctorEntity doctorExistente = DoctorRepository.findByIdDoctor(idDoctor)
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado con id: " + idDoctor));

        doctorExistente.setNameDoctor(doctorActualizado.getNameDoctor());
        return DoctorRepository.save(doctorExistente);
    }

    @Override
    @SneakyThrows
    public void eliminarDoctor(Long id) {
       DoctorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Doctor no encontrado con id: " + id));
         DoctorRepository.deleteById(id);
    }

}
