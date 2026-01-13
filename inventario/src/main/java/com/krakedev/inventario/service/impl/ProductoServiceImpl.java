package com.krakedev.inventario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.inventario.entity.EstadoProducto;
import com.krakedev.inventario.entity.Producto;
import com.krakedev.inventario.repository.ProductoRepository;
import com.krakedev.inventario.service.ProductoService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public Producto registrarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> BuscarPorId(Long idProducto) {
        return productoRepository.findByIdP(idProducto);
    }

    @Override
    public Optional<Producto> BuscarPorNombre(String nombreProducto) {
        return productoRepository.findByNombreP(nombreProducto);
    }

    @Override
    @SneakyThrows
    public Producto actualizarProducto(Long idP, Producto producto) {
        Producto productoEcistente = productoRepository.findByIdP(idP)
                .orElseThrow(() -> new Exception("Producto no encontrado"));

        productoEcistente.setNombreP(producto.getNombreP());
        productoEcistente.setDescripcionP(producto.getDescripcionP());
        productoEcistente.setPrecioP(producto.getPrecioP());
        productoEcistente.setCantidadP(producto.getCantidadP());
        productoEcistente.setEstadoP(producto.getEstadoP());

        Producto productoActualizado = productoRepository.save(productoEcistente);
        return productoActualizado;
    }

    @Override
    @SneakyThrows
    public void eliminarProducto(Long idP) {
        productoRepository.findByIdP(idP)
                .orElseThrow(() -> new Exception("Producto no encontrado"));

        productoRepository.deleteById(idP);
    }

    @Override
    @SneakyThrows
    public Producto cambiarEstadoProducto(Long idP, EstadoProducto nuevoEstado) {
        Producto productoEcistente = productoRepository.findByIdP(idP)
                .orElseThrow(() -> new Exception("Producto no encontrado"));

        productoEcistente.setEstadoP(nuevoEstado);;

        Producto productoActualizado = productoRepository.save(productoEcistente);
        return productoActualizado;
    }

    @Override
    public List<Producto> obtenerPorEstadoProducto(EstadoProducto estadoP) {
        return productoRepository.findByEstadoP(estadoP);
    }

}
