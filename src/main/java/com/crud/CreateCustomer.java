package com.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/createcustomer")
public class CreateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String street = request.getParameter("street");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		Connection conn = null;
		RequestDispatcher disp = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://root@localhost:3306/sunbase?useSSL=false", "root", "root");
			PreparedStatement p = conn.prepareStatement("insert into customer(first_name, last_name, street, address, city, state, email, phone) values(?, ?, ?, ?, ?, ?, ?, ?)");
			p.setString(1, fname);
			p.setString(2, lname);
			p.setString(3, street);
			p.setString(4, address);
			p.setString(5, city);
			p.setString(6, state);
			p.setString(7, email);
			p.setString(8, phone);
			
			if(fname == null || lname == null || fname == "" || lname == "") {
				request.setAttribute("status", "failed");
				disp = request.getRequestDispatcher("createcustomer.jsp");
			}
			else {
			
				int rows = p.executeUpdate();
				disp = request.getRequestDispatcher("index.jsp");
				
				if(rows > 0)
				{
					request.setAttribute("status", "success");
				}
				else request.setAttribute("status", "failed");
				
				disp.forward(request, response);
			}
		}
		catch(Exception e)
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
