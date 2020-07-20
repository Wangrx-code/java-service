package com.pj.servlet.user;

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
import com.pj.service.UserService;
import com.pj.service.impl.ExchangeServiceImpl;
import com.pj.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	UserService userService=new UserServiceImpl();
	ExchangeService exchangeService=new ExchangeServiceImpl();
	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		String userType=request.getParameter("userType");
		
		userName=new String(userName.getBytes("iso-8859-1"),"utf-8");
		userType=new String(userType.getBytes("iso-8859-1"),"utf-8");
		
		User user=new User(userName,userPassword,userType);
		User userResult=userService.login(user);
		
		Exchange mostSoldGoods=exchangeService.MostGoods();
		
		if(userResult!=null && userResult.getUserPassword().equals(userPassword) && userResult.getUerType().equals(userType)){
			System.out.println("登录成功！");
			System.out.println("当前热门产品是"+mostSoldGoods.getGoodsName());
			List<Exchange> list=exchangeService.queryAllByUserName(userResult.getUserName());
			if(list.size()==0){
				System.out.println("该用户暂无交易信息！");
			}
			else{
				System.out.println("与该用户相关的交易订单信息如下：");
				for (Exchange exchange : list) {
					System.out.println("商家："+exchange.getSellerName()+"，买家："+exchange.getBuyerName()+"，商品："+exchange.getGoodsName()+"，数量："+exchange.getNum()+"，金额："+exchange.getMoney());
				}
				if(userResult.getUerType().equals("买家")){
					Exchange exchange=exchangeService.MostExchangeByUserId(userResult.getUserId(),userResult.getUerType());
					if(exchange!=null){			
						System.out.println("该买家购买"+exchange.getGoodsName()+"最多，支付金额共"+exchange.getMoney()+"元");
					}
				}
				if(userResult.getUerType().equals("商家")){
					Exchange exchange=exchangeService.MostExchangeByUserId(userResult.getUserId(),userResult.getUerType());
					if(exchange!=null){
						System.out.println("该卖家售出"+exchange.getGoodsName()+"最多，销售金额共"+exchange.getMoney()+"元");
					}
				}
			}
		}
		else{
			System.out.println("登录失败!");
		}
		JSONObject obj=JSONObject.fromObject(userResult);		//将结果转换成json键值对数据，供客户端可以获取
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
