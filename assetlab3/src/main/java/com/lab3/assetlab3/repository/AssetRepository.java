package com.lab3.assetlab3.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.lab3.assetlab3.asset.Asset;
import com.lab3.assetlab3.asset.Component;
import com.lab3.assetlab3.asset.Item;
import com.lab3.assetlab3.decorator.PipeAssetDecorator;
import com.lab3.assetlab3.decorator.TankAssetDecorator;
import com.lab3.assetlab3.decorator.ValveAssetDecorator;
import com.lab3.assetlab3.observer.Observer;
import com.lab3.assetlab3.observer.Subject;

public class AssetRepository implements Subject, AssetRepositoryDAO {

    private static AssetRepository assetRepository;
    private static List<Asset> assets;
    private List<Observer> observers = new ArrayList<>();

    private AssetRepository() {
        Scanner input;
        try {
            input = new Scanner(new File("/home/rezayiejazali/eclipse-workspace/assetlab3/assets.txt"));
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
                if(type.equalsIgnoreCase("Item")) {
	                if (category.equalsIgnoreCase("Pipe")) {
	                    assets.add(new PipeAssetDecorator(new Item(name, posX, posY, posZ, LocalDate.parse(inspectionDate), price)));
	                } else if (category.equalsIgnoreCase("Tank")) {
	                    assets.add(new TankAssetDecorator(new Item(name, posX, posY, posZ, LocalDate.parse(inspectionDate), price)));
	                } else if (category.equalsIgnoreCase("Valve")) {
	                    assets.add(new ValveAssetDecorator(new Item(name, posX, posY, posZ, LocalDate.parse(inspectionDate), price)));
	                }
                } else {
                	if (category.equalsIgnoreCase("Pipe")) {
	                    assets.add(new PipeAssetDecorator(new Component(name, posX, posY, posZ, LocalDate.parse(inspectionDate), price)));
	                } else if (category.equalsIgnoreCase("Tank")) {
	                    assets.add(new TankAssetDecorator(new Component(name, posX, posY, posZ, LocalDate.parse(inspectionDate), price)));
	                } else if (category.equalsIgnoreCase("Valve")) {
	                    assets.add(new ValveAssetDecorator(new Component(name, posX, posY, posZ, LocalDate.parse(inspectionDate), price)));
	                }
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static AssetRepository getInstance() {
        if (assetRepository == null) {
            assetRepository = new AssetRepository();
            System.out.print("AssetRepository instance created");
        }
        assetRepository.notifyUpdate("The instance of asset repository has been called");
        return assetRepository;
    }

    public List<Asset> getAssets() {
        return assets;
    }
    
    public List<Asset> getAssetByType(String type) {
    	List<Asset> ls = new ArrayList<>();
    	for (Asset a:assets) {
    		if(a.getType().equalsIgnoreCase(type))
    			ls.add(a);
    	}
    	return ls;
    }
    
    public List<Asset> getAssetByName(String name) {
    	List<Asset> ls = new ArrayList<>();
    	for (Asset a:assets) {
    		if(a.getName().toLowerCase().contains(name.toLowerCase()))
    			ls.add(a);
    	}
    	return ls;
    }

    public int size() {
        return assets.size();
    }

    public Asset getAt(int index) {
        return assets.get(index);
    }

    public Asset getAsset(String name) {
        for (Asset asset : assets) {
            if (asset.getName().equals(name)) {
                return asset;
            }
        }
        return null;
    }

    public void showLowerPriceThan(double min) {
        Iterator<Asset> iterator = assets.listIterator();
        while (iterator.hasNext()) {
            Asset a = iterator.next();
            if (a.getPrice() < min) {
                System.out.println(a);
            }
        }
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyUpdate(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    @Override
    public List<Asset> getAllAssets() {
        return assets;
    }

    @Override
    public void updateAsset(Asset asset) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAsset(Asset asset) {
        // TODO Auto-generated method stub

    }
    
    public void addItem(String name, String category, int posX, int posY, int posZ, LocalDate inspectionDate, double price) {
    	if (category.equalsIgnoreCase("Pipe")) {
            assets.add(new PipeAssetDecorator(new Item(name, posX, posY, posZ, inspectionDate, price)));
        } else if (category.equalsIgnoreCase("Tank")) {
            assets.add(new TankAssetDecorator(new Item(name, posX, posY, posZ, inspectionDate, price)));
        } else if (category.equalsIgnoreCase("Valve")) {
            assets.add(new ValveAssetDecorator(new Item(name, posX, posY, posZ, inspectionDate, price)));
        }
    }
    
    public void addComponent(String name, String category, int posX, int posY, int posZ, LocalDate inspectionDate, double price) {
    	if (category.equalsIgnoreCase("Pipe")) {
            assets.add(new PipeAssetDecorator(new Component(name, posX, posY, posZ, inspectionDate, price)));
        } else if (category.equalsIgnoreCase("Tank")) {
            assets.add(new TankAssetDecorator(new Component(name, posX, posY, posZ, inspectionDate, price)));
        } else if (category.equalsIgnoreCase("Valve")) {
            assets.add(new ValveAssetDecorator(new Component(name, posX, posY, posZ, inspectionDate, price)));
        }
    }
    
    public void addToFile(String type, String name, String category, String posX, String posY, String posZ, String inspectionDate, String price) {
    	try
    	{
    	    String filename= "/home/rezayiejazali/eclipse-workspace/assetlab3/assets.txt";
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
        for (Asset asset : assets) {
            allAssets+=asset.toString();
        }
        return allAssets;
    }
}
