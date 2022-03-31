package com.healthcare.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthcare.entity.QuestionnaireData;
import com.healthcare.entity.QuestionnaireOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class QuestionnaireRedirectConverter implements AttributeConverter<List<Integer>, String> {

    private static ObjectMapper mapper;

    static {
        // To avoid instantiating ObjectMapper again and again.
        mapper = new ObjectMapper();
    }

    @Override
    public String convertToDatabaseColumn(List<Integer> data) {
        if (null == data) {
            // You may return null if you prefer that style
            return "{}";
        }

        try {
            return mapper.writeValueAsString(data);

        } catch (IOException e) {
            throw new IllegalArgumentException("Error converting map to JSON", e);
        }
    }

    @Override
    public List<Integer> convertToEntityAttribute(String s) {
        if (null == s) {
            // You may return null if you prefer that style
            return new ArrayList<>();
        }

        try {
            return mapper.readValue(s, List.class);

        } catch (IOException e) {
            throw new IllegalArgumentException("Error converting JSON to map", e);
        }
    }
}