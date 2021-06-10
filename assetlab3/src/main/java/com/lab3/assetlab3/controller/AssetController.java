package com.lab3.assetlab3.controller;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab3.assetlab3.asset2.Asset2;
import com.lab3.assetlab3.asset2.Asset2Service;

@Controller
public class AssetController {
	
	@Autowired
	Asset2Service asset2Service = new Asset2Service();
	
	@RequestMapping("/display")
	public String showPage(Model model) {
		model.addAttribute("asset", asset2Service.getAllAssets());
		return "display";
	}
	
	@RequestMapping("/addItem")
	public String addItem() {
		return "addItem";
	}
	
	@RequestMapping("/addComponent")
	public String addComponent() {
		return "addComponent";
	}
	
	@RequestMapping("/addItemToAssets")
	public String addItemToAssets(HttpServletRequest request) {
		String name=request.getParameter("name");
		String category=request.getParameter("category").toUpperCase();
		String posX=request.getParameter("posX");
		String posY=request.getParameter("posY");
		String posZ=request.getParameter("posZ");
		String inspectionDate=request.getParameter("inspectionDate");
		String price=request.getParameter("price");
		asset2Service.saveOrUpdate(new Asset2("Item", name, category, Integer.parseInt(posX), Integer.parseInt(posY), Integer.parseInt(posZ), LocalDate.parse(inspectionDate), Double.valueOf(price)));
		asset2Service.addToFile("Item", name, category.toUpperCase(), posX, posY, posZ, inspectionDate, price);
		return "redirect:/display";
	}
	
	@RequestMapping("/addComponentToAssets")
	public String addComponentToAssets(HttpServletRequest request) {
		String name=request.getParameter("name");
		String category=request.getParameter("category").toUpperCase();
		String posX=request.getParameter("posX");
		String posY=request.getParameter("posY");
		String posZ=request.getParameter("posZ");
		String inspectionDate=request.getParameter("inspectionDate");
		String price=request.getParameter("price");
		asset2Service.saveOrUpdate(new Asset2("Component", name, category, Integer.parseInt(posX), Integer.parseInt(posY), Integer.parseInt(posZ), LocalDate.parse(inspectionDate), Double.valueOf(price)));
		asset2Service.addToFile("Component", name, category.toUpperCase(), posX, posY, posZ, inspectionDate, price);
		return "redirect:/display";
	}
	
	@RequestMapping("/searchType")
	public String searchType() {
		return "searchType";
	}
	
	@RequestMapping("/searchName")
	public String searchName() {
		return "searchName";
	}
	
	@RequestMapping("/displayType")
	public String displayType(HttpServletRequest request, Model model) {
		String type=request.getParameter("type");
		model.addAttribute("asset", asset2Service.getAssetByType(type));
		return "displayType";
	}
	
	@RequestMapping("/displayName")
	public String displayName(HttpServletRequest request, Model model) {
		String name=request.getParameter("name");
		model.addAttribute("asset", asset2Service.getAssetByName(name));
		return "displayName";
	}
}
