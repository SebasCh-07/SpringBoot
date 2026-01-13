package com.krakedev.veterinaria.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.veterinaria.Repository.MascotaRepository;
import com.krakedev.veterinaria.Service.MascotaService;
import com.krakedev.veterinaria.entity.EstadoMascota;
import com.krakedev.veterinaria.entity.Mascota;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    @Override
    public Mascota registrarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> BuscarPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    @Override
    public Optional<Mascota> BuscarPorNombre(String nombre) {
        return mascotaRepository.findByNombre(nombre);
    }

    @Override
    @SneakyThrows
    public Mascota actualizarMascota(Long id, Mascota mascota) {
        Mascota mascotaExistente = mascotaRepository.findById(id)
                .orElseThrow(() -> new Exception("Mascota no encontrado"));
        mascotaExistente.setNombre(mascota.getNombre());
        mascotaExistente.setEdad(mascota.getEdad());
        mascotaExistente.setEspecie(mascota.getEspecie());
        return mascotaRepository.save(mascotaExistente);
    }

    @Override
    @SneakyThrows
    public void eliminarMascota(Long id) {
        mascotaRepository.findById(id)
                .orElseThrow(() -> new Exception("Mascota no encontrado"));
        mascotaRepository.deleteById(id);
    }

    @Override
    public List<Mascota> obtenerPorEstado(EstadoMascota estado) {
        return mascotaRepository.findByEstado(estado);
    }

    @Override
    public Mascota cambiarEstado(Long id, EstadoMascota estado) {
        Mascota mascotaExistente = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrado"));
        mascotaExistente.setEstado(estado);
        return mascotaRepository.save(mascotaExistente);
    }

}
