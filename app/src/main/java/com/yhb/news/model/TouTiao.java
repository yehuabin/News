package com.yhb.news.model;

import java.util.List;

/**
 * Created by smk on 2017/10/13.
 */

public class TouTiao {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"pagebean":{"allPages":150,"contentlist":[{"date":"2017-10-25 12:48:01","ct":"2017-10-25 14:02:05.729","weixinNum":"zhxsbhw","url":"http://mp.weixin.qq.com/s?src=11&timestamp=1508911212&ver=473&signature=mP1D5OzTYJrrt*pn81-N0Wq8fIMvAsL3-gpa*cI92n-qQkMV18WMRBFX6dSWVwtvmZuCsVXUhF0ne5MpYlXx7kHRvtRH45RltlDJYPACKbt7moWlCBRtXyITFlMbdlS-&new=1","id":"57029655b9b5309bca5f2b8c022bdce5","typeName":"辣妈帮","title":"800万的房子算什么，你家熊孩子还不是照样没教养","contentImg":"http://mmbiz.qpic.cn/mmbiz_jpg/doe5wWMSjcarlctmgF3kxYfSeUrCkToPibebuFjsotlnAgwfvXYRkEic1BVtmV20IcNYzdYm9sJXyyab7f7NVEHw/0?wx_fmt=jpeg","_id":"59f028dd6e36a14449de11ee","userLogo":"http://mmbiz.qpic.cn/mmbiz/doe5wWMSjcbDCiaaH6aON4QH5ruTLFlamUpPVz1HDzaxxfGMIV9jzjTfryq0aqiaElK3tARD07GK3LchtqtD6XJg/0?wx_fmt=png","userName":"刑事法律圈","read_num":0,"like_num":0,"typeId":"11","userLogo_code":"http://open.weixin.qq.com/qr/code/?username=zhxsbhw"},{"date":"2017-10-25 06:59:26","ct":"2017-10-25 14:02:04.773","weixinNum":"Science_China","url":"http://mp.weixin.qq.com/s?src=11&timestamp=1508911207&ver=473&signature=WDOGeUlpl-XGmd9SHKO8NCQCSWjNombCb7UmgKRBd2kbkDQVA15MnSr5MMEyz2YcM1hdCOwUKEY2y-FWOAfqznalDmifFoMUp*rhUYhd30mjHaHwLARJjegVMF-IdSkQ&new=1","id":"05374745c3fee8e4b9650a4390ccc552","typeName":"爱生活","title":"早安！新闻来了丨2017年10月25日 星期三","contentImg":"http://mmbiz.qpic.cn/mmbiz_jpg/03UUuUr98GLmdrserzt625mLL1QmicDWUwzqYz3beia1dCeyYS39MUs5eqaHXu4IiawzXTt2icTiaoaGicSaEdKue38Q/0?wx_fmt=jpeg","_id":"59f028dc6e36a14449de11ed","userLogo":"http://mmbiz.qpic.cn/mmbiz/03UUuUr98GJicUZpZu49gtoM79CpK57jjqh64gyFcA90Ue89LbFOAqyuAaibQABibex2A5G7YnicS7o515U2NHT1vQ/0?wx_fmt=png","userName":"科普中国","read_num":0,"like_num":0,"typeId":"6","userLogo_code":"http://open.weixin.qq.com/qr/code/?username=Science_China"}],"currentPage":155,"allNum":3000,"maxResult":20}}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * pagebean : {"allPages":150,"contentlist":[{"date":"2017-10-25 12:48:01","ct":"2017-10-25 14:02:05.729","weixinNum":"zhxsbhw","url":"http://mp.weixin.qq.com/s?src=11&timestamp=1508911212&ver=473&signature=mP1D5OzTYJrrt*pn81-N0Wq8fIMvAsL3-gpa*cI92n-qQkMV18WMRBFX6dSWVwtvmZuCsVXUhF0ne5MpYlXx7kHRvtRH45RltlDJYPACKbt7moWlCBRtXyITFlMbdlS-&new=1","id":"57029655b9b5309bca5f2b8c022bdce5","typeName":"辣妈帮","title":"800万的房子算什么，你家熊孩子还不是照样没教养","contentImg":"http://mmbiz.qpic.cn/mmbiz_jpg/doe5wWMSjcarlctmgF3kxYfSeUrCkToPibebuFjsotlnAgwfvXYRkEic1BVtmV20IcNYzdYm9sJXyyab7f7NVEHw/0?wx_fmt=jpeg","_id":"59f028dd6e36a14449de11ee","userLogo":"http://mmbiz.qpic.cn/mmbiz/doe5wWMSjcbDCiaaH6aON4QH5ruTLFlamUpPVz1HDzaxxfGMIV9jzjTfryq0aqiaElK3tARD07GK3LchtqtD6XJg/0?wx_fmt=png","userName":"刑事法律圈","read_num":0,"like_num":0,"typeId":"11","userLogo_code":"http://open.weixin.qq.com/qr/code/?username=zhxsbhw"},{"date":"2017-10-25 06:59:26","ct":"2017-10-25 14:02:04.773","weixinNum":"Science_China","url":"http://mp.weixin.qq.com/s?src=11&timestamp=1508911207&ver=473&signature=WDOGeUlpl-XGmd9SHKO8NCQCSWjNombCb7UmgKRBd2kbkDQVA15MnSr5MMEyz2YcM1hdCOwUKEY2y-FWOAfqznalDmifFoMUp*rhUYhd30mjHaHwLARJjegVMF-IdSkQ&new=1","id":"05374745c3fee8e4b9650a4390ccc552","typeName":"爱生活","title":"早安！新闻来了丨2017年10月25日 星期三","contentImg":"http://mmbiz.qpic.cn/mmbiz_jpg/03UUuUr98GLmdrserzt625mLL1QmicDWUwzqYz3beia1dCeyYS39MUs5eqaHXu4IiawzXTt2icTiaoaGicSaEdKue38Q/0?wx_fmt=jpeg","_id":"59f028dc6e36a14449de11ed","userLogo":"http://mmbiz.qpic.cn/mmbiz/03UUuUr98GJicUZpZu49gtoM79CpK57jjqh64gyFcA90Ue89LbFOAqyuAaibQABibex2A5G7YnicS7o515U2NHT1vQ/0?wx_fmt=png","userName":"科普中国","read_num":0,"like_num":0,"typeId":"6","userLogo_code":"http://open.weixin.qq.com/qr/code/?username=Science_China"}],"currentPage":155,"allNum":3000,"maxResult":20}
         */

        private int ret_code;
        private PagebeanBean pagebean;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public PagebeanBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PagebeanBean pagebean) {
            this.pagebean = pagebean;
        }

        public static class PagebeanBean {
            /**
             * allPages : 150
             * contentlist : [{"date":"2017-10-25 12:48:01","ct":"2017-10-25 14:02:05.729","weixinNum":"zhxsbhw","url":"http://mp.weixin.qq.com/s?src=11&timestamp=1508911212&ver=473&signature=mP1D5OzTYJrrt*pn81-N0Wq8fIMvAsL3-gpa*cI92n-qQkMV18WMRBFX6dSWVwtvmZuCsVXUhF0ne5MpYlXx7kHRvtRH45RltlDJYPACKbt7moWlCBRtXyITFlMbdlS-&new=1","id":"57029655b9b5309bca5f2b8c022bdce5","typeName":"辣妈帮","title":"800万的房子算什么，你家熊孩子还不是照样没教养","contentImg":"http://mmbiz.qpic.cn/mmbiz_jpg/doe5wWMSjcarlctmgF3kxYfSeUrCkToPibebuFjsotlnAgwfvXYRkEic1BVtmV20IcNYzdYm9sJXyyab7f7NVEHw/0?wx_fmt=jpeg","_id":"59f028dd6e36a14449de11ee","userLogo":"http://mmbiz.qpic.cn/mmbiz/doe5wWMSjcbDCiaaH6aON4QH5ruTLFlamUpPVz1HDzaxxfGMIV9jzjTfryq0aqiaElK3tARD07GK3LchtqtD6XJg/0?wx_fmt=png","userName":"刑事法律圈","read_num":0,"like_num":0,"typeId":"11","userLogo_code":"http://open.weixin.qq.com/qr/code/?username=zhxsbhw"},{"date":"2017-10-25 06:59:26","ct":"2017-10-25 14:02:04.773","weixinNum":"Science_China","url":"http://mp.weixin.qq.com/s?src=11&timestamp=1508911207&ver=473&signature=WDOGeUlpl-XGmd9SHKO8NCQCSWjNombCb7UmgKRBd2kbkDQVA15MnSr5MMEyz2YcM1hdCOwUKEY2y-FWOAfqznalDmifFoMUp*rhUYhd30mjHaHwLARJjegVMF-IdSkQ&new=1","id":"05374745c3fee8e4b9650a4390ccc552","typeName":"爱生活","title":"早安！新闻来了丨2017年10月25日 星期三","contentImg":"http://mmbiz.qpic.cn/mmbiz_jpg/03UUuUr98GLmdrserzt625mLL1QmicDWUwzqYz3beia1dCeyYS39MUs5eqaHXu4IiawzXTt2icTiaoaGicSaEdKue38Q/0?wx_fmt=jpeg","_id":"59f028dc6e36a14449de11ed","userLogo":"http://mmbiz.qpic.cn/mmbiz/03UUuUr98GJicUZpZu49gtoM79CpK57jjqh64gyFcA90Ue89LbFOAqyuAaibQABibex2A5G7YnicS7o515U2NHT1vQ/0?wx_fmt=png","userName":"科普中国","read_num":0,"like_num":0,"typeId":"6","userLogo_code":"http://open.weixin.qq.com/qr/code/?username=Science_China"}]
             * currentPage : 155
             * allNum : 3000
             * maxResult : 20
             */

            private int allPages;
            private int currentPage;
            private int allNum;
            private int maxResult;
            private List<ContentlistBean> contentlist;

            public int getAllPages() {
                return allPages;
            }

            public void setAllPages(int allPages) {
                this.allPages = allPages;
            }

            public int getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(int currentPage) {
                this.currentPage = currentPage;
            }

            public int getAllNum() {
                return allNum;
            }

            public void setAllNum(int allNum) {
                this.allNum = allNum;
            }

            public int getMaxResult() {
                return maxResult;
            }

            public void setMaxResult(int maxResult) {
                this.maxResult = maxResult;
            }

            public List<ContentlistBean> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<ContentlistBean> contentlist) {
                this.contentlist = contentlist;
            }

            public static class ContentlistBean {
                /**
                 * date : 2017-10-25 12:48:01
                 * ct : 2017-10-25 14:02:05.729
                 * weixinNum : zhxsbhw
                 * url : http://mp.weixin.qq.com/s?src=11&timestamp=1508911212&ver=473&signature=mP1D5OzTYJrrt*pn81-N0Wq8fIMvAsL3-gpa*cI92n-qQkMV18WMRBFX6dSWVwtvmZuCsVXUhF0ne5MpYlXx7kHRvtRH45RltlDJYPACKbt7moWlCBRtXyITFlMbdlS-&new=1
                 * id : 57029655b9b5309bca5f2b8c022bdce5
                 * typeName : 辣妈帮
                 * title : 800万的房子算什么，你家熊孩子还不是照样没教养
                 * contentImg : http://mmbiz.qpic.cn/mmbiz_jpg/doe5wWMSjcarlctmgF3kxYfSeUrCkToPibebuFjsotlnAgwfvXYRkEic1BVtmV20IcNYzdYm9sJXyyab7f7NVEHw/0?wx_fmt=jpeg
                 * _id : 59f028dd6e36a14449de11ee
                 * userLogo : http://mmbiz.qpic.cn/mmbiz/doe5wWMSjcbDCiaaH6aON4QH5ruTLFlamUpPVz1HDzaxxfGMIV9jzjTfryq0aqiaElK3tARD07GK3LchtqtD6XJg/0?wx_fmt=png
                 * userName : 刑事法律圈
                 * read_num : 0
                 * like_num : 0
                 * typeId : 11
                 * userLogo_code : http://open.weixin.qq.com/qr/code/?username=zhxsbhw
                 */

                private String date;
                private String ct;
                private String weixinNum;
                private String url;
                private String id;
                private String typeName;
                private String title;
                private String contentImg;
                private String _id;
                private String userLogo;
                private String userName;
                private int read_num;
                private int like_num;
                private String typeId;
                private String userLogo_code;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getCt() {
                    return ct;
                }

                public void setCt(String ct) {
                    this.ct = ct;
                }

                public String getWeixinNum() {
                    return weixinNum;
                }

                public void setWeixinNum(String weixinNum) {
                    this.weixinNum = weixinNum;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTypeName() {
                    return typeName;
                }

                public void setTypeName(String typeName) {
                    this.typeName = typeName;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getContentImg() {
                    return contentImg;
                }

                public void setContentImg(String contentImg) {
                    this.contentImg = contentImg;
                }

                public String get_id() {
                    return _id;
                }

                public void set_id(String _id) {
                    this._id = _id;
                }

                public String getUserLogo() {
                    return userLogo;
                }

                public void setUserLogo(String userLogo) {
                    this.userLogo = userLogo;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public int getRead_num() {
                    return read_num;
                }

                public void setRead_num(int read_num) {
                    this.read_num = read_num;
                }

                public int getLike_num() {
                    return like_num;
                }

                public void setLike_num(int like_num) {
                    this.like_num = like_num;
                }

                public String getTypeId() {
                    return typeId;
                }

                public void setTypeId(String typeId) {
                    this.typeId = typeId;
                }

                public String getUserLogo_code() {
                    return userLogo_code;
                }

                public void setUserLogo_code(String userLogo_code) {
                    this.userLogo_code = userLogo_code;
                }
            }
        }
    }
}