package com.pj.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.pj.entity.Goods;
import com.pj.entity.OftenGoods;
import com.pj.service.OftenGoodsService;
import com.pj.service.impl.OftenGoodsServiceImpl;

public class QueryOftenGoods extends HttpServlet {
	OftenGoodsService oftenGoodsService=new OftenGoodsServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public QueryOftenGoods() {
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

		doPost(request,response);
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

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		List<OftenGoods> list=oftenGoodsService.queryAll();
		System.out.println("������Ʒ��Ϣ���£�");
		for (OftenGoods goodsItem : list) {
		System.out.println("ID��"+goodsItem.getOftenGoodsId()+"�����ƣ�"+goodsItem.getOftenGoodsName()+"���۸�"+goodsItem.getOftenGoodsPrice());
		}
		JSONArray array=JSONArray.fromObject(list);
//		System.out.println(array);
		PrintWriter out = response.getWriter();
		
		out.println(array.toString());
		out.flush();
		out.close();
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
