package com.Otaku.Blog.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
@Document(collection = "product")
public class product {
    @Id
    private String id;
    @Field(name = "name")
    @Indexed(unique = true)
    private String productName;
    @Field(name="category")
    private Category productcategory;
    @Field(name = "amount")
    private BigDecimal productAmount;

    public product(String id, String productName, Category productcategory, BigDecimal productAmount) {
        this.id = id;
        this.productName = productName;
        this.productcategory = productcategory;
        this.productAmount = productAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(Category productcategory) {
        this.productcategory = productcategory;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }
}
