package com.ebooky.dao;
import com.ebooky.models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EbookDao {
    private Connection con;
    public EbookDao(Connection con) {
        this.con=con;
    }
    
    public void closeConn(){
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EbookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Ebook insertEbook(Ebook ebook) {
        Ebook edition_ = new Ebook();
        try {
            String query = "INSERT INTO Ebook (id_livre, taille, extension, path) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, ebook.getId_livre());
            pstmt.setFloat(2, ebook.getTaille());
            pstmt.setString(3, ebook.getExtension());
            pstmt.setString(4, ebook.getPath());
           
            pstmt.executeUpdate();
            edition_ = this.selectByIdLivre(ebook.getId_livre());
            
            System.out.println("Ebook ajouté avec succès. ebook: "+ edition_);
        } catch (SQLException e) {
            System.out.println("Ebook d'ajouter un Langue.");
            e.printStackTrace();
        }
        return ebook;
    }

//    public void updateEdition(Ebook ebook) {
//        try {
//            String query = "UPDATE Ebook SET nom = ? WHERE id = ?";
//            PreparedStatement pstmt = con.prepareStatement(query);
//            pstmt.setString(1, ebook.getNom());
//            
//            pstmt.executeUpdate();
//            System.out.println("Ebook mis à jour avec succès.");
//        } catch (SQLException e) {
//        	System.out.println("Impossible de mettre à jour un Langue.");
//        	e.printStackTrace();
//        	}
//        }
    public void deleteEbook(Ebook ebook) {
        try {
            String query = "DELETE FROM Ebook WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, ebook.getId());
            pstmt.executeUpdate();
            System.out.println("Ebook supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Impossible de supprimer une ebook.");
            e.printStackTrace();
        }
    }
    public ArrayList<Ebook> selectAllEbook(){
    	ArrayList<Ebook> all_edition = new ArrayList<>();
        try {
            String query = "SELECT * FROM Ebook";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	Ebook l = new Ebook(
            			rs.getInt("id"),
            			rs.getInt("id_livre"),
                        rs.getFloat("taille"),
                        rs.getString("extension"),
                        rs.getString("path")
            			);
            	all_edition.add(l);
            }
           
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un Ebook.");
            e.printStackTrace();
            
        }
        return all_edition;
    }
    public Ebook selectEbook(int id) {
    	Ebook ebook = null;
        try {
            String query = "SELECT * FROM Ebook WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	ebook = new Ebook(
            			rs.getInt("id"),
            			rs.getInt("id_livre"),
                        rs.getFloat("taille"),
                        rs.getString("extension"),
                        rs.getString("path")
            			);
            }
            return ebook;
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un Ebook.");
            e.printStackTrace();
            return null;
        }
    }
    public Ebook selectByIdLivre(int id_livre){
        Ebook ebook = new Ebook();
        try {
            String query = "SELECT * FROM Ebook WHERE id_livre = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id_livre);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	ebook = new Ebook(
            			rs.getInt("id"),
            			rs.getInt("id_livre"),
                        rs.getFloat("taille"),
                        rs.getString("extension"),
                        rs.getString("path")
            			
            			);
            }
            return ebook;
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un Ebook.");
            e.printStackTrace();
            return null;
        }
    }
    
}
    
