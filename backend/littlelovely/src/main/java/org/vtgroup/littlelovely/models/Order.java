package org.vtgroup.littlelovely.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "[Order]")  // Escaping the table name
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordID;

    private Date date;
    private String status;

    private int totalQuantity;
    private double totalPrice;
    private double finalPrice;
    private String trackingCode;

    // n-n (additional attributes) order-product
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    // n-n (additional attributes) order-gift
    @OneToMany(mappedBy = "order")
    private List<GiftIncluding> giftIncludings;

    // 1-n voucher-order
    @ManyToOne
    @JoinColumn(name = "voucherID")
    private Voucher voucher;

    // 1-n customer-order
    @ManyToOne
    @JoinColumn(name = "username")
    private User customer;

    public int getOrdID() {
        return ordID;
    }

    public void setOrdID(int ordID) {
        this.ordID = ordID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<GiftIncluding> getGiftIncludings() {
        return giftIncludings;
    }

    public void setGiftIncludings(List<GiftIncluding> giftIncludings) {
        this.giftIncludings = giftIncludings;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
