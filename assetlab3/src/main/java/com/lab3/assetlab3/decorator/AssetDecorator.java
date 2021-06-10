package com.lab3.assetlab3.decorator;

import com.lab3.assetlab3.asset.Asset;

public abstract class AssetDecorator implements Asset {
    protected Asset decoratedAsset;

    public AssetDecorator(Asset decoratedAsset) {
        this.decoratedAsset = decoratedAsset;
    }

    public String toString() {
        return decoratedAsset.toString();
    }
}
