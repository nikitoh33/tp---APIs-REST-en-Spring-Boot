package com.utn.productos_api.service;

import com.utn.productos_api.model.Producto;
import com.utn.productos_api.model.Categoria;
import com.utn.productos_api.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> getProductosByCategoria(Categoria categoria) {
        return productoRepository.findByCategoria(categoria);
    }
}
