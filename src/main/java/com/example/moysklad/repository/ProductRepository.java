package com.example.moysklad.repository;

import com.example.moysklad.dto.ProductDto;

import java.util.List;
import java.util.Map;


public interface ProductRepository {

    Map<Long, ProductDto> findAll();

    void save(ProductDto productDto);

    void updateProduct(Long id, ProductDto productDto);

    boolean deleteProduct(Long id);

    ProductDto findById(Long id);
}
