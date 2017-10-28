package com.yhb.news.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/10/28.
 * 网易新闻分类model
 */

public class NewsModel {

   @SerializedName(value = "BD2AQH4Qwangning",alternate = {"BBM54PGAwangning","BA10TA81wangning","list","BA8E6OEOwangning"})
    private List<News> newsList;

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public static class News {
        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }


        private String link;
        private String docid;
        private String title;
        private String source;
        private int priority;
        private Object liveInfo;
        private String imgsrc;
        private String stitle;
        private int hasImg;
        private String digest;
        private int commentCount;
        private String ptime;
        private String url;
        private String imgsrc3gtype;
        private String category;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getSkipURL() {
            return skipURL;
        }

        public void setSkipURL(String skipURL) {
            this.skipURL = skipURL;
        }

        private String skipURL;

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public Object getLiveInfo() {
            return liveInfo;
        }

        public void setLiveInfo(Object liveInfo) {
            this.liveInfo = liveInfo;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getStitle() {
            return stitle;
        }

        public void setStitle(String stitle) {
            this.stitle = stitle;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImgsrc3gtype() {
            return imgsrc3gtype;
        }

        public void setImgsrc3gtype(String imgsrc3gtype) {
            this.imgsrc3gtype = imgsrc3gtype;
        }
        public List<PicInfoBean> getPicInfo() {
            return picInfo;
        }

        public void setPicInfo(List<PicInfoBean> picInfo) {
            this.picInfo = picInfo;
        }
        private List<PicInfoBean> picInfo;
        public static class PicInfoBean {
            /**
             * height : null
             * ref : null
             * url : http://cms-bucket.nosdn.127.net/94e7cfa8d9984571b2f79c2ef83689b320171028074533.png
             * width : null
             */

            private Object height;
            private Object ref;
            private String url;
            private Object width;

            public Object getHeight() {
                return height;
            }

            public void setHeight(Object height) {
                this.height = height;
            }

            public Object getRef() {
                return ref;
            }

            public void setRef(Object ref) {
                this.ref = ref;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Object getWidth() {
                return width;
            }

            public void setWidth(Object width) {
                this.width = width;
            }
        }
    }


}
