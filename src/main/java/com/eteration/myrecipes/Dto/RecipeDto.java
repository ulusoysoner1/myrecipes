package com.eteration.myrecipes.Dto;

import com.eteration.myrecipes.Entity.User;

import java.util.Objects;

public class RecipeDto {

    private Integer recipeId;
    private String title;
    private String category;
    private Integer nop;
    private Integer cookingTime;
    private Integer cookingDegree;
    private String image;
    public User user;
    private UserDto userDto;

    public RecipeDto() {
    }

    public RecipeDto(String title, String category, Integer nop, Integer cookingTime, Integer cookingDegree, String image, User user, UserDto userDto) {
        this.title = title;
        this.category = category;
        this.nop = nop;
        this.cookingTime = cookingTime;
        this.cookingDegree = cookingDegree;
        this.image = image;
        this.user = user;
        this.userDto = userDto;
    }

    public RecipeDto(Integer recipeId) {
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeDto)) return false;
        RecipeDto recipeDto = (RecipeDto) o;
        return getRecipeId().equals(recipeDto.getRecipeId()) && getTitle().equals(recipeDto.getTitle()) && Objects.equals(getCategory(), recipeDto.getCategory()) && Objects.equals(getNop(), recipeDto.getNop()) && Objects.equals(getCookingTime(), recipeDto.getCookingTime()) && Objects.equals(getCookingDegree(), recipeDto.getCookingDegree()) && Objects.equals(getImage(), recipeDto.getImage()) && getUser().equals(recipeDto.getUser()) && getUserDto().equals(recipeDto.getUserDto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeId(), getTitle(), getCategory(), getNop(), getCookingTime(), getCookingDegree(), getImage(), getUser(), getUserDto());
    }

    @Override
    public String toString() {
        return "RecipeDto{" +
                "recipeId=" + recipeId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", nop=" + nop +
                ", cookingTime=" + cookingTime +
                ", cookingDegree=" + cookingDegree +
                ", image='" + image + '\'' +
                ", user=" + user +
                ", userDto=" + userDto +
                '}';
    }
}
