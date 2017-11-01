package com.yhb.news.model;

/**
 * Created by Administrator on 2017/10/28.
 */

public class NewsCommonModel {
    private String url;
    private String image;
    private String title;
    private String date;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String author;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null||!(obj instanceof NewsCommonModel)) {
            return false;
        }
        NewsCommonModel other = (NewsCommonModel) obj;
        if (other.getUrl()!=null&&other.getUrl().equals(this.getUrl())) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return getUrl().hashCode();
    }
}
