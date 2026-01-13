package com.krakedev.veterinaria.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.krakedev.veterinaria.entity.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    Optional<Mascota> findByNombreMascota(String nombreMascota);
    Optional<Mascota> findById(Long idMascota);

}
