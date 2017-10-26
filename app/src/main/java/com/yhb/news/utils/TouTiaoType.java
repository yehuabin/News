package com.yhb.news.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by smk on 2017/10/17.
 */

public class TouTiaoType {
    private static Map<String, String> maps = new HashMap<>();

    static {
        maps.put("-1", "首页");
        maps.put("0", "热点");
        maps.put("1", "推荐");
        maps.put("2", "段子手");
        maps.put("3", "养生堂");
        maps.put("4", "私房话");
        maps.put("5", "八卦精");
        maps.put("6", "爱生活");
        maps.put("7", "财经迷");
        maps.put("8", "汽车迷");
        maps.put("9", "科技咖");
        maps.put("10", "潮人帮");
        maps.put("11", "辣妈帮");
        maps.put("12", "点赞党");
        maps.put("13", "旅行家");
        maps.put("14", "职场人");
        maps.put("15", "美食家");
        maps.put("16", "古今通");
        maps.put("17", "学霸族");
        maps.put("18", "星座控");
    }

    public static String GetVal(String key) {
        String val = "";
        for (Map.Entry<String, String> m : maps.entrySet()) {
            if (m.getKey().equals( key)) {
                val = m.getValue();
                break;
            }
        }
        return val;
    }
}
