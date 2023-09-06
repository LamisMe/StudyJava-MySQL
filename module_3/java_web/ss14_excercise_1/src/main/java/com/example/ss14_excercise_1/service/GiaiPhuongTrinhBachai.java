package com.example.ss14_excercise_1.service;

import java.util.ArrayList;
import java.util.List;

public class GiaiPhuongTrinhBachai implements IGiaiPhuongTrinhBacHai{
    @Override
    public List<Double> giaiPhuongTrinhBacHai(int a,int b,int c) {
        double delta = b*b - 4*(a*c);
        List<Double> result = new ArrayList<>();
        if(delta > 0){
           double equation1 = (-b + Math.sqrt(delta)) / (2*a);
            double equation2 = (-b - Math.sqrt(delta)) / (2*a);
            result.add(equation1);
            result.add(equation2);
        }else if(delta == 0){
            double equation = -b/(2 * a);
            result.add(equation);
        }else {
            return result;
        }
        return result;
    }
}