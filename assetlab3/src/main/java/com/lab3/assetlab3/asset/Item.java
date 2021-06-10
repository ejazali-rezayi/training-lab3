package com.lab3.assetlab3.asset;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="Item")
@Cacheable
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class Item implements Asset {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
	@Column(name="name")
    String name;
	@Column(name="category")
    String category;
	@Column(name="posX")
    int posX;
	@Column(name="posY")
    int posY;
	@Column(name="posZ")
    int posZ;
	@Column(name="inspectiondate")
    LocalDate inspectionDate;
	@Column(name="price")
    double price;

    public Item(String name, int posX, int posY, int posZ, LocalDate inspectionDate, double price) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.inspectionDate = inspectionDate;
        this.price = price;
    }

    public String getType() {
    	return "Item";
    }
    
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosZ() {
        return posZ;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPosZ(int posZ) {
        this.posZ = posZ;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item asset = (Item) o;
        return posX == asset.posX &&
                posY == asset.posY &&
                posZ == asset.posZ &&
                Double.compare(asset.price, price) == 0 &&
                Objects.equals(name, asset.name) &&
                Objects.equals(inspectionDate, asset.inspectionDate);
    }

    public String toString() {
        return "\nItem{" +
                "name=" + name +
                ", category=" + category +
                ", posX=" + posX +
                ", posY=" + posY +
                ", posZ=" + posZ +
                ", inspectionDate=" + inspectionDate +
                ", price=" + price +
                "}";
    }
}
