package com.register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher disp = null;
		Connection conn = null;
		HttpSession session = request.getSession();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://root@localhost:3306/sunbase?useSSL=false", "root", "root");
			PreparedStatement p = conn.prepareStatement("select * from user where email = ? and password = ?");
			p.setString(1, email);
			p.setString(2, password);
			ResultSet res = p.executeQuery();
			if(res.next())
			{
				session.setAttribute("name", "user");
				disp = request.getRequestDispatcher("createcustomer.jsp");
			}
			else
			{
				request.setAttribute("status", "failed");
				disp = request.getRequestDispatcher("login.jsp");
			}
			disp.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
