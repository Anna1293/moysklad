package com.example.moysklad.repository;

import com.example.moysklad.dto.ProductDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    //todo переделать на HachMap
    private final Map<Long, ProductDto> productsMap = new HashMap<>();


    @Override
    public Map<Long, ProductDto> findAll() {
        return new HashMap<>(productsMap);
    }

    @Override
    public void save(ProductDto product) {
        if (product == null || product.getId() == null) {
            throw new IllegalArgumentException("Продукт или его идентификатор не могут быть null");
        }
        productsMap.put(product.getId(), product);
    }

    @Override
    public ProductDto findById(Long id) {
        ProductDto product = productsMap.get(id);
        if (product == null) {
            throw new IllegalArgumentException("Продукт не найден по идентификатору: " + id);
        }
        return product;
    }

   /* @Override
    public boolean updateProduct(Long id, ProductDto productDto) {
        for (int i = 0; i < productsMap.size(); i++) {
            ProductDto product = productsMap.get(i);
            if (product.getId().equals(id)) {
                //todo добавить мапер для мапинга с учетом частичного заполнения ДТО
                productsMap.set(i, productDto);
                return true;
            }
        }
        return false;
    }*/

    @Override
    public void updateProduct(Long id, ProductDto productDto) {
        if (id == null || productDto == null) {
            throw new IllegalArgumentException("Идентификатор и продукт не могут быть null");
        }

        ProductDto existingProduct = productsMap.get(id);
        if (existingProduct != null) {
            existingProduct.setName(productDto.getName());
            existingProduct.setPrice(productDto.getPrice());
            existingProduct.setId(productDto.getId());
            existingProduct.setAvailable(productDto.getAvailable());
            existingProduct.setDescription(productDto.getDescription());

        }
    }

    @Override
    public boolean deleteProduct(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Идентификатор не может быть null");
        }
        return productsMap.remove(id) != null;
    }
}


