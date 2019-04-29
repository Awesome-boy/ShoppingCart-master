package com.kx.elemeapplication.model;

import androidx.annotation.DrawableRes;

import java.util.ArrayList;

/**
 *
 */
public class DishMenu {
    private String menuName;
    private ArrayList<Dish> dishList;
    private int mResId;

    public DishMenu(){

    }

    public DishMenu(String menuName, ArrayList dishList, @DrawableRes int resId){
        this.menuName = menuName;
        this.dishList = dishList;
        mResId = resId;
    }

    public ArrayList<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(ArrayList<Dish> dishList) {
        this.dishList = dishList;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getResId() {
        return mResId;
    }

    public void setResId(int resId) {
        mResId = resId;
    }
}
