package com.example.moysklad.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;


public class ProductDto {
    @Id
    private Long id;

    @NotBlank(message = "Название товара обязательно")
    @Size(max = 255, message = "Название товара не должно превышать 255 символов")
    private String name;

    @Size(max = 4096, message = "Описание товара не должно превышать 4096 символов")
    private String description;

    private double price;

    private boolean available;



    public ProductDto(Long id, String name, double price, boolean available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription(){
        return description;
    }

    public boolean getAvailable(){
        return available;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}

