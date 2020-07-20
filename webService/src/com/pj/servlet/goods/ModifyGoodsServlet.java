package com.pj.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.pj.entity.Goods;
import com.pj.service.GoodsService;
import com.pj.service.impl.GoodsServiceImpl;

public class ModifyGoodsServlet extends HttpServlet {
	GoodsService goodsService=new GoodsServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public ModifyGoodsServlet() {
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
		
		String goodsName=request.getParameter("goodsName");
		String goodsPrice=request.getParameter("goodsPrice");
		String goodsType=request.getParameter("goodsType");
		String isSale=request.getParameter("isSale");
		String goodsId=request.getParameter("goodsId");
		
		goodsName=new String(goodsName.getBytes("iso-8859-1"),"utf-8");
		goodsType=new String(goodsType.getBytes("iso-8859-1"),"utf-8");
		isSale=new String(isSale.getBytes("iso-8859-1"),"utf-8");
		Goods goods=new Goods(Integer.parseInt(goodsId),goodsName,Integer.parseInt(goodsPrice),goodsType,isSale);
		goods=goodsService.Modify(goods);
		
		JSONObject obj=JSONObject.fromObject(goods);
		System.out.println("ÐÞ¸Ä³É¹¦");
		System.out.println(obj);
		
	
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
