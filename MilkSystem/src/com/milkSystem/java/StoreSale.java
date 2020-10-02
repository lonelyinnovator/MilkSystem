package com.milkSystem.java;

import java.util.ArrayList;
import java.util.Iterator;

public class StoreSale implements Iterable<Order> {
	private ArrayList<Order>orders;
	public StoreSale() {
		this.orders = new ArrayList<Order>();
	}
	public void addOrder(Order order) {
		this.orders.add(order);
	}
	public void removeOrder(Order order) {
		this.orders.remove(order);
	}
	public Order getOrder(int index) {
		return this.orders.get(index);
	}
	public int getNumberOfOrders() {
		return this.orders.size();
	}
	public Iterator<Order> iterator() {
		return this.orders.iterator();
	}

}
