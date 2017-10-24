package com.android.raspberyl.myquizz.model;

/**
 * Created by Raspberyl on 12/10/2017.
 */

public class User {
    private String mUserName;

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    @Override
    public String toString() {
        return "User{" +
                "mUserName='" + mUserName + '\'' +
                '}';
    }
}
