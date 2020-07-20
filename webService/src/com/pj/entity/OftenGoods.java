package com.pj.entity;

public class OftenGoods {
	private int OftenGoodsId;
	private String OftenGoodsName;
	private int OftenGoodsPrice;
	public int getOftenGoodsId() {
		return OftenGoodsId;
	}
	public void setOftenGoodsId(int oftenGoodsId) {
		OftenGoodsId = oftenGoodsId;
	}
	public String getOftenGoodsName() {
		return OftenGoodsName;
	}
	public void setOftenGoodsName(String oftenGoodsName) {
		OftenGoodsName = oftenGoodsName;
	}
	public int getOftenGoodsPrice() {
		return OftenGoodsPrice;
	}
	public void setOftenGoodsPrice(int oftenGoodsPrice) {
		OftenGoodsPrice = oftenGoodsPrice;
	}
	public OftenGoods() {
		super();
	}
	public OftenGoods(int oftenGoodsId, String oftenGoodsName,
			int oftenGoodsPrice) {
		super();
		OftenGoodsId = oftenGoodsId;
		OftenGoodsName = oftenGoodsName;
		OftenGoodsPrice = oftenGoodsPrice;
	}
	@Override
	public String toString() {
		return "OftenGoods [OftenGoodsId=" + OftenGoodsId + ", OftenGoodsName="
				+ OftenGoodsName + ", OftenGoodsPrice=" + OftenGoodsPrice + "]";
	}
	
}
