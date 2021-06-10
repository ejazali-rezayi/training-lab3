package com.lab3.assetlab3.asset2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
 
@Component
public class DataInit implements ApplicationRunner {
 
    private Asset2RepoInterface asset2RepoInterface;
 
    @Autowired
    public DataInit(Asset2RepoInterface asset2RepoInterface) {
        this.asset2RepoInterface = asset2RepoInterface;
    }
 
    @Override
    public void run(ApplicationArguments args) throws Exception {
        
    	Scanner input;
        try {
            input = new Scanner(new File("/home/rezayiejazali/eclipse-workspace/assetlab3/assets2.txt"));
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
                asset2RepoInterface.save(new Asset2(type, name, category, posX, posY, posZ, LocalDate.parse(inspectionDate), price));
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
    }
     
}