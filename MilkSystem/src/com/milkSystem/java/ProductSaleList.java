package com.milkSystem.java;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductSaleList implements Iterable<SaleItem> {
	private ArrayList<SaleItem>saleitems;
	public ProductSaleList() {
		this.saleitems = new ArrayList<SaleItem>();
	}
	public void addSaleItem(SaleItem saleItem) {
		this.saleitems.add(saleItem);
	}
	public void removeSaleItem(SaleItem saleItem) {
		this.saleitems.remove(saleItem);
	}
	public SaleItem getSaleItem(Product product) {
		for(SaleItem saleItem : this.saleitems) {
			if(saleItem.getProduct().equals(product)) {
				return saleItem;
			} 
		}
		return null;
	}
	public SaleItem getSaleItem(int index) {
		return this.saleitems.get(index);
	}
	public int getNumberOfItems() {
		return this.saleitems.size();
	}
	public float getTotalCost() {
		float cost = 0;
		for(SaleItem saleItem : this.saleitems) {
			cost += saleItem.getProduct().getPrice() * saleItem.getQuantity();
		}
		return cost;
	}
	public Iterator<SaleItem> iterator() {
		return this.saleitems.iterator();
	}
	
}
