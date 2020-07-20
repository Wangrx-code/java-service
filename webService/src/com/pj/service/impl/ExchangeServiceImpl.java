package com.pj.service.impl;

import java.util.List;

import com.pj.dao.ExchangeDao;
import com.pj.dao.impl.ExchangeDaoImpl;
import com.pj.entity.Exchange;
import com.pj.service.ExchangeService;

public class ExchangeServiceImpl implements ExchangeService{
	ExchangeDao exchangeDao=new ExchangeDaoImpl();
	@Override
	public Exchange Add(Exchange exchange) {
		// TODO Auto-generated method stub
		return exchangeDao.Add(exchange);
	}

	@Override
	public int Delete(int echangeId) {
		// TODO Auto-generated method stub
		return exchangeDao.Delete(echangeId);
	}

	@Override
	public Exchange Modify(Exchange exchange) {
		// TODO Auto-generated method stub
		return exchangeDao.Modify(exchange);
	}

	@Override
	public List<Exchange> queryAll() {
		// TODO Auto-generated method stub
		return exchangeDao.queryAll();
	}

	@Override
	public List<Exchange> queryAllByUserName(String userName) {
		// TODO Auto-generated method stub
		return exchangeDao.queryAllByUserName(userName);
	}

	@Override
	public Exchange MostExchangeByUserId(int userId,String userType) {
		// TODO Auto-generated method stub
		return exchangeDao.MostExchangeByUserId(userId,userType);
	}

	@Override
	public Exchange MostGoods() {
		// TODO Auto-generated method stub
		return exchangeDao.MostGoods();
	}

}
