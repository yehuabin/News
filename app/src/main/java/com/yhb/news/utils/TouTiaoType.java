package com.yhb.news.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by smk on 2017/10/17.
 */

public class TouTiaoType {
    private static Map<String, String> maps = new HashMap<>();

    static {
        maps.put("top", "头条");
        maps.put("shehui", "社会");
        maps.put("guonei", "国内");
        maps.put("guoji", "国际");
        maps.put("yule", "娱乐");
        maps.put("tiyu", "体育");
        maps.put("junshi", "军事");
        maps.put("keji", "科技");
        maps.put("caijing", "财经");
        maps.put("shishang", "时尚");
    }

    public static String GetVal(String key) {
        String val = "";
        for (Map.Entry<String, String> m : maps.entrySet()) {
            if (m.getKey() == key) {
                val = m.getValue();
                break;
            }
        }
        return val;
    }
}
