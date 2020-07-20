package com.pj.service.impl;

import java.util.List;

import com.pj.dao.OftenGoodsDao;
import com.pj.dao.impl.OftenGoodsDaoImpl;
import com.pj.entity.OftenGoods;
import com.pj.service.OftenGoodsService;

public class OftenGoodsServiceImpl implements OftenGoodsService{
	OftenGoodsDao oftenGoodsDao=new OftenGoodsDaoImpl();
	@Override
	public List<OftenGoods> queryAll() {
		// TODO Auto-generated method stub
		return oftenGoodsDao.queryAll();
	}

}
