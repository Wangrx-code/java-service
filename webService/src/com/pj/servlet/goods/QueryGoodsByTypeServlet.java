package com.pj.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.pj.entity.Exchange;
import com.pj.entity.Goods;
import com.pj.service.GoodsService;
import com.pj.service.impl.GoodsServiceImpl;

public class QueryGoodsByTypeServlet extends HttpServlet {
	GoodsService goodsService=new GoodsServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public QueryGoodsByTypeServlet() {
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

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		String goodsType=request.getParameter("goodsType");
		goodsType=new String(goodsType.getBytes("iso-8859-1"),"utf-8");
		List<Goods> list=goodsService.queryByType(goodsType);
		System.out.println("所有"+goodsType+"类型的商品信息如下：");
		for (Goods goodsItem : list) {
			System.out.println("名称："+goodsItem.getGoodsName()+"，价格："+goodsItem.getGoodsPrice()+"，状态："+goodsItem.getIsSale()+"，类型："+goodsItem.getGoodsType());
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
