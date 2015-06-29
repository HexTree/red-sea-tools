package kaust.orientationapp;

/**
 * Created by uchman21 on 6/24/15.
 */

public class Plist {

    private String url;
    private String title;
    private String date;
    private int size;
    private int num;
    private int color;
    //private String size;
    private String items1;
    private String items2;
    private String items3;
    

    public String url() {
        return url;
    }

    public void seturl(String url) {
        this.url = url;
    }

    public String title() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public int getsize() {
        return size;
    }

    public void setsize(int size) {
        this.size = size;
    }

    public int getnum() {
        return num;
    }

    public void setnum(int num) {
        this.num = num;
    }

    public int getcolor() {
        return color;
    }

    public void setcolor(int color) {
        this.color = color;
    }

    public String getitems1() {
        return items1;
    }

    public void setitems1(String items1) {
        this.items1 = items1;
    }
    public String getitems2() {
        return items2;
    }

    public void setitems2(String items2) {
        this.items2 = items2;
    }

    public String getitems3() {
        return items3;
    }

    public void setitems3(String items3) {
        this.items3 = items3;
    }

    @Override
    public String toString() {
        return "[ title =" + title + ", description =" + " , date=" + date + "]";
    }
}
