package com.eteration.myrecipes.Dto;

import java.util.Objects;

public class IngredientDto {

    private Integer ingId;
    private String description;
    private Integer recipesId;

    public IngredientDto() {
    }

    public IngredientDto(String description, Integer recipesId) {
        this.description = description;
        this.recipesId = recipesId;
    }

    public IngredientDto(Integer ingId) {
        this.ingId = ingId;
    }

    public Integer getIngId() {
        return ingId;
    }

    public void setIngId(Integer ingId) {
        this.ingId = ingId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRecipesId() {
        return recipesId;
    }

    public void setRecipesId(Integer recipesId) {
        this.recipesId = recipesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngredientDto)) return false;
        IngredientDto that = (IngredientDto) o;
        return getIngId().equals(that.getIngId()) && getDescription().equals(that.getDescription()) && getRecipesId().equals(that.getRecipesId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngId(), getDescription(), getRecipesId());
    }

    @Override
    public String toString() {
        return "IngredientDto{" +
                "ingId=" + ingId +
                ", description='" + description + '\'' +
                ", recipesId=" + recipesId +
                '}';
    }
}
