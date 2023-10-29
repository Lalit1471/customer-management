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

@WebServlet("/updatecustomer")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public boolean update(CustomerModel c) {
		boolean updated = false;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://root@localhost:3306/sunbase?useSSL=false", "root", "root");
			PreparedStatement p = conn.prepareStatement("update customer set email = ?, street = ?, address = ?, phone = ?, city = ?, state = ? where firstname = ?");
			p.setString(1, c.getemail());
			p.setString(2, c.getstreet());
			p.setString(3, c.getaddress());
			p.setString(4, c.getphone());
			p.setString(5, c.getcity());
			p.setString(6, c.getstate());
			p.setString(7, c.getfname());
			
			updated = p.executeUpdate() > 0;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return updated;
		
	}
	
	public CustomerModel getCustomer(String firstname) {
		Connection conn = null;
		
		CustomerModel c = new CustomerModel();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://root@localhost:3306/sunbase?useSSL=false", "root", "root");
			PreparedStatement p = conn.prepareStatement("select * from customer where first_name = ?");
			p.setString(1, firstname);
			ResultSet res = p.executeQuery();
			String street = res.getString("street");
            String address = res.getString("address");
            String city = res.getString("city");
            String state = res.getString("state");
            String email = res.getString("email");
            String phoneNumber = res.getString("phone");
            
            c.setvalues(firstname, null, street, address, phoneNumber, email, city, state);
            
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstname");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String street = request.getParameter("street");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		RequestDispatcher disp = null;
		
		CustomerModel c = getCustomer(fname);
		c.setvalues(fname, null, street, address, phone, email, city, state);
		
		try {
			
			boolean updated = update(c);
			disp = request.getRequestDispatcher("index.jsp");
			if(updated == true) {
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
