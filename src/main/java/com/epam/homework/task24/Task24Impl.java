package com.epam.homework.task24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task24Impl implements Task24 {

    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {

        Map<Integer, Integer> result = new HashMap<>();

        Set<Integer> coefficients = new HashSet<>(first.keySet());
        coefficients.addAll(second.keySet());
        for (Integer key : coefficients) {
            result.put(key, first.get(key) + second.get(key));
        }

        return result;
    }

}
