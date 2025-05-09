package com.learning.exorderservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="orders")
public class Order {

    @Id
    @GeneratedValue
    int orderid;
    int prdid;
    String prdname;
    int orderqty;

    public Order() {
    }

    public Order(int orderid, int prdid, String prdname, int orderqty) {
        this.orderid = orderid;
        this.prdid = prdid;
        this.prdname = prdname;
        this.orderqty = orderqty;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
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

    public int getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(int orderqty) {
        this.orderqty = orderqty;
    }
}
