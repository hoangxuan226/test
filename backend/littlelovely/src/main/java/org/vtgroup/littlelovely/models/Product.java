package org.vtgroup.littlelovely.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodID;

    private String name;
    private double price;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int noSold;
    private int stock;
    private boolean active;

    // multivalued attribute 'images'
    @ElementCollection
    @CollectionTable(name = "Product_Image", joinColumns = @JoinColumn(name = "prodID"))
    private List<String> images;

    // 1-n brand-product
    @ManyToOne
    @JoinColumn(name = "brandID")
    private Brand brand;

    // n-n product-category
    @ManyToMany
    @JoinTable(name = "Product_Category", joinColumns = @JoinColumn(name = "prodID"), inverseJoinColumns = @JoinColumn(name = "catID"))
    private List<Category> categories;

    // n-n product-article
    @ManyToMany
    @JoinTable(name = "Product_Featuring", joinColumns = @JoinColumn(name = "prodID"), inverseJoinColumns = @JoinColumn(name = "artID"))
    private List<Article> articles;

    // n-n (additional attributes) order-product
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    // n-n (additional attributes) product-customer
    @OneToMany(mappedBy = "product")
    private List<ProductReview> productReviews;

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoSold() {
        return noSold;
    }

    public void setNoSold(int noSold) {
        this.noSold = noSold;
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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<ProductReview> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(List<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }
}
