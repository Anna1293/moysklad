package com.example.moysklad.controller;

import com.example.moysklad.common.Urls;
import com.example.moysklad.dto.ProductDto;
import com.example.moysklad.service.serviceapi.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
//todo поменять организацию url на вложенные интерфейсы.
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Метод возвращает все товары")
    @GetMapping(Urls.Product.GetProductList.FULL)
    public Map<Long, ProductDto> getAllProducts() {
        return productService.getAll();
    }

    @Operation(summary = "Метод возвращает отдельный товар по идентификатору")
    @GetMapping("/{id}")
    //todo для чего возвращаем ResponseEntity? Почему не Дто? Сделай в одну строку.
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        ProductDto product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Operation(summary = "Метод создает товар")
    @PostMapping(Urls.Product.PostProduct.FULL)
    public Long create(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }

    @Operation(summary = "Метод изменяет товар")
    @PutMapping(Urls.Product.PutProduct.FULL + "/{id}")
    public void updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id) {
        productService.updateProduct(productDto, id);
    }

    @Operation(summary = "Метод удаляет товар")
    @DeleteMapping(Urls.Product.DeleteProduct.FULL)
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}




