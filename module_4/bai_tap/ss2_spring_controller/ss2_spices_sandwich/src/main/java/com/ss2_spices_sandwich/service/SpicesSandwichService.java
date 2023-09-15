package com.ss2_spices_sandwich.service;

import org.springframework.stereotype.Service;

@Service
public class SpicesSandwichService implements ISpicesSandwichService {
    public String[] spices(String[] condiment) {
        String[] spices = new String[condiment.length];
        int index = 0;
        for (int i = 0; i < condiment.length; i++) {
            spices[index] = condiment[i];
            index++;
        }
        return spices;
    }
}
