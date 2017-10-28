package com.yhb.news.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by smk on 2017/10/17.
 */

public class TouTiaoType {
    private static Map<String, String> maps = new HashMap<>();

    static {
        maps.put("0", "头条");
        maps.put("1", "新闻");
        maps.put("2", "娱乐");
        maps.put("3", "NBA");
        maps.put("4", "体育");

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
