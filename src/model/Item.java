package model;

import java.io.Serializable;

public class Item  implements Serializable {
	Integer id;
	String Itemno;
	String Itemname;
	Integer Cost;
	Integer Price;
	String Factoryno;
	Integer Qty;
	
	public Item(String itemno, String itemname, Integer cost, Integer price, String factoryno, Integer qty) {
		super();
		Itemno = itemno;
		Itemname = itemname;
		Cost = cost;
		Price = price;
		Factoryno = factoryno;
		Qty = qty;
	}

	public Item() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemno() {
		return Itemno;
	}

	public void setItemno(String itemno) {
		Itemno = itemno;
	}

	public String getItemname() {
		return Itemname;
	}

	public void setItemname(String itemname) {
		Itemname = itemname;
	}

	public Integer getCost() {
		return Cost;
	}

	public void setCost(Integer cost) {
		Cost = cost;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

	public String getFactoryno() {
		return Factoryno;
	}

	public void setFactoryno(String factoryno) {
		Factoryno = factoryno;
	}

	public Integer getQty() {
		return Qty;
	}

	public void setQty(Integer qty) {
		Qty = qty;
	}

	
	

}
