package com.krakedev.inventario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.inventario.entity.EstadoProducto;
import com.krakedev.inventario.entity.Producto;
import com.krakedev.inventario.service.ProductoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.registrarProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @GetMapping()
    public ResponseEntity<List<Producto>> ListarProductos() {
        List<Producto> productos = productoService.listarProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre) {
        Optional<Producto> producto = productoService.BuscarPorNombre(nombre);
        return producto.isPresent() ? ResponseEntity.ok(producto.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");

    }

    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Producto> producto = productoService.BuscarPorId(id);
        return producto.isPresent() ? ResponseEntity.ok(producto.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
    }

    @PutMapping("/actualizar/{idP}")
    public ResponseEntity<?> actualizarProducto (@PathVariable long idP, @RequestBody Producto producto) {
        try {
            Producto productoActualizado = new Producto();
            productoActualizado.setNombreP(producto.getNombreP());
            productoActualizado.setCantidadP(producto.getCantidadP());
            productoActualizado.setDescripcionP(producto.getDescripcionP());
            productoActualizado.setPrecioP(producto.getPrecioP());
            productoActualizado.setEstadoP(producto.getEstadoP());
            
            Producto productoBDD = productoService.actualizarProducto(idP, productoActualizado);
            return ResponseEntity.ok(productoBDD);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{idP}")
    public ResponseEntity<?> eliminarProducto (@PathVariable long idP) {
        try {
            productoService.eliminarProducto(idP);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/estado/{idP}")
    public ResponseEntity<?> cambiarEstadoProducto (@PathVariable long idP, @RequestBody EstadoProducto nuevoEstado) {
        try {
            Producto producto = productoService.cambiarEstadoProducto(idP, nuevoEstado);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/estado/{estadoProducto}")
    public ResponseEntity<List<Producto>> LsitarPorEstadoProducto (@PathVariable EstadoProducto estadoProducto) {
        List<Producto> productos = productoService.obtenerPorEstadoProducto(estadoProducto);
        return ResponseEntity.ok(productos);
    }
}
