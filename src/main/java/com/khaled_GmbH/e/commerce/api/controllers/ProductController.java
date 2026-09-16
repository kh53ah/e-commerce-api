package com.khaled_GmbH.e.commerce.api.controllers;

import com.khaled_GmbH.e.commerce.api.dtos.ProductDto;
import com.khaled_GmbH.e.commerce.api.entities.Product;
import com.khaled_GmbH.e.commerce.api.mappers.ProductMapper;
import com.khaled_GmbH.e.commerce.api.repositories.CategoryRepository;
import com.khaled_GmbH.e.commerce.api.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public Iterable<ProductDto> getAllProducts(
            @RequestParam(name = "categoryId", required = false)
            Byte categoryId) {
        List<Product> products;
        if (categoryId != null)
            products = productRepository.findByCategoryId(categoryId);
        else
            products = productRepository.findAll();

        return products
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Integer id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(productMapper.toDto(product));
    }

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(
            @RequestBody ProductDto request,
            UriComponentsBuilder uriBuilder) {

        var category = categoryRepository.findById(request.getCategoryId().intValue())
                .orElseThrow();

        var product = productMapper.toEntity(request);

        product.setCategory(category);
        if (product.getStock() == null) {
            product.setStock(0);
        }
        productRepository.save(product);

        var url = uriBuilder.path("/products/{id}")
                .buildAndExpand(product.getId())
                .toUri();
        return ResponseEntity.created(url).body(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @RequestBody ProductDto request,
            @PathVariable Integer id
    ) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        } else {
            productMapper.update(request, product);
            productRepository.save(product);
            return ResponseEntity.ok(productMapper.toDto(product));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> deleteProduct(
            @RequestBody ProductDto request,
            @PathVariable Integer id
    ) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null)
            return ResponseEntity.notFound().build();
        productRepository.delete(product);
        return ResponseEntity.noContent().build();
    }
}
