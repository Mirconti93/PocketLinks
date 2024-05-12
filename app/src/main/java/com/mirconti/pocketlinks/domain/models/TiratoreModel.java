package com.mirconti.pocketlinks.domain.models;

import com.mircontapp.sportalbum.domain.models.CategoryModel;

public class TiratoreModel{
    CategoryModel categoryModel;
    boolean hasShot;
    boolean gol;
    boolean selected;

    public TiratoreModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
        hasShot = false;
        gol = false;
    }

    public CategoryModel getPlayerModel() {
        return categoryModel;
    }

    public void setPlayerModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public boolean isHasShot() {
        return hasShot;
    }

    public void setHasShot(boolean hasShot) {
        this.hasShot = hasShot;
    }

    public boolean isGol() {
        return gol;
    }

    public void setGol(boolean gol) {
        this.gol = gol;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
