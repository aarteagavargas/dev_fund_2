package com.jalasoft.crud.web;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private static Cache cache;
    private static List<String> tokens;

    private Cache(){
        tokens = new ArrayList<String>();
    }

    public static Cache getInstance(){
        if (cache == null){
            cache = new Cache();
        }
        return cache;
    }

    public void add(String token){
        tokens.add(token);
    }

    public boolean isValid(String token) {
        return tokens.contains(token);
    }
}
