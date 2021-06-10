package com.lab3.assetlab3.decorator;

import java.time.LocalDate;

import com.lab3.assetlab3.asset.Asset;

public class TankAssetDecorator extends AssetDecorator {

    public TankAssetDecorator(Asset decoratedAsset) {
        super(decoratedAsset);
        decoratedAsset.setCategory("TANK");
    }

    public String getType() {
		return decoratedAsset.getType();
	}
    
    public String getName() {
        return decoratedAsset.getName();
    }

    public String getCategory() {
        return decoratedAsset.getCategory();
    }

    public int getPosX() {
        return decoratedAsset.getPosX();
    }

    public int getPosY() {
        return decoratedAsset.getPosY();
    }

    public int getPosZ() {
        return decoratedAsset.getPosZ();
    }

    public LocalDate getInspectionDate() {
        return decoratedAsset.getInspectionDate();
    }

    public double getPrice() {
        return decoratedAsset.getPrice();
    }

    public void setName(String name) {
        this.setName(name);
    }

    public void setCategory(String category) {
        this.setCategory(category);
    }

    public void setPosX(int posX) {
        this.setPosX(posX);
    }

    public void setPosY(int posY) {
        this.setPosY(posY);
    }

    public void setPosZ(int posZ) {
        this.setPosZ(posZ);
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.setInspectionDate(inspectionDate);
    }

    public void setPrice(double price) {
        this.setPrice(price);
    }
}
