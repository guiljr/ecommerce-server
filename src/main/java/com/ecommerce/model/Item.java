package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Entity
@Table(name ="item")
public class Item {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    @JsonProperty("itemName")
    @Column(name = "item_name", nullable = false, unique = true)
    @Length(min = 3, message = "*Name must have at least 5 characters")
    private String itemName;
    @JsonProperty("image_url")
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @JsonProperty("description")
    @Column(name = "description", nullable = false)
    private String description;
    @JsonProperty("itemType")
    @Column(name = "item_type", nullable = true)
    private String itemType;
    @JsonProperty("price")
    @Column(name = "unit_price", nullable = false)
    @DecimalMin(value = "0.00", message = "*Price has to be non negative number")
    private double unitPrice;
    @Column(name = "quantity", nullable = true)
    @Min(value = 0, message = "*Quantity has to be non negative number")
    private Integer quantity;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
