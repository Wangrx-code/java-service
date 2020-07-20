package com.pj.service;

import java.util.List;

import com.pj.entity.Goods;

public interface GoodsService {
	public Goods Add(Goods goods);
	public int delete(int id);
	public Goods Modify(Goods goods);
	public List<Goods> queryByType(String goodsType);
	public List<Goods> queryAll();
	public Goods queryByName(String goodsName);
}
