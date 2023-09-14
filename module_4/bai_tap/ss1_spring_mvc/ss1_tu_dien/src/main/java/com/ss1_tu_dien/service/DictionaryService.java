package com.ss1_tu_dien.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService{
    @Override
    public String result(String vocabulary) {
        Map<String,String> dictionary = new LinkedHashMap<>();
        dictionary.put("pig","con heo");
        dictionary.put("dog","con chó");
        dictionary.put("cat","con mèo");
        dictionary.put("car","xe hơi");
        dictionary.put("money","tiền");
        dictionary.put("fruit","hoa quả");
        dictionary.put("name","tên");
        for (Map.Entry<String,String> entry: dictionary.entrySet()){
            if (vocabulary.toLowerCase().equals(entry.getKey().toLowerCase())){
                return entry.getValue();
            }
        }
        return null;
    }
}
