/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class FlyWeightFactory {
    private static final Map<String , List> cachesData = new HashMap<>();
    
    public static <E> List<E> getData(QueryServiceBase s, String key){
        if(cachesData.containsKey(key)== false){
//            System.out.println(Math.random());
            try {
                cachesData.put(key, s.list());
            } catch (SQLException ex) {
                Logger.getLogger(FlyWeightFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cachesData.get(key);
    }
}
