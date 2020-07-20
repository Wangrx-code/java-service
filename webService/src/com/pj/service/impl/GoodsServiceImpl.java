package com.pj.service.impl;

import java.util.List;

import com.pj.dao.GoodsDao;
import com.pj.dao.impl.GoodsDaoImpl;
import com.pj.entity.Goods;
import com.pj.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{
	GoodsDao goodsDao=new GoodsDaoImpl();
	@Override
	public Goods Add(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.Add(goods);
	}

	@Override
	public Goods Modify(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.Modify(goods);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return goodsDao.delete(id);
	}

	@Override
	public List<Goods> queryAll() {
		// TODO Auto-generated method stub
		return goodsDao.queryAll();
	}

	@Override
	public List<Goods> queryByType(String goodsType) {
		// TODO Auto-generated method stub
		return goodsDao.queryByType(goodsType);
	}

	@Override
	public Goods queryByName(String goodsName) {
		// TODO Auto-generated method stub
		return goodsDao.queryByName(goodsName);
	}

}
