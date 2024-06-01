package org.vtgroup.littlelovely.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandID;

    private String name;
    private String logo;

    // 1-n brand-product
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Product> products;

    // n-n brand-category
    @ManyToMany
    @JoinTable(name = "Brand_Specializing", joinColumns = @JoinColumn(name = "brandID"), inverseJoinColumns = @JoinColumn(name = "catID"))
    private List<Category> categories;

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
