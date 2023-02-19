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

@WebServlet("/inscription")
public class InscriptionServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InscriptionServelet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String nom = request.getParameter("nom-inscription");
			String prenom = request.getParameter("prenom-inscription");
			String email = request.getParameter("email-inscription");
			String mdp = request.getParameter("mdp-inscription");
			UtilisateurDao utilisateurDao = new UtilisateurDao(Connexion.getConnexion());
			Utilisateur utilisateur = utilisateurDao.insertUser(nom, prenom, email, mdp, 0);
			System.out.println(utilisateur);

			if (utilisateur != null) {
					request.getSession().setAttribute("auth", utilisateur);
					response.sendRedirect("index.jsp");
			} else {
				out.println("L'inscription a echouer");
				}
			}

			

		}
	}