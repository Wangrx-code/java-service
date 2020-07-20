package com.pj.servlet.exchange;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


import com.pj.entity.Exchange;
import com.pj.entity.Goods;
import com.pj.entity.User;
import com.pj.service.ExchangeService;
import com.pj.service.GoodsService;
import com.pj.service.UserService;
import com.pj.service.impl.ExchangeServiceImpl;
import com.pj.service.impl.GoodsServiceImpl;
import com.pj.service.impl.UserServiceImpl;

public class AddExchangeServlet extends HttpServlet {
	ExchangeService exchangeService=new ExchangeServiceImpl();
	GoodsService goodsService=new GoodsServiceImpl();
	UserService userService=new UserServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public AddExchangeServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String goodsName=request.getParameter("goodsName");
		String buyerName=request.getParameter("buyerName");
		String sellerName=request.getParameter("sellerName");
		String num=request.getParameter("num");
//		String money=request.getParameter("money");
		
		goodsName=new String(goodsName.getBytes("iso-8859-1"),"utf-8");
		buyerName=new String(buyerName.getBytes("iso-8859-1"),"utf-8");
		sellerName=new String(sellerName.getBytes("iso-8859-1"),"utf-8");
		
		Goods goods=goodsService.queryByName(goodsName);
		User buyer=userService.queryByName(buyerName);
		User seller=userService.queryByName(sellerName);
		List<Exchange> list=exchangeService.queryAll();
		System.out.println("原订单列表：");
		for (Exchange exchange : list) {
			System.out.println("商家："+exchange.getSellerName()+"，买家："+exchange.getBuyerName()+"，商品："+exchange.getGoodsName()+"，数量："+exchange.getNum()+"，金额："+exchange.getMoney());
		}
		Exchange exchange=new Exchange(goods.getGoodsId(),buyer.getUserId(),seller.getUserId(),Integer.parseInt(num),Integer.parseInt(num)*goods.getGoodsPrice());
		exchange=exchangeService.Add(exchange);
		if(exchange!=null){
			System.out.println("交易添加成功");
			List<Exchange> newlist=exchangeService.queryAll();
			System.out.println("新订单列表：");
			for (Exchange exchange1 : newlist) {
				System.out.println("商家："+exchange1.getSellerName()+"，买家："+exchange1.getBuyerName()+"，商品："+exchange1.getGoodsName()+"，数量："+exchange1.getNum()+"，金额："+exchange1.getMoney());
			}
			JSONObject userResult=JSONObject.fromObject(exchange);
		}
		else{
			System.out.println("添加失败");
		}
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
