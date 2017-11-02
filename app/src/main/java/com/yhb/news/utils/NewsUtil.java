package com.yhb.news.utils;

import com.yhb.news.model.NewsCommonModel;
import com.yhb.news.model.NewsModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/28.
 */

public class NewsUtil {
    public static List<NewsCommonModel> getRecommend(List<NewsModel.News> data)
    {
        List<NewsCommonModel> result=new ArrayList<>();
        if (data==null||data.size()==0){
            return result;
        }
        NewsCommonModel model;
        for (int i=0;i<data.size();i++){
            NewsModel.News item=data.get(i);
            model=new NewsCommonModel();
            model.setTitle(item.getTitle());
            if (item.getLink()!=null) {
                model.setUrl(item.getLink());
            }
            else {
                model.setUrl(item.getSkipURL()!=null?item.getSkipURL():item.getUrl());
            }
            model.setAuthor(item.getSource());
            model.setDate(item.getPtime());
            if (item.getPicInfo()!=null&&item.getPicInfo().size()>0){
                model.setImage(item.getPicInfo().get(0).getUrl());
            }
            else {
                model.setImage(item.getImgsrc());
            }
            result.add(model);
        }

        return  result;
    }
    private static Map<String, String> maps = new HashMap<>();

    static {
        maps.put("0", "头条");
        maps.put("1", "新闻");
        maps.put("2", "轻松一刻");
        maps.put("3", "NBA");
        maps.put("4", "娱乐");
        maps.put("5", "体育");

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
    public static int getCount(){
      return maps.size();
    }
    public static String publishTime(String fromDate){
        try {
            SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           // String fromDate = simpleFormat.format(simpleFormat.parse(date));
            String toDate = simpleFormat.format(new Date());
            long from = simpleFormat.parse(fromDate).getTime();
            long to = simpleFormat.parse(toDate).getTime();
            int days = (int) ((to - from)/(1000 * 60 * 60 * 24));
            int hours = (int) ((to - from)/(1000 * 60 * 60));
            int minutes = (int) ((to - from)/(1000 * 60));
           if (days>0){
               return days+"天前";
           }
           else   if (hours>0){
               return hours+"小时前";
           }
           else   if (minutes>0){
               return minutes+"分钟前";
           }
        }
       catch (Exception e){
           return "";
       }
        return "";
    }
}
