package com.yhb.news.utils;

import com.yhb.news.model.NewsCommonModel;
import com.yhb.news.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

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

}
