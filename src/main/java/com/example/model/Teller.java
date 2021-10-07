package com.example.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teller")
public class Teller {
	@Id
	private int id;
	private int fifty;
	private int twenty;
	private int ten;
	private int five;
	private double total;
	
	public Teller() {
		
	}
	
	public Teller(int id, int fifty, int twenty, int ten, int five, double total) {
		super();
		this.id = id;
		this.fifty = fifty;
		this.twenty = twenty;
		this.ten = ten;
		this.five = five;
		this.total = total;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getFifty() {
		return fifty;
	}
	
	public void setFifty(int fifty) {
		this.fifty = fifty;
	}
	public int getTwenty() {
		return twenty;
	}
	public void setTwenty(int twenty) {
		this.twenty = twenty;
	}
	public int getTen() {
		return ten;
	}
	public void setTen(int ten) {
		this.ten = ten;
	}
	public int getFive() {
		return five;
	}
	public void setFive(int five) {
		this.five = five;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}
