package org.vtgroup.littlelovely.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "[User]")
public class User {

    @Id
    private String username;

    private String password;
    private String role;
    private String name;
    private String mail;
    private String phone;

    private int point;

    // n-n (additional attributes) product-customer
    @OneToMany(mappedBy = "customer")
    private List<ProductReview> productReviews;

    // 1-n customer-order
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    // n-n customer-voucher
    @ManyToMany(mappedBy = "customers")
    private List<Voucher> vouchers;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public List<ProductReview> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(List<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }
}
