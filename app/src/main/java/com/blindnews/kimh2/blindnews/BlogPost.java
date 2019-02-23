package com.blindnews.kimh2.blindnews;

public class BlogPost {

    public String author, url, appAppBody, subTitle, title, date;

    public BlogPost() {}

    public BlogPost(String author, String url, String appAppBody, String subTitle, String title, String date) {
        this.author = author;
        this.url = url;
        this.appAppBody = appAppBody;
        this.subTitle = subTitle;
        this.title = title;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppBody() {
        return appAppBody;
    }

    public void setAppBody(String appAppBody) {
        this.appAppBody = appAppBody;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
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
}

