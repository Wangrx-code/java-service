package com.pj.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.pj.entity.User;
import com.pj.service.UserService;
import com.pj.service.impl.UserServiceImpl;

public class ModifyServlet extends HttpServlet {
	UserService userService=new UserServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public ModifyServlet() {
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
		
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		String userType=request.getParameter("userType");
		String userLocation=request.getParameter("userLocation");
		
		userName=new String(userName.getBytes("iso-8859-1"),"utf-8");
		userType=new String(userType.getBytes("iso-8859-1"),"utf-8");
		userLocation=new String(userLocation.getBytes("iso-8859-1"),"utf-8");
		System.out.println("userName="+userName+"userPassword="+userPassword+"userType="+userType+"userLocation="+userLocation);
		
		User user=new User(userName,userPassword,userType,userLocation);
		user=userService.userModify(user);
		
		JSONObject userResult=JSONObject.fromObject(user);
		System.out.println("ÐÞ¸Ä³É¹¦!");
		System.out.println(userResult);
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
