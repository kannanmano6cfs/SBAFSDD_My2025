package com.learning.exproductservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    int prdid;
    String prdname;
    String prdprice;
    String prddesc;
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
