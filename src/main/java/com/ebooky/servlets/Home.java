package com.ebooky.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebooky.database.DatabaseHandler;

@WebServlet("/home")
public class Home extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		System.out.print("OK");
		DatabaseHandler.createAllTable();
		
		
		RequestDispatcher rq = request.getRequestDispatcher("home.jsp");
		rq.forward(request, response);
	}
}
