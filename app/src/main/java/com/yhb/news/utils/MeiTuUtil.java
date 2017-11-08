package com.yhb.news.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/6.
 */

public class MeiTuUtil {
    private static Map<String, String> maps = new HashMap<>();

    static {
        maps.put("0", "popular");
        maps.put("1", "girl");
        maps.put("2", "love");
        maps.put("3", "family");
        maps.put("4", "baby");
        maps.put("5", "happy");
        maps.put("6", "wedding");
        maps.put("7", "nature");
        maps.put("8", "sunrise");
        maps.put("9", "stars");
        maps.put("10", "hair");
        maps.put("11", "beauty");
        maps.put("12", "water");
        maps.put("13", "fashion");
        maps.put("14", "feet");
        maps.put("15", "couple");
        maps.put("16", "party");

    }
    public static String getVal(String key) {
        String val = "";
        for (Map.Entry<String, String> m : maps.entrySet()) {
            if (m.getKey().equals( key)) {
                val = m.getValue();
                break;
            }
        }
        return val;
    }
    public static List<String> getData(){
        List<String> data=new ArrayList<>();
        for (Map.Entry<String, String> m : maps.entrySet()) {
            data.add(m.getValue());
        }
        return data;
    }
}
