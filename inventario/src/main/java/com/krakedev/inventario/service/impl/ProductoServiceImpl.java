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

    private ProductoRepository productoRepository;

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
        return productoRepository.findByIdProducto(idProducto);
    }

    @Override
    public Optional<Producto> BuscarPorNombre(String nombreProducto) {
        return productoRepository.findByNombreProducto(nombreProducto);
    }

    @Override
    @SneakyThrows
    public Producto actualizarProducto(Long idProducto, Producto producto) {
        Producto productoEcistente = productoRepository.findByIdProducto(idProducto)
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
    public void eliminarProducto(Long idProducto) {
        productoRepository.findByIdProducto(idProducto)
                .orElseThrow(() -> new Exception("Producto no encontrado"));

        productoRepository.deleteById(idProducto);
    }

    @Override
    @SneakyThrows
    public Producto cambiarEstadoProducto(Long idProducto, EstadoProducto nuevoEstado) {
        Producto productoEcistente = productoRepository.findByIdProducto(idProducto)
                .orElseThrow(() -> new Exception("Producto no encontrado"));

        productoEcistente.setEstadoP(nuevoEstado);;

        Producto productoActualizado = productoRepository.save(productoEcistente);
        return productoActualizado;
    }

    @Override
    public List<Producto> obtenerPorEstadoProducto(EstadoProducto estadoProducto) {
        return productoRepository.findByEstadoProducto(estadoProducto);
    }

}
