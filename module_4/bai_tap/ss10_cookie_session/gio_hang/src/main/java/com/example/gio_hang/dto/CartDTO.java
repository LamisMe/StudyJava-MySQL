package com.example.gio_hang.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private final Map<ProductDTO, Integer> productMap = new HashMap<>();

    public CartDTO() {
    }

    public Map<ProductDTO, Integer> getProductMap() {
        return productMap;
    }

    public void createProduct(ProductDTO productDTO) {
        if (productMap.containsKey(productDTO)) {
            int currentValue = productMap.get(productDTO);
            productMap.replace(productDTO, currentValue + 1);
        }
        productMap.put(productDTO, 1);
    }
}
