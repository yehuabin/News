package com.yhb.news.model;

import java.util.List;

/**
 * Created by smk on 2017/10/25.
 */

public class MeiTuModel {

    private String sidebarSortBySelected;
    private String sidebarSortOrderSelected;
    private String sortBy;
    private String sortOrder;
    private String nextPage;
    private List<ResultsBean> results;

    public String getSidebarSortBySelected() {
        return sidebarSortBySelected;
    }

    public void setSidebarSortBySelected(String sidebarSortBySelected) {
        this.sidebarSortBySelected = sidebarSortBySelected;
    }

    public String getSidebarSortOrderSelected() {
        return sidebarSortOrderSelected;
    }

    public void setSidebarSortOrderSelected(String sidebarSortOrderSelected) {
        this.sidebarSortOrderSelected = sidebarSortOrderSelected;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * img_id : MSG8LPKDGR
         * tags : Norway,  forest,  mountian,  bridge,  travel,  photo,  color,  amazing,  relax
         * page_views : 470
         * downloads : 95
         * favorites : 6
         * img_width : 6000
         * img_height : 4000
         * adjustedWidth : 420
         * favorited : false
         */

        private String img_id;
        private String tags;
        private String page_views;
        private String downloads;
        private String favorites;
        private int img_width;
        private int img_height;
        private String adjustedWidth;
        private boolean favorited;

        public String getImg_id() {
            return img_id;
        }

        public void setImg_id(String img_id) {
            this.img_id = img_id;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getPage_views() {
            return page_views;
        }

        public void setPage_views(String page_views) {
            this.page_views = page_views;
        }

        public String getDownloads() {
            return downloads;
        }

        public void setDownloads(String downloads) {
            this.downloads = downloads;
        }

        public String getFavorites() {
            return favorites;
        }

        public void setFavorites(String favorites) {
            this.favorites = favorites;
        }

        public int getImg_width() {
            return img_width;
        }

        public void setImg_width(int img_width) {
            this.img_width = img_width;
        }

        public int getImg_height() {
            return img_height;
        }

        public void setImg_height(int img_height) {
            this.img_height = img_height;
        }

        public String getAdjustedWidth() {
            return adjustedWidth;
        }

        public void setAdjustedWidth(String adjustedWidth) {
            this.adjustedWidth = adjustedWidth;
        }

        public boolean isFavorited() {
            return favorited;
        }

        public void setFavorited(boolean favorited) {
            this.favorited = favorited;
        }
    }
}

