package org.vtgroup.littlelovely.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int giftID;

    private String name;
    private int point;
    private int stock;
    private String image;
    private boolean active;

    // n-n (additional attributes) order-gift
    @OneToMany(mappedBy = "gift")
    private List<GiftIncluding> giftIncludings;

    public int getGiftID() {
        return giftID;
    }

    public void setGiftID(int giftID) {
        this.giftID = giftID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<GiftIncluding> getGiftIncludings() {
        return giftIncludings;
    }

    public void setGiftIncludings(List<GiftIncluding> giftIncludings) {
        this.giftIncludings = giftIncludings;
    }
}
