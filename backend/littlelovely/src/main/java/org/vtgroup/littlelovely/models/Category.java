package org.vtgroup.littlelovely.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catID;

    private String name;

    // n-n product-category
    @ManyToMany(mappedBy = "categories")
    private List<Product> products;

    // self referencing n-1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentID")
    private Category parent;

    // self referencing n-1
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> subCategories;

    // n-n brand-category
    @ManyToMany(mappedBy = "categories")
    private List<Brand> brands;

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }
}
