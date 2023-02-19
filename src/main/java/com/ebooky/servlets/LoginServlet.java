package com.ebooky.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebooky.dao.UtilisateurDao;
import com.ebooky.dbconn.Connexion;
import com.ebooky.models.Utilisateur;


@WebServlet("/login-utilisateur")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("email-login");
			String mdp = request.getParameter("mdp-login");

			UtilisateurDao utilisateurDao = new UtilisateurDao(Connexion.getConnexion());
			Utilisateur utilisateur = utilisateurDao.login(email, mdp);
			if (utilisateur != null) {
				request.getSession().setAttribute("auth", utilisateur);
				response.sendRedirect("home.jsp");
			} else {
				out.println("imposible de trouver l'utilisateur");
			}

		} 
	}

}
