package com.pj.servlet.exchange;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.pj.entity.Exchange;
import com.pj.service.ExchangeService;
import com.pj.service.impl.ExchangeServiceImpl;

public class DeleExchangeServlet extends HttpServlet {
	ExchangeService exchangeServive=new ExchangeServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public DeleExchangeServlet() {
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
		
		List<Exchange> list=exchangeServive.queryAll();
		System.out.println("原订单列表：");
		for (Exchange exchange : list) {
			System.out.println("商家："+exchange.getSellerName()+"，买家："+exchange.getBuyerName()+"，商品："+exchange.getGoodsName()+"，数量："+exchange.getNum()+"，金额："+exchange.getMoney());
		}
		String exchangeId=request.getParameter("exchangeId");
		int deleResult=exchangeServive.Delete(Integer.parseInt(exchangeId));
		if(deleResult!=0){
			JSONObject res=JSONObject.fromObject(deleResult);
			System.out.println("删除成功");
			List<Exchange> newlist=exchangeServive.queryAll();
			System.out.println("新订单列表：");
			for (Exchange exchange : newlist) {
				System.out.println("商家："+exchange.getSellerName()+"，买家："+exchange.getBuyerName()+"，商品："+exchange.getGoodsName()+"，数量："+exchange.getNum()+"，金额："+exchange.getMoney());
			}
		}
		else{
			System.out.println("删除失败");
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
