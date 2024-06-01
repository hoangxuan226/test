package org.vtgroup.littlelovely.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Order_Detail")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailPK id;

    // n-n (additional attributes) order-product
    @ManyToOne
    @MapsId("ordID")
    @JoinColumn(name = "ordID")
    private Order order;

    // n-n (additional attributes) order-product
    @ManyToOne
    @MapsId("prodID")
    @JoinColumn(name = "prodID")
    private Product product;

    private int quantity;
    private double price;

    public OrderDetailPK getId() {
        return id;
    }

    public void setId(OrderDetailPK id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
