package com.yhb.news.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/2.
 */

public class JokeUtil {
    private static Map<String, String> maps = new HashMap<>();

    static {
        maps.put("0", "跟帖");
        maps.put("1", "漫画");

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
