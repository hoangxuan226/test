package org.vtgroup.littlelovely.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Product_Review")
public class ProductReview {

    @EmbeddedId
    private ProductReviewPK id;

    // n-n (additional attributes) product-customer
    @ManyToOne
    @MapsId("prodID")
    @JoinColumn(name = "prodID")
    private Product product;

    // n-n (additional attributes) product-customer
    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    private User customer;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    private String image;
    private int star;

    public ProductReviewPK getId() {
        return id;
    }

    public void setId(ProductReviewPK id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
