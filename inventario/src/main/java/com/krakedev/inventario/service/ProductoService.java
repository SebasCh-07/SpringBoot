package com.krakedev.inventario.service;

import java.util.List;
import java.util.Optional;

import com.krakedev.inventario.entity.EstadoProducto;
import com.krakedev.inventario.entity.Producto;

public interface ProductoService {

    Producto registrarProducto(Producto producto);
    List<Producto> listarProductos();
    Optional<Producto> BuscarPorId(Long idProducto);
    Optional<Producto> BuscarPorNombre(String nombreProducto);
    Producto actualizarProducto(Long idProducto, Producto producto); 
    void eliminarProducto(Long idProducto);

    Producto cambiarEstadoProducto(Long idProducto, EstadoProducto nuevoEstado);
    List<Producto> obtenerPorEstadoProducto(EstadoProducto estadoProducto);
}
