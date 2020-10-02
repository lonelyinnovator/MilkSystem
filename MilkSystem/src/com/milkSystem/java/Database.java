package com.milkSystem.java;

import javax.swing.*;
import java.util.Date;

public class Database {
	private UserList userList;
	private ProductCatalog productCatalog;
	public Database(){
		userList = new UserList();
		Date date = new Date();
		Jelly j1 = new Jelly("J456", "jelly", 1.5f, date, "six months", "Chocolate");
		Jelly j2 = new Jelly("J432", "jelly", 1.5f, date, "six months", "Milk");
		Yogurt y1 = new Yogurt("Y534", "yogurt", 3.0f, date, "two days", "pure", "100%");
		Yogurt y2 = new Yogurt("Y0636", "yogurt", 2.5f, date, "two days", "pure", "90%");
		Yogurt y3 = new Yogurt("Y566", "yogurt", 2.0f, date, "two days", "pure", "80%");
		PureMilk p1 = new PureMilk("P555","PureMilk", 5.4f, date, "one day" , "England", "10%", "100%");
		PureMilk p2 = new PureMilk("P182","PureMilk", 5.3f, date, "one day" , "England", "10%", "90%");
		MilkDrink m1 = new MilkDrink("M565", "MilkDrink", 9.2f, date, "one day", "Chocolate", "30%");
		MilkDrink m2 = new MilkDrink("M895", "MilkDrink", 9.2f, date, "one day", "Apple", "30%");
		MilkDrink m3 = new MilkDrink("M666", "MilkDrink", 666f, date, "one day", "Lemon", "666%");
		SaleItem saleItem1 = new SaleItem(j1, 1);
		SaleItem saleItem2 = new SaleItem(y1, 1);
		SaleItem saleItem3 = new SaleItem(p2, 1);
		SaleItem saleItem4 = new SaleItem(m1, 1);
		SaleItem saleItem5 = new SaleItem(y3, 1);
		SaleItem saleItem6 = new SaleItem(j2, 1);
		SaleItem saleItem7 = new SaleItem(y2, 1);
		SaleItem saleItem8 = new SaleItem(m2, 1);
		SaleItem saleItem9 = new SaleItem(p1, 1);
		SaleItem saleItem10 = new SaleItem(m3, 1);
		productCatalog = new ProductCatalog();
		productCatalog.addProduct(saleItem1.getProduct());
		productCatalog.addProduct(saleItem2.getProduct());
		productCatalog.addProduct(saleItem3.getProduct());
		productCatalog.addProduct(saleItem4.getProduct());
		productCatalog.addProduct(saleItem5.getProduct());
		productCatalog.addProduct(saleItem6.getProduct());
		productCatalog.addProduct(saleItem7.getProduct());
		productCatalog.addProduct(saleItem8.getProduct());
		productCatalog.addProduct(saleItem9.getProduct());
		productCatalog.addProduct(saleItem10.getProduct());
		User user1 = new User("root","root","root@localhost", null);
		userList.addUser(user1);
	}
	public UserList getUserList(){
		return userList;
	}

	public ProductCatalog getProductCatalog(){
		return productCatalog;
	}
	public static void main(String[] args) {
		Database database = new Database();
		LogFrame logFrame = new LogFrame(database.getUserList(), database.getProductCatalog());
		logFrame.setVisible(true);
		logFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
