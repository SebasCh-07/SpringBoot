package com.krakedev.veterinaria.Service;

import java.util.List;
import java.util.Optional;

import com.krakedev.veterinaria.entity.Mascota;

public interface MascotaService {
    Mascota registrarMascota(Mascota mascota);
    List<Mascota> listarMascotas();
    Optional<Mascota> BuscarPorId(Long idMascota);
    Optional<Mascota> BuscarPorNombre(String nombreMascota);
    Mascota actualizarMascota(Long idMascota, Mascota mascota);
    void eliminarMascota(Long idMascota);

}
