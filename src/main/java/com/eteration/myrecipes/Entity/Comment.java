package com.eteration.myrecipes.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Integer commentId;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_recipes_id", referencedColumnName = "recipe_id")
    private Recipe recipe;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_users_id", referencedColumnName = "user_id")
    private User user;

    public Comment() {
    }

    public Comment(String title, String text, Recipe recipe, User user) {
        this.title = title;
        this.text = text;
        this.recipe = recipe;
        this.user = user;
    }

    public Comment(Integer commentId) {
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
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return getCommentId().equals(comment.getCommentId()) && Objects.equals(getTitle(), comment.getTitle()) && Objects.equals(getText(), comment.getText()) && Objects.equals(getRecipe(), comment.getRecipe()) && Objects.equals(getUser(), comment.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommentId(), getTitle(), getText(), getRecipe(), getUser());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", recipe=" + recipe +
                ", user=" + user +
                '}';
    }
}

