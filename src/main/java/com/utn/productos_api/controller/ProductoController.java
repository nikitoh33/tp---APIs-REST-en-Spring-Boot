package com.utn.productos_api.controller;

import com.utn.productos_api.dto.ActualizarStockDTO;
import com.utn.productos_api.dto.ProductoDTO;
import com.utn.productos_api.model.Categoria;
import com.utn.productos_api.model.Producto;
import com.utn.productos_api.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> createProducto(@Valid @RequestBody ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        producto.setCategoria(productoDTO.getCategoria());

        Producto nuevoProducto = productoService.saveProducto(producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @Valid @RequestBody ProductoDTO productoDTO) {
        return productoService.getProductoById(id)
                .map(producto -> {
                    producto.setNombre(productoDTO.getNombre());
                    producto.setPrecio(productoDTO.getPrecio());
                    producto.setStock(productoDTO.getStock());
                    producto.setCategoria(productoDTO.getCategoria());
                    Producto actualizado = productoService.saveProducto(producto);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        if (productoService.getProductoById(id).isPresent()) {
            productoService.deleteProducto(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Actualizar solo el stock
    @PatchMapping("/{id}/stock")
    public ResponseEntity<Producto> updateStock(@PathVariable Long id, @Valid @RequestBody ActualizarStockDTO stockDTO) {
        return productoService.getProductoById(id)
                .map(producto -> {
                    producto.setStock(stockDTO.getStock());
                    Producto actualizado = productoService.saveProducto(producto);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar por categoría (usando el enum)
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Producto>> getByCategoria(@PathVariable Categoria categoria) {
        return ResponseEntity.ok(productoService.getProductosByCategoria(categoria));
    }
}
