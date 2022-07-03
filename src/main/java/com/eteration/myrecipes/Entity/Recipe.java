package com.eteration.myrecipes.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id")
    private Integer recipeId;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
    @Column(name = "nop")
    private Integer nop;
    @Column(name = "cooking_time")
    private Integer cookingTime;
    @Column(name = "cooking_degree")
    private Integer cookingDegree;
    @Column(name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user",referencedColumnName = "user_id")
    public User user;

    public Recipe() {
    }

    public Recipe(String title, String category, Integer nop, Integer cookingTime, Integer cookingDegree, String image, User user) {
        this.title = title;
        this.category = category;
        this.nop = nop;
        this.cookingTime = cookingTime;
        this.cookingDegree = cookingDegree;
        this.image = image;
        this.user = user;
    }

    public Recipe(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNop() {
        return nop;
    }

    public void setNop(Integer nop) {
        this.nop = nop;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Integer getCookingDegree() {
        return cookingDegree;
    }

    public void setCookingDegree(Integer cookingDegree) {
        this.cookingDegree = cookingDegree;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return getRecipeId().equals(recipe.getRecipeId()) && Objects.equals(getTitle(), recipe.getTitle()) && Objects.equals(getCategory(), recipe.getCategory()) && Objects.equals(getNop(), recipe.getNop()) && Objects.equals(getCookingTime(), recipe.getCookingTime()) && Objects.equals(getCookingDegree(), recipe.getCookingDegree()) && Objects.equals(getImage(), recipe.getImage()) && getUser().equals(recipe.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeId(), getTitle(), getCategory(), getNop(), getCookingTime(), getCookingDegree(), getImage(), getUser());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", nop=" + nop +
                ", cookingTime=" + cookingTime +
                ", cookingDegree=" + cookingDegree +
                ", image='" + image + '\'' +
                ", user=" + user +
                '}';
    }
}


