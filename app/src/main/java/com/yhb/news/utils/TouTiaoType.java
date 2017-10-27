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
        maps.put("2", "财经");
        maps.put("3", "体育");
        maps.put("4", "娱乐");
        maps.put("5", "军事");
        maps.put("6", "教育");
        maps.put("7", "科技");
        maps.put("8", "NBA");
        maps.put("9", "股票");
        maps.put("10", "星座");
        maps.put("11", "女性");
        maps.put("12", "健康");
        maps.put("13", "育儿");
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
