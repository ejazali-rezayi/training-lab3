package com.lab3.assetlab3.asset2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Asset2Service {
	
	@Autowired  
	Asset2RepoInterface asset2RepoInterface;
	
	//getting all books record by using the method findaAll() of CrudRepository  
	public List<Asset2> getAllAssets() {
		List<Asset2> ls = new ArrayList<Asset2>();
		asset2RepoInterface.findAll().forEach(a -> ls.add(a));
		return ls;  
	}
	
	public List<Asset2> getAssetByType(String type) {
		List<Asset2> ls = new ArrayList<Asset2>();  
		asset2RepoInterface.findAll().forEach(a -> {if(a.getType().equalsIgnoreCase(type)) ls.add(a);});  
		return ls;  
	}
	
	public List<Asset2> getAssetByName(String name) {
		List<Asset2> ls = new ArrayList<Asset2>();  
		asset2RepoInterface.findAll().forEach(a -> {if(a.getType().equalsIgnoreCase(name)) ls.add(a);});  
		return ls;  
	}
	
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Asset2 asset2) {
		asset2RepoInterface.save(asset2);  
	}  
	
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(long id) {
		asset2RepoInterface.deleteById(id);  
	}
	
	//updating a record  
	public void update(Asset2 asset2, int bookid) {
		asset2RepoInterface.save(asset2);  
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
	
}  