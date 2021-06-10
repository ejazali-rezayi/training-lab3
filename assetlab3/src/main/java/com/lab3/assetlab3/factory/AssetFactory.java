package com.lab3.assetlab3.factory;

import java.time.LocalDate;

import com.lab3.assetlab3.asset.Asset;
import com.lab3.assetlab3.asset.Component;
import com.lab3.assetlab3.asset.Item;

public class AssetFactory {
    public Asset buildAsset(String assetType, String name, int posX, int posY, int posZ, LocalDate inspectionDate, double price) {
        if (assetType == null) {
            return null;
        }
        if (assetType.equalsIgnoreCase("item")) {
            return new Item(name, posX, posY, posZ, inspectionDate, price);
        } else if (assetType.toLowerCase() == "component") {
            return new Component(name, posX, posY, posZ, inspectionDate, price);
        }
        return null;
    }

    private static AssetFactory assetFactory;

    private AssetFactory() {
    }

    public static AssetFactory getInstance() {
        if (assetFactory == null) {
            assetFactory = new AssetFactory();
        }
        return assetFactory;
    }
}
