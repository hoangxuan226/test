package org.vtgroup.littlelovely.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vouID;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private double discountRate;
    private double maxDiscount;
    private double discountPrice;
    private Date expiry;
    private int stock;
    private boolean active;

    // 1-n voucher-order
    @OneToMany(mappedBy = "voucher", cascade = CascadeType.ALL)
    private List<Order> orders;

    // n-n customer-voucher
    @ManyToMany
    @JoinTable(name = "Voucher_Availability", joinColumns = @JoinColumn(name = "vouID"), inverseJoinColumns = @JoinColumn(name = "username"))
    private List<User> customers;

    public int getVouID() {
        return vouID;
    }

    public void setVouID(int vouID) {
        this.vouID = vouID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<User> getCustomers() {
        return customers;
    }

    public void setCustomers(List<User> customers) {
        this.customers = customers;
    }
}
