package com.katas;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create a method that takes a string and a dictionary,
 * and replaces every key in the dictionary pre and suffixed
 * with a dollar sign, with the corresponding value from the Dictionary.
 * */
public class DictReplacer {

    public String replace(String input, Map<String, String> dictionary){

        return Arrays.stream(input.split(" "))
                .map(w -> {
                    if (isKey(w) && dictionary.containsKey(getKey(w))) {
                        return dictionary.get(getKey(w));
                    } else {
                        return w;
                    }
                }).collect(Collectors.joining(" "));
    }

    private boolean isKey(String s){
        return s.trim().startsWith("$") && s.trim().endsWith("$");
    }

    private String getKey(String s){
        return s.replaceAll("\\$","");
    }

}
