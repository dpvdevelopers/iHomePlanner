package com.dpvdevelopers.ihomeplanner.Classes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

/**
 * This class manage the product object
 */
public class Product {

    private int id;
    private String name;
    private String barcode;
    private String detail;
    private float price;

    /**
     * Complete constructor
     * @param id This is the product id, int
     * @param name This is the product name, max length 45 characters
     * @param barcode This is the barcode, max length 50 characters
     * @param detail This is the product detail, max length 150 characters
     * @param price This is the product price, float
     */
    public Product(int id, String name, String barcode, String detail, float price) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.detail = detail;
        this.price = price;
    }
    public Product(String name, String detail) {
        this.id = 0;
        this.name = name;
        this.barcode = "";
        this.detail = detail;
        this.price = 0.0f;
    }
    public Product(Product p) {
        this.id = p.id;
        this.name = p.name;
        this.barcode = p.barcode;
        this.detail = p.detail;
        this.price = p.price;
    }
    public Product() {
        this.id = 0;
        this.name = "";
        this.barcode = "";
        this.detail = "";
        this.price = 0.0f;
    }

    /*
                        FIN CONSTRUCTORES
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    /*
                    FIN GETTERS AND SETTERS
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id &&
                barcode.equals(product.barcode);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, barcode);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                '}';
    }
}
