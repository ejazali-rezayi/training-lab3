package com.lab3.assetlab3.asset;

import java.time.LocalDate;

public interface Asset {

	String getType();
	
    String getName();

    String getCategory();

    int getPosX();

    int getPosY();

    int getPosZ();

    LocalDate getInspectionDate();

    double getPrice();

    void setName(String name);

    void setCategory(String category);

    void setPosX(int poxX);

    void setPosY(int posY);

    void setPosZ(int posZ);

    void setInspectionDate(LocalDate inspectionDate);

    void setPrice(double price);

    String toString();
}
