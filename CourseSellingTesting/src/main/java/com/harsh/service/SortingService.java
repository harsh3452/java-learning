package com.harsh.service;

import java.util.Arrays;
import java.util.Objects;

public class SortingService {
    public int [] sortingArray(int[] array){
        if(array == null) throw new IllegalArgumentException("Arrays cannot be null");
        //Objects.requireNonNull(array);
        Arrays.sort(array);
        return array;
    }
}
