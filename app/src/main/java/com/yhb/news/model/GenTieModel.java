package com.yhb.news.model;

import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 */

public class GenTieModel {
    /**
     * thread : {"imgUrl":"","boardId":"dy_wemedia_bbs","title":"外国男子收拾祖父20年前遗物，发现迪士尼股权书，迪士尼还承认了","isAudit":false,"digest":"","docId":"D25FTB770514D4O2","url":"http://dy.163.com/v2/article/detail/D25FTB770514D4O2.html"}
     * comments : [{"favCount":1,"createTime":"2017-11-02 07:55:46","vote":531,"buildLevel":2,"commentId":211886174,"postId":"D25FTB770514D4O2_211886174","ip":"39.74.*.*","shareCount":0,"anonymous":true,"content":"兑现了，100银元兑了100人民币","unionState":false,"isDel":false,"source":"ph","productKey":"a2869674571f77b5a0867c3d71db5856","against":0,"user":{"location":"山东省","userId":0},"siteName":"网易"},{"favCount":3,"createTime":"2017-11-02 01:44:16","vote":3473,"buildLevel":1,"commentId":211829215,"postId":"D25FTB770514D4O2_211829215","ip":"105.112.*.*","shareCount":0,"anonymous":false,"content":"当年给老乡开的欠条兑现没？","unionState":false,"isDel":false,"source":"ph","productKey":"a2869674571f77b5a0867c3d71db5856","against":3,"user":{"id":"b2dtOXpzMXpsMDZlZGRiMzhmNDA4ZjlhOGUzNTliOTcwZThmYTg4YzU3QHd4LjE2My5jb20=","nickname":"有态度网友06iP08","location":"非洲","userId":105590792,"avatar":"http://wx.qlogo.cn/mmopen/KZyh6bgpeibUHLcseR3J6AKicNZhgicg2cMRxGrP1MaGibIPDKJBzmmN48eK8tuwqatCANOIwibGPgUUYHRomOFgfBvfRiaFUAb5iab/0","redNameInfo":[]},"siteName":"网易"},{"favCount":0,"createTime":"2017-11-02 08:48:00","vote":25,"buildLevel":22,"commentId":211915491,"postId":"D25FTB770514D4O2_211915491","ip":"111.8.*.*","shareCount":0,"anonymous":false,"content":"威武","unionState":false,"isDel":false,"source":"ph","productKey":"a2869674571f77b5a0867c3d71db5856","against":0,"user":{"id":"eGhhbmQwNjExQDE2My5jb20=","nickname":"网络中断","location":"湖南省益阳市","vipInfo":"vipw","userId":75142808,"avatar":"http://cms-bucket.nosdn.127.net/11c0e10ddef04392bed0736b53030c7e20170712141536.jpg","redNameInfo":[]},"siteName":"网易"},{"favCount":1,"createTime":"2017-11-02 08:50:07","vote":97,"buildLevel":23,"commentId":211917713,"postId":"D25FTB770514D4O2_211917713","ip":"122.96.*.*","shareCount":0,"anonymous":false,"content":"伟大","unionState":false,"isDel":false,"source":"ph","productKey":"a2869674571f77b5a0867c3d71db5856","against":0,"user":{"id":"b2dtOXpzX3EwdGY5MDI2YjdhNTNjMDM2YTE4YWJiNTdlZTA2NzNhNzc2QHd4LjE2My5jb20=","nickname":"闷声一九八一","location":"江苏省南京市","userId":100061737,"avatar":"http://mobilepics.nosdn.127.net/93cxdoGSqyP1q779lR8ydl5Z7zFJDLYX512976529","redNameInfo":[]},"siteName":"网易"}]
     */

    private ThreadBean thread;
    private List<CommentsBean> comments;

    public ThreadBean getThread() {
        return thread;
    }

    public void setThread(ThreadBean thread) {
        this.thread = thread;
    }

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class ThreadBean {
        /**
         * imgUrl :
         * boardId : dy_wemedia_bbs
         * title : 外国男子收拾祖父20年前遗物，发现迪士尼股权书，迪士尼还承认了
         * isAudit : false
         * digest :
         * docId : D25FTB770514D4O2
         * url : http://dy.163.com/v2/article/detail/D25FTB770514D4O2.html
         */

        private String title;
        private boolean isAudit;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isIsAudit() {
            return isAudit;
        }

        public void setIsAudit(boolean isAudit) {
            this.isAudit = isAudit;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class CommentsBean {
        /**
         * favCount : 1
         * createTime : 2017-11-02 07:55:46
         * vote : 531
         * buildLevel : 2
         * commentId : 211886174
         * postId : D25FTB770514D4O2_211886174
         * ip : 39.74.*.*
         * shareCount : 0
         * anonymous : true
         * content : 兑现了，100银元兑了100人民币
         * unionState : false
         * isDel : false
         * source : ph
         * productKey : a2869674571f77b5a0867c3d71db5856
         * against : 0
         * user : {"location":"山东省","userId":0}
         * siteName : 网易
         */

        private int favCount;
        private String createTime;
        private int vote;
        private int buildLevel;
        private int shareCount;
        private boolean anonymous;
        private String content;
        private boolean unionState;
        private UserBean user;
        private String siteName;

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        private String postId;

        public int getFavCount() {
            return favCount;
        }

        public void setFavCount(int favCount) {
            this.favCount = favCount;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getVote() {
            return vote;
        }

        public void setVote(int vote) {
            this.vote = vote;
        }

        public int getBuildLevel() {
            return buildLevel;
        }

        public void setBuildLevel(int buildLevel) {
            this.buildLevel = buildLevel;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public boolean isAnonymous() {
            return anonymous;
        }

        public void setAnonymous(boolean anonymous) {
            this.anonymous = anonymous;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public boolean isUnionState() {
            return unionState;
        }

        public void setUnionState(boolean unionState) {
            this.unionState = unionState;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getSiteName() {
            return siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        public static class UserBean {
            /**
             * location : 山东省
             * userId : 0
             */

            private String location;
            private int userId;

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null||!(obj instanceof GenTieModel)) {
            return false;
        }
        GenTieModel other=(GenTieModel) obj;
        if (other.getThread().getUrl().equals(this.getThread().getUrl())&&
                other.getComments().size()==this.getComments().size()
                ){
            return true;
        }
        return false;
    }
}
