package com.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletecustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public boolean deleteuser(String fname) {
		boolean deleted = false;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://root@localhost:3306/sunbase?useSSL=false", "root", "root");
			PreparedStatement p = conn.prepareStatement("delete from customer where firstname = ?");
			p.setString(1, fname);
			
			deleted = p.executeUpdate() > 0;
		}
		catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return deleted;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstname");
		RequestDispatcher disp = null;
		
		try {
			
			boolean deleted = deleteuser(fname);
			disp = request.getRequestDispatcher("index.jsp");
			if(deleted == true) {
				request.setAttribute("status", "success");
			}
			else
			{
				request.setAttribute("status", "failed");
			}
			disp.forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
