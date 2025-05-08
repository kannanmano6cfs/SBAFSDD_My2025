package com.learning.exproductservice.Model;

import com.learning.exproductservice.utility.ValidName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Product {

    @Id
    @GeneratedValue
    int prdid;
    @ValidName
    String prdname;
    @NotEmpty(message="Product Price is required")
    String prdprice;
    @NotEmpty(message="Product Description is required")
    String prddesc;
    @PositiveOrZero(message="Count should in zero or any positive")
    int count;

    public Product() {
    }

    public Product(int prdid, String prdname, String prdprice, String prddesc, int count) {
        this.prdid = prdid;
        this.prdname = prdname;
        this.prdprice = prdprice;
        this.prddesc = prddesc;
        this.count = count;
    }

    public int getPrdid() {
        return prdid;
    }

    public void setPrdid(int prdid) {
        this.prdid = prdid;
    }

    public String getPrdname() {
        return prdname;
    }

    public void setPrdname(String prdname) {
        this.prdname = prdname;
    }

    public String getPrdprice() {
        return prdprice;
    }

    public void setPrdprice(String prdprice) {
        this.prdprice = prdprice;
    }

    public String getPrddesc() {
        return prddesc;
    }

    public void setPrddesc(String prddesc) {
        this.prddesc = prddesc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
