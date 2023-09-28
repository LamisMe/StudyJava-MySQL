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
    public void downProductQuantity(ProductDTO productDto){
        int currentValue = productMap.get(productDto);
        productMap.replace(productDto,currentValue-1);
    }

    public void createProduct(ProductDTO productDTO) {
        if (productMap.containsKey(productDTO)) {
            int currentValue = productMap.get(productDTO);
            productMap.replace(productDTO, currentValue + 1);
        }
        productMap.put(productDTO, 1);
    }
    public Double countTotalPayment(){
        double payment = 0;
        for (Map.Entry<ProductDTO, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
