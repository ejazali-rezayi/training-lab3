package com.lab3.assetlab3.repository;

import java.util.List;

import com.lab3.assetlab3.asset.Asset;

public interface AssetRepositoryDAO {

    public List<Asset> getAllAssets();

    public void updateAsset(Asset asset);

    public void deleteAsset(Asset asset);
}
