package com.ebooky.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebooky.database.DatabaseHandler;

@WebServlet("/initdatabase")
public class initdatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public initdatabase() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("OK");
		DatabaseHandler.createAllTable();
		RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
		rq.forward(request, response);
	}
}

