package com.kx.elemeapplication.model;

import androidx.annotation.DrawableRes;

/**
 *
 */
public class Dish {

    private String dishName;
    private double dishPrice;
    private int dishAmount;
    private int dishRemain;
    private int mResId;

    public Dish(String dishName,double dishPrice,int dishAmount){
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishAmount = dishAmount;
        this.dishRemain = dishAmount;
    }

    public Dish(String dishName, double dishPrice, int dishAmount, @DrawableRes int resId){
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishAmount = dishAmount;
        this.dishRemain = dishAmount;
        mResId = resId;
    }


    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public int getDishAmount() {
        return dishAmount;
    }

    public void setDishAmount(int dishAmount) {
        this.dishAmount = dishAmount;
    }

    public int getDishRemain() {
        return dishRemain;
    }

    public void setDishRemain(int dishRemain) {
        this.dishRemain = dishRemain;
    }

    public int getResId() {
        return mResId;
    }

    public void setResId(int resId) {
        mResId = resId;
    }

    public int hashCode(){
        int code = this.dishName.hashCode()+(int)this.dishPrice;
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this)return true;

        return obj instanceof Dish &&
                this.dishName.equals(((Dish)obj).dishName) &&
                this.dishPrice ==  ((Dish)obj).dishPrice &&
                this.dishAmount == ((Dish)obj).dishAmount &&
                this.mResId == ((Dish)obj).mResId &&
                this.dishRemain == ((Dish)obj).dishRemain;
    }
}
