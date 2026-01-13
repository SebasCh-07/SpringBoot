package com.krakedev.veterinaria.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.veterinaria.Repository.MascotaRepository;
import com.krakedev.veterinaria.Service.MascotaService;
import com.krakedev.veterinaria.entity.Mascota;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {

    private MascotaRepository mascotaRepository;

    @Override
    public Mascota registrarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> BuscarPorId(Long idMascota) {
        return mascotaRepository.findById(idMascota);
    }

    @Override
    public Optional<Mascota> BuscarPorNombre(String nombreMascota) {
        return mascotaRepository.findByNombreMascota(nombreMascota);
    }

    @Override
    @SneakyThrows
    public Mascota actualizarMascota(Long idMascota, Mascota mascota) {
        Mascota mascotaExistente = mascotaRepository.findById(idMascota)
                .orElseThrow(() -> new Exception("Mascota no encontrado"));
        mascotaExistente.setNombre(mascota.getNombre());
        mascotaExistente.setEdad(mascota.getEdad());
        mascotaExistente.setEspecie(mascota.getEspecie());
        return mascotaRepository.save(mascotaExistente);
    }

    @Override
    @SneakyThrows
    public void eliminarMascota(Long idMascota) {
        mascotaRepository.findById(idMascota)
                .orElseThrow(() -> new Exception("Mascota no encontrado"));
        mascotaRepository.deleteById(idMascota);
    }

}
