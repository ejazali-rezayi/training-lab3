package com.lab3.assetlab3.asset2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AssetRepository2 {

    private static AssetRepository2 assetRepository;
    private static List<Asset2> assets;
    

    private AssetRepository2() {
        Scanner input;
        try {
            input = new Scanner(new File("/home/rezayiejazali/eclipse-workspace/assetlab3/assets2.txt"));
            assets = new ArrayList<>();
            String type;
            String name;
            String category;
            int posX;
            int posY;
            int posZ;
            String inspectionDate;
            double price;
            while (input.hasNext()) {
            	type = input.next();
                name = input.next();
                category = input.next();
                posX = input.nextInt();
                posY = input.nextInt();
                posZ = input.nextInt();
                inspectionDate = input.next();
                price = input.nextDouble();
	            assets.add(new Asset2(type, name, category, posX, posY, posZ, LocalDate.parse(inspectionDate), price));
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static AssetRepository2 getInstance() {
        if (assetRepository == null) {
            assetRepository = new AssetRepository2();
            System.out.print("AssetRepository2 instance created");
        }
        return assetRepository;
    }

    public List<Asset2> getAssets() {
        return assets;
    }
    
    public List<Asset2> getAssetByType(String type) {
    	List<Asset2> ls = new ArrayList<>();
    	for (Asset2 a:assets) {
    		if(a.getType().equalsIgnoreCase(type))
    			ls.add(a);
    	}
    	return ls;
    }
    
    public List<Asset2> getAssetByName(String name) {
    	List<Asset2> ls = new ArrayList<>();
    	for (Asset2 a:assets) {
    		if(a.getName().toLowerCase().contains(name.toLowerCase()))
    			ls.add(a);
    	}
    	return ls;
    }

    public int size() {
        return assets.size();
    }

    public Asset2 getAt(int index) {
        return assets.get(index);
    }

    public Asset2 getAsset(String name) {
        for (Asset2 asset : assets) {
            if (asset.getName().equals(name)) {
                return asset;
            }
        }
        return null;
    }

    public void showLowerPriceThan(double min) {
        Iterator<Asset2> iterator = assets.listIterator();
        while (iterator.hasNext()) {
            Asset2 a = iterator.next();
            if (a.getPrice() < min) {
                System.out.println(a);
            }
        }
    }
    
    public void addItem(String name, String category, int posX, int posY, int posZ, LocalDate inspectionDate, double price) {
    	assets.add(new Asset2("Item", name, category, posX, posY, posZ, inspectionDate, price));
    }
    
    public void addComponent(String name, String category, int posX, int posY, int posZ, LocalDate inspectionDate, double price) {
    	assets.add(new Asset2("Component", name, category, posX, posY, posZ, inspectionDate, price));
    }
    
    public void addToFile(String type, String name, String category, String posX, String posY, String posZ, String inspectionDate, String price) {
    	try
    	{
    	    String filename= "/home/rezayiejazali/eclipse-workspace/assetlab3/assets2.txt";
    	    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
    	    fw.write("\n"+type +" "+ name +" "+ category +" "+ posX +" "+ posY +" "+ posZ +" "+ inspectionDate +" "+ price);//appends the string to the file
    	    fw.close();
    	}
    	catch(IOException ioe)
    	{
    	    System.err.println("IOException: " + ioe.getMessage());
    	}
    }

    public String toString() {
        String allAssets = "";
        for (Asset2 asset : assets) {
            allAssets+=asset.toString();
        }
        return allAssets;
    }
}
