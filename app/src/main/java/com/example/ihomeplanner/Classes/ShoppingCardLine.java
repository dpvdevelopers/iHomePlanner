package com.example.ihomeplanner.Classes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class ShoppingCardLine {
    private double productId;
    private double shoppingCardId;
    private float quantity;
    /*
                            CONSTRUCTOR
     */

    public ShoppingCardLine(double productId, double shoppingCardId, float quantity) {
        this.productId = productId;
        this.shoppingCardId = shoppingCardId;
        this.quantity = quantity;
    }
    public ShoppingCardLine(ShoppingCardLine s) {
        this.productId = s.productId;
        this.shoppingCardId = s.shoppingCardId;
        this.quantity = s.quantity;
    }
    public ShoppingCardLine() {
        this.productId = 0;
        this.shoppingCardId = 0;
        this.quantity = 0;
    }
    /*
                                FIN CONSTRUCTORES
     */

    public double getProductId() {
        return productId;
    }

    public void setProductId(double productId) {
        this.productId = productId;
    }

    public double getShoppingCardId() {
        return shoppingCardId;
    }

    public void setShoppingCardId(double shoppingCardId) {
        this.shoppingCardId = shoppingCardId;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCardLine)) return false;
        ShoppingCardLine that = (ShoppingCardLine) o;
        return Double.compare(that.productId, productId) == 0 &&
                Double.compare(that.shoppingCardId, shoppingCardId) == 0 &&
                Float.compare(that.quantity, quantity) == 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(productId, shoppingCardId, quantity);
    }

    @Override
    public String toString() {
        return  "productId=" + productId +
                ", shoppingCardId=" + shoppingCardId +
                ", quantity=" + quantity
                ;
    }
}
