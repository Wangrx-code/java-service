package com.pj.service;

import java.util.List;

import com.pj.entity.Exchange;

public interface ExchangeService {
	public Exchange Add(Exchange exchange);
	public Exchange Modify(Exchange exchange);
	public int Delete(int echangeId);
	public List<Exchange> queryAll();
	public List<Exchange> queryAllByUserName(String userName);
	public Exchange MostExchangeByUserId(int userId,String userType);
	public Exchange MostGoods();
}
