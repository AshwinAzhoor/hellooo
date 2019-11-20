package com.ust.beans;

import java.util.Date;



public class Sales {
	
	private int pId;
	private String pName;
	private int pDId;
	private String pCost;
	private Date screatedDate;
	private int orderId;
	private int quantity;
	private int totalost;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpDId() {
		return pDId;
	}
	public void setpDId(int pDId) {
		this.pDId = pDId;
	}
	public String getpCost() {
		return pCost;
	}
	public void setpCost(String pCost) {
		this.pCost = pCost;
	}
	public Date getScreatedDate() {
		return screatedDate;
	}
	public void setScreatedDate(Date screatedDate) {
		this.screatedDate = screatedDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public Sales(int pId, String pName) {
		super();
		this.pId = pId;
		this.pName = pName;
	}
	public Sales(String pName) {
		super();
		this.pName = pName;
	}
	public Sales(int pId, int pDId, String pCost, Date screatedDate) {
		super();
		this.pId = pId;
		this.pDId = pDId;
		this.pCost = pCost;
		this.screatedDate = screatedDate;
	}
	public Sales(int pId, String pCost, Date screatedDate) {
		super();
		this.pId = pId;
		this.pCost = pCost;
		this.screatedDate = screatedDate;
	}
	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sales(String pName, String pCost, int orderId, int quantity,
			int totalCost) {
		super();
		this.pName = pName;
		this.pCost = pCost;
		this.orderId = orderId;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}
	public Sales(String pName, String pCost, int quantity, int totalCost) {
		super();
		this.pName = pName;
		this.pCost = pCost;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "Sales [pId=" + pId + ", pName=" + pName + ", pDId=" + pDId
				+ ", pCost=" + pCost + ", screatedDate=" + screatedDate
				+ ", orderId=" + orderId + ", quantity=" + quantity
				+ ", totalCost=" + totalCost + "]";
	}
	
	
	
	
	
	
	

}
