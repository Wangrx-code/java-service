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
			System.out.println("��¼�ɹ���");
			System.out.println("��ǰ���Ų�Ʒ��"+mostSoldGoods.getGoodsName());
			List<Exchange> list=exchangeService.queryAllByUserName(userResult.getUserName());
			if(list.size()==0){
				System.out.println("���û����޽�����Ϣ��");
			}
			else{
				System.out.println("����û���صĽ��׶�����Ϣ���£�");
				for (Exchange exchange : list) {
					System.out.println("�̼ң�"+exchange.getSellerName()+"����ң�"+exchange.getBuyerName()+"����Ʒ��"+exchange.getGoodsName()+"��������"+exchange.getNum()+"����"+exchange.getMoney());
				}
				if(userResult.getUerType().equals("���")){
					Exchange exchange=exchangeService.MostExchangeByUserId(userResult.getUserId(),userResult.getUerType());
					if(exchange!=null){			
						System.out.println("����ҹ���"+exchange.getGoodsName()+"��֧࣬����"+exchange.getMoney()+"Ԫ");
					}
				}
				if(userResult.getUerType().equals("�̼�")){
					Exchange exchange=exchangeService.MostExchangeByUserId(userResult.getUserId(),userResult.getUerType());
					if(exchange!=null){
						System.out.println("�������۳�"+exchange.getGoodsName()+"��࣬���۽�"+exchange.getMoney()+"Ԫ");
					}
				}
			}
		}
		else{
			System.out.println("��¼ʧ��!");
		}
		JSONObject obj=JSONObject.fromObject(userResult);		//�����ת����json��ֵ�����ݣ����ͻ��˿��Ի�ȡ
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
