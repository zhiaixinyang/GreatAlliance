package com.greatalliance.model.bean;

/**
 * Created by 谷 聪聪 on 2017/7/18 0018.
 */

public class SharerBean  {
    private int articleCover;
    private int authorHead;
    private String articleTitle;
    private String addOfArticle;
    private String authorNick;

    public SharerBean(int articleCover, String articleTitle, int authorHead
            , String addOfArticle, String authorNick) {
        this.articleCover = articleCover;
        this.articleTitle = articleTitle;
        this.authorHead = authorHead;
        this.addOfArticle = addOfArticle;
        this.authorNick = authorNick;
    }

    public int getAuthorHead() {
        return authorHead;
    }

    public void setAuthorHead(int authorHead) {
        this.authorHead = authorHead;
    }


    public int getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(int articleCover) {
        this.articleCover = articleCover;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getAddOfArticle() {
        return addOfArticle;
    }

    public void setAddOfArticle(String addOfArticle) {
        this.addOfArticle = addOfArticle;
    }

    public String getAuthorNick() {
        return authorNick;
    }

    public void setAuthorNick(String authorNick) {
        this.authorNick = authorNick;
    }
}
