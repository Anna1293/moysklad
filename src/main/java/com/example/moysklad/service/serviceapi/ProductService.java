package com.example.moysklad.service.serviceapi;

import com.example.moysklad.dto.ProductDto;

import java.util.List;
import java.util.Map;

public interface ProductService {

    //todo отсутствует описание метода
    Map<Long, ProductDto> getAll();

    //todo отсутствует описание метода
    Long create(ProductDto productDto);

    //todo отсутствует описание метода
    ProductDto findById(Long id);

    //todo отсутствует описание метода
    //todo метод доложен возвращать 200 ответ.
    void updateProduct(ProductDto productDto, Long id);

    //todo отсутствует описание метода
    void deleteProduct(Long id);
}

