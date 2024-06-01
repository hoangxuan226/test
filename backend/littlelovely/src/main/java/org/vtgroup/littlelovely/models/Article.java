package org.vtgroup.littlelovely.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artID;

    private String title;
    private Date date;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ElementCollection
    @CollectionTable(name = "Article_Image", joinColumns = @JoinColumn(name = "artID"))
    private List<String> images;

    // n-n product-article
    @ManyToMany(mappedBy = "articles")
    private List<Product> products;

    private boolean active;

    public int getArtID() {
        return artID;
    }

    public void setArtID(int artID) {
        this.artID = artID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
