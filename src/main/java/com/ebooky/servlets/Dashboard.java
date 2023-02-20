/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ebooky.servlets;

import com.ebooky.dao.CategorieDao;
import com.ebooky.dao.LangueDao;
import com.ebooky.dao.LivreDao;
import com.ebooky.dbconn.Connexion;
import com.ebooky.models.Categorie;
import com.ebooky.models.Langue;
import com.ebooky.models.Livre;
import com.ebooky.models.Edition;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Tina
 */
@WebServlet(name = "Dashboard", urlPatterns = {"/Dashboard"})

public class Dashboard extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("pages/dashboard.jsp");
        
        LangueDao ld = new LangueDao(Connexion.getConnexion());
        
        ArrayList<Langue> all_langue = ld.selectAllLangue();
        
        CategorieDao categorieDao = new CategorieDao(Connexion.getConnexion());
        ArrayList<Categorie> all_categorie = categorieDao.selectAllCategorie();
        System.out.println(all_categorie);
        
        LivreDao livreDao = new LivreDao(Connexion.getConnexion());
        ArrayList<Livre> all_livre = livreDao.selectAllLivre();
        
//        String path_ = all_livre.get(0).getPage_couverture();
//        System.out.println("Path page couverture "+getServletContext().getContextPath() + File.separator+ "uploaded_image"+File.separator+"3d-book-cover__1676327769025.webp");
//        
        request.setAttribute("all_langue", all_langue);
        request.setAttribute("all_livre", all_livre);
        request.setAttribute("all_categorie", all_categorie);
        
        
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
