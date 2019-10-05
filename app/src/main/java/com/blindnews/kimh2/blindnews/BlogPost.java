package com.blindnews.kimh2.blindnews;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlogPost {

    public String author, url, appAppBody, subTitle, title, date;
    public Date dateDate;

    public BlogPost() {}

    public BlogPost(String author, String url, String appAppBody, String subTitle, String title, String date) {
        this.author = author;
        this.url = url;
        this.appAppBody = appAppBody;
        this.subTitle = subTitle;
        this.title = title;
        this.date = date;

        String[] months = {"January",
                "February",
                "March",
                "April",
                "May",
                "July",
                "June",
                "August",
                "September",
                "October",
                "November",
                "December"};

        String[] tokens = date.split("\\s+"); // split date string by space
        int day = Integer.parseInt(tokens[0]);
        int month = -1;
        for (int i = 0; i < 12; i++) {
            if (tokens[1].equals(months[i])) {
                month = i+1;
                break;
            }
        }


        int year = Integer.parseInt(tokens[2]);
        if (month < 0) throw new IllegalStateException("Given a month that does not exist: " + tokens[1]);
        this.dateDate = new Date(year - 1900, month, day);


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

    public Date getDateDate() {return dateDate;}
}

