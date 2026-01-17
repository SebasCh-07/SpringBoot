package com.krakedev.Hospital.Service;

import java.util.List;

import com.krakedev.Hospital.Entity.DoctorEntity;

public interface DoctorService {
    DoctorEntity registrarDoctor(DoctorEntity doctor);
    List<DoctorEntity> listarDoctores();
    DoctorEntity actualizarDoctorInfo(Long idDoctor, DoctorEntity doctorActualizado);
    void eliminarDoctor(Long idDoctor);
}
