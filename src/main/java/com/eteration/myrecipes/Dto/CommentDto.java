package com.eteration.myrecipes.Dto;


import com.eteration.myrecipes.Entity.Recipe;
import com.eteration.myrecipes.Entity.User;

import java.util.Objects;

public class CommentDto {
    private Integer commentId;
    private String title;
    private String text;
    private Recipe recipe;
    private User user;

    public CommentDto() {

    }

    public CommentDto(String title, String text, Recipe recipe, User user) {
        this.title = title;
        this.text = text;
        this.recipe = recipe;
        this.user = user;
    }

    public CommentDto(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentDto)) return false;
        CommentDto that = (CommentDto) o;
        return getCommentId().equals(that.getCommentId()) && getTitle().equals(that.getTitle()) && getText().equals(that.getText()) && getRecipe().equals(that.getRecipe()) && getUser().equals(that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommentId(), getTitle(), getText(), getRecipe(), getUser());
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "commentId=" + commentId +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", recipe=" + recipe +
                ", user=" + user +
                '}';
    }
}
