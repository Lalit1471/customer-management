package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readcustomer")
public class ReadCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public List<CustomerModel> getAllCustomers(){
    	List<CustomerModel> customers = new ArrayList<>();
    	
    	Connection conn = null;
    	
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://root@localhost:3306/sunbase?useSSL=false", "root", "root");
			PreparedStatement p = conn.prepareStatement("select * from customer");
			ResultSet res = p.executeQuery();
			
			while(res.next()) {
				String firstName = res.getString("first_name");
	            String lastName = res.getString("last_name");
	            String street = res.getString("street");
	            String address = res.getString("address");
	            String city = res.getString("city");
	            String state = res.getString("state");
	            String email = res.getString("email");
	            String phoneNumber = res.getString("phone");
	            
	            CustomerModel c = new CustomerModel();
	            c.setvalues(firstName, lastName, street, address, phoneNumber, email, city, state);
	            customers.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	
    	return customers;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<CustomerModel> customers = this.getAllCustomers();
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
