package org.vtgroup.littlelovely.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailPK implements Serializable {
    private int ordID;
    private int prodID;

    public int getOrdID() {
        return ordID;
    }

    public void setOrdID(int ordID) {
        this.ordID = ordID;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailPK that = (OrderDetailPK) o;
        return ordID == that.ordID && prodID == that.prodID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordID, prodID);
    }
}
