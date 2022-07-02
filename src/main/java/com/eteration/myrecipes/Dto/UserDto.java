package com.eteration.myrecipes.Dto;

import java.util.Objects;


public class UserDto {

    private Integer userId;
    private String username;
    private String title;
    private String category;
    private String image;

    public UserDto() {
    }

    public UserDto(String username, String title, String category, String image) {
        this.username = username;
        this.title = title;
        this.category = category;
        this.image = image;
    }

    public UserDto(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return getUserId().equals(userDto.getUserId()) && getUsername().equals(userDto.getUsername()) && getTitle().equals(userDto.getTitle()) && getCategory().equals(userDto.getCategory()) && getImage().equals(userDto.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername(), getTitle(), getCategory(), getImage());
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
