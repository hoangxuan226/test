package org.vtgroup.littlelovely.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Gift_Including")
public class GiftIncluding {

    @EmbeddedId
    private GiftIncludingPK id;

    // n-n (additional attributes) order-gift
    @ManyToOne
    @MapsId("ordID")
    @JoinColumn(name = "ordID")
    private Order order;

    // n-n (additional attributes) order-gift
    @ManyToOne
    @MapsId("giftID")
    @JoinColumn(name = "giftID")
    private Gift gift;

    private int quantity;
    private int point;

    public GiftIncludingPK getId() {
        return id;
    }

    public void setId(GiftIncludingPK id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
