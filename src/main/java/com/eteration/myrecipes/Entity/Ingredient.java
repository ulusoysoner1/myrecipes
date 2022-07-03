package com.eteration.myrecipes.Entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ing_id")
    private Integer ingId;
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipes_id", referencedColumnName = "recipe_id")
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String description, Recipe recipe) {
        this.description = description;
        this.recipe = recipe;
    }

    public Ingredient(Integer ingId) {
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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return getIngId().equals(that.getIngId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getRecipe(), that.getRecipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngId(), getDescription(), getRecipe());
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingId=" + ingId +
                ", description='" + description + '\'' +
                ", recipe=" + recipe +
                '}';
    }
}
