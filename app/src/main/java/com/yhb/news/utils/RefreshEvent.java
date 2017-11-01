package com.yhb.news.utils;

/**
 * Created by Administrator on 2017/10/29.
 */

public class RefreshEvent {
    public int getTabPosition() {
        return tabPosition;
    }

    public void setTabPosition(int tabPosition) {
        this.tabPosition = tabPosition;
    }

    private int tabPosition;

    public RefreshEvent(int tabPosition) {
        this.tabPosition = tabPosition;
    }
}
