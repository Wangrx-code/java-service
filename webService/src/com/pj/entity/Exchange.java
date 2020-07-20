package com.pj.entity;

public class Exchange {
	private int exchangeId;
	private int goodsId;
	private int buyerId;
	private int sellerId;
	private int num;
	private int money;
	private String buyerName;
	private String sellerName;
	private String goodsName;
	private String goodsType;
	private int goodsPrice;
	
	
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getExchangeId() {
		return exchangeId;
	}
	public void setExchangeId(int exchangeId) {
		this.exchangeId = exchangeId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
	public Exchange() {
		super();
	}
	public Exchange(int goodsId, int buyerId, int sellerId, int num, int money) {
		super();
		this.goodsId = goodsId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.num = num;
		this.money = money;
	}
	
	public Exchange(int num, int money, String buyerName, String sellerName,
			String goodsName) {
		super();
		this.num = num;
		this.money = money;
		this.buyerName = buyerName;
		this.sellerName = sellerName;
		this.goodsName = goodsName;
	}
	
	
	
	public Exchange(String goodsName) {
		super();
		this.goodsName = goodsName;
	}
	public Exchange(int num, int money, String goodsName) {
		super();
		this.num = num;
		this.money = money;
		this.goodsName = goodsName;
	}
	@Override
	public String toString() {
		return "Exchange [buyerName=" + buyerName + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", goodsType=" + goodsType
				+ ", money=" + money + ", num=" + num + ", sellerName="
				+ sellerName + "]";
	}
	
	
	
}

