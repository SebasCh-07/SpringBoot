package com.krakedev.veterinaria.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krakedev.veterinaria.entity.EstadoMascota;
import com.krakedev.veterinaria.entity.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    Optional<Mascota> findByNombre(String nombre);
    Optional<Mascota> findById(Long id);
    java.util.List<Mascota> findByEstado(EstadoMascota estado);

}
