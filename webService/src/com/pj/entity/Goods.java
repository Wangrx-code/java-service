package com.pj.entity;

public class Goods {
	private int goodsId;
	private String goodsName;
	private int goodsPrice;
	private String goodsType;
	private String isSale;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getIsSale() {
		return isSale;
	}
	public void setIsSale(String isSale) {
		this.isSale = isSale;
	}
	public Goods() {
		super();
	}
	
	public Goods(int goodsId, String goodsName, int goodsPrice,
			String goodsType, String isSale) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsType = goodsType;
		this.isSale = isSale;
	}
	public Goods(String goodsName, int goodsPrice, String goodsType,
			String isSale) {
		super();
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsType = goodsType;
		this.isSale = isSale;
	}
	public Goods(String goodsName) {
		super();
		this.goodsName = goodsName;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", goodsType=" + goodsType
				+ ", isSale=" + isSale + "]";
	}
	
	
}
