/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ebooky.servlets;

import com.ebooky.dao.AuteurDao;
import com.ebooky.dao.EbookDao;
import com.ebooky.dao.EditionDao;
import com.ebooky.dao.LivreDao;
import com.ebooky.dbconn.Connexion;
import com.ebooky.models.Auteur;
import com.ebooky.models.Ebook;
import com.ebooky.models.Edition;
import com.ebooky.models.Livre;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "AjoutLivre", urlPatterns = {"/AjoutLivre"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1,
    maxFileSize = 1024 *1024 * 10,
    maxRequestSize = 1024 * 1024 * 100
)
public class AjoutLivre extends HttpServlet {
    private String UPLOAD_IMAGE_DIR = "uploaded_images";
    private String UPLOAD_EBOOK_DIR = "uploaded_books";
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
        
        Livre new_livre = new Livre();
        
        int quantite = Integer.valueOf(request.getParameter("quantite"));
        new_livre.setQuantite(quantite);
        
        float prix = Float.valueOf(request.getParameter("prix"));
        new_livre.setPrix(prix);
        
        int id_langue = Integer.valueOf(request.getParameter("langue"));
        new_livre.setId_langue(id_langue);
        
        String auteur = request.getParameter("auteur");
        
        // Verifier si on a deja un auteur portant ce nom
        AuteurDao auteur_dao = new AuteurDao(Connexion.getConnexion());
        Auteur auteur_bd = auteur_dao.selectAuteurName(auteur);
       
        if (auteur_bd.getId() > 0){
            // Si c'est le cas, on a juste qu'a parametrer l'auteur dans la base
            new_livre.setAuteur(auteur_bd);
        }
        else{
            try {
                // sinon on insert un nouveau auteur et on l'assigne au livre
                
                Auteur new_auteur = auteur_dao.insertAuteur(new Auteur(auteur));
                new_livre.setAuteur(new_auteur);
            } catch (Exception ex) {
                Logger.getLogger(AjoutLivre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Fermer la connexion
        try {
            auteur_dao.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(AjoutLivre.class.getName()).log(Level.SEVERE, null, ex);
        }
        String description = request.getParameter("description");
        int langue_id = Integer.valueOf(request.getParameter("langue"));
        String edition = request.getParameter("edition");
        
        EditionDao editionDao = new EditionDao(Connexion.getConnexion());
        Edition editionDb  = editionDao.selectByName(edition);
        
        if (editionDb.getId() <= 0){
            editionDb.setNom(edition);
            editionDb = editionDao.insertEdition(editionDb);
        }
        // Fermer la connexion
        try {
            editionDao.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(AjoutLivre.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        new_livre.setId_edition(editionDb.getId());
        
        int categorie_id = Integer.valueOf(request.getParameter("categorie"));

        String titre = request.getParameter("titre");
        new_livre.setTitre(titre);
        new_livre.setDescription(description);
        new_livre.setId_langue(langue_id);
        
        // Recuperer l'image de couverture du livre
        String couvertureFilePath = "";
        
        
        Map<String, String[]> params = request.getParameterMap();
        System.out.println(new_livre);
        
        Part couvertureFilePart = request.getPart("page_couverture");
        if (couvertureFilePart.getSize() > 0){    
            couvertureFilePath = this.uploadFile(couvertureFilePart, "", this.UPLOAD_IMAGE_DIR);
            new_livre.setPage_couverture(couvertureFilePath);
        }
        System.out.println(new_livre);
        LivreDao livreDao = new LivreDao(Connexion.getConnexion());
        new_livre.setId(livreDao.insertLivre(new_livre));
         // fermer la connexion
        try {
            
            livreDao.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(AjoutLivre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Part ebook = request.getPart("ebook");
        System.out.println("ebook : ");
        System.out.print(ebook);
        String ebookPath = "";
        
        RequestDispatcher rd;
        
        if (ebook.getSize() > 0){    
            ebookPath = this.uploadFile(ebook, "", this.UPLOAD_EBOOK_DIR);
            Ebook ebook_ = new Ebook();
            ebook_.setPath(ebookPath);
            ebook_.setId_livre(new_livre.getId());
            ebook_.setTaille(ebook.getSize());
            System.out.println(ebook_);
            
            EbookDao ebookDao = new EbookDao(Connexion.getConnexion());
            ebookDao.insertEbook(ebook_);
            ebookDao.closeConn();
            
        }
        else{
//            rd = request.getRequestDispatcher("pages/Error_page.jsp");
//            rd.forward(request, response);
        }

        response.sendRedirect("Dashboard");
//        rd.forward(request, response);
        
        

    }

    
    public String uploadFile(Part file, String name, String directory) throws IOException{
        String filename = file.getSubmittedFileName();
        String extension = "";
        // GET THe file extension
        int i = filename.lastIndexOf(".");
        if (i > 0){
            extension = filename.substring(i);
        }
        if (name.length() > 0){
            filename = name;
        }
        filename = filename.substring(0,i) + "__"+String.valueOf(System.currentTimeMillis())+extension;
        String uploadPath = getServletContext().getRealPath("") + File.separator + directory;  
        
        // verify if the upload path exists
        File upload_dir = new File(uploadPath);
        if (!upload_dir.exists())
            upload_dir.mkdir();
        
        
        InputStream inputStream = file.getInputStream();
        try (FileOutputStream outputStream = new FileOutputStream(uploadPath+File.separator+filename)) {
            int read = 0;
            final byte[] bytes = new byte[4024];
            while(inputStream.read(bytes)!=-1){
                outputStream.write(bytes);
            }
        }
        return "uploaded_images"+File.separator+filename;
    }

}
