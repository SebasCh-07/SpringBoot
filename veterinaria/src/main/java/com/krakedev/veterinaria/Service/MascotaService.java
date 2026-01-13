package com.krakedev.veterinaria.Service;

import java.util.List;
import java.util.Optional;

import com.krakedev.veterinaria.entity.EstadoMascota;
import com.krakedev.veterinaria.entity.Mascota;

public interface MascotaService {
    Mascota registrarMascota(Mascota mascota);
    List<Mascota> listarMascotas();
    Optional<Mascota> BuscarPorId(Long id);
    Optional<Mascota> BuscarPorNombre(String nombre);
    Mascota actualizarMascota(Long id, Mascota mascota);
    void eliminarMascota(Long id);
    List<Mascota> obtenerPorEstado(EstadoMascota estado);
    Mascota cambiarEstado(Long id, EstadoMascota estado);


}
