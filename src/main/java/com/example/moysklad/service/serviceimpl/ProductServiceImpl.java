package com.example.moysklad.service.serviceimpl;

import com.example.moysklad.dto.ProductDto;
import com.example.moysklad.repository.ProductRepository;
import com.example.moysklad.service.serviceapi.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    //todo текущий id это информация не сервиса а репозитория, необходимо перенести генерацию id в репозиторий
    //todo и выделить в отдельный метод.
    private Long currentId = 1L;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Map<Long, ProductDto> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Long create(ProductDto productDto) {
        //todo нет метода create
        productDto.setId(currentId++);
        productRepository.save(productDto);
        return productDto.getId();
    }

    @Override
    public ProductDto findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Идентификатор не может быть null");
        }

        return productRepository.findById(id);
    }

    @Override
    public void updateProduct(ProductDto productDto, Long id) {
        productRepository.updateProduct(id, productDto);
    }


    public void deleteProduct(Long id) {
        if (!productRepository.deleteProduct(id)) {
            throw new IllegalArgumentException("Продукт не найден для удаления");

        }
    }
}




