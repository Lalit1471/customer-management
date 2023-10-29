package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String re_pass = request.getParameter("re_pass");
		RequestDispatcher disp = null;
		Connection conn = null;
		PrintWriter r = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://root@localhost:3306/sunbase?useSSL=false", "root", "root");
			PreparedStatement p = conn.prepareStatement("insert into user(email, password) values(?, ?)");
			p.setString(1, email);
			p.setString(2, password);
			int rows = p.executeUpdate();
			disp = request.getRequestDispatcher("registration.jsp");
			if(rows > 0)
			{
				request.setAttribute("status", "success");
			}
			else request.setAttribute("status", "failed");
			
			disp.forward(request, response);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
