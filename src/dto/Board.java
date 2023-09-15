package dto;

import java.util.Date;

public class Board {
    private int num;
    private String title;
    private String content;
    private int viewCnt;
    private User writer;
    private Date date;

    public Board() {
        // TODO Auto-generated constructor stub
    }

    public Board(String title, String content, User writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = new Date();
        this.viewCnt = 0;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Board [num=" + num + ", title=" + title + ", content=" + content + ", viewCnt=" + viewCnt + ", writer="
                + writer + ", date=" + date + "]";
    }

}
