package com.ebooky.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebooky.dao.UtilisateurDao;
import com.ebooky.database.DatabaseHandler;
import com.ebooky.dbconn.Connexion;
import com.ebooky.models.Utilisateur;

@WebServlet("/home")
public class Home extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

		RequestDispatcher rq = request.getRequestDispatcher("pages/login.jsp");
		rq.forward(request, response);
	}
}
