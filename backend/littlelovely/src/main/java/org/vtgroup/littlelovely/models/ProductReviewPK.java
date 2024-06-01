package org.vtgroup.littlelovely.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductReviewPK implements Serializable {
    private int prodID;
    private String username;

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductReviewPK that = (ProductReviewPK) o;
        return prodID == that.prodID && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodID, username);
    }
}
