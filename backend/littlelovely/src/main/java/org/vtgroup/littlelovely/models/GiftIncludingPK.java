package org.vtgroup.littlelovely.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GiftIncludingPK implements Serializable {
    private int giftID;
    private int ordID;

    public int getGiftID() {
        return giftID;
    }

    public void setGiftID(int giftID) {
        this.giftID = giftID;
    }

    public int getOrdID() {
        return ordID;
    }

    public void setOrdID(int ordID) {
        this.ordID = ordID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftIncludingPK that = (GiftIncludingPK) o;
        return giftID == that.giftID && ordID == that.ordID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(giftID, ordID);
    }
}
