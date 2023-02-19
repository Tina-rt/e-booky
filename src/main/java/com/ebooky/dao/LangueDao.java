package com.ebooky.dao;
import com.ebooky.models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LangueDao {
    private Connection con;
    public LangueDao(Connection con) {
        this.con=con;
    }
    public void insertLangue(Langue langue) {
        try {
            String query = "INSERT INTO Langue (nom) VALUES (?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, langue.getNom());
           
            pstmt.executeUpdate();
            System.out.println("Langue ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Impossible d'ajouter un Langue.");
            e.printStackTrace();
        }
    }

    public void updateLangue(Langue langue) {
        try {
            String query = "UPDATE Langue SET nom = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, langue.getNom());
            
            pstmt.executeUpdate();
            System.out.println("Langue mis à jour avec succès.");
        } catch (SQLException e) {
        	System.out.println("Impossible de mettre à jour un Langue.");
        	e.printStackTrace();
        	}
        }
    public void deleteLangue(Langue langue) {
        try {
            String query = "DELETE FROM Langue WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, langue.getId());
            pstmt.executeUpdate();
            System.out.println("Langue supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Impossible de supprimer un Langue.");
            e.printStackTrace();
        }
    }
    public ArrayList<Langue> selectAllLangue(){
    	ArrayList<Langue> all_livre = new ArrayList<>();
        try {
            String query = "SELECT * FROM Langue";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	Langue l = new Langue(
            			rs.getInt("id"),
            			rs.getString("nom")
            			
            			);
            	all_livre.add(l);
            }
           
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un Langue.");
            e.printStackTrace();
            
        }
        return all_livre;
    }
    public Langue selectLangue(int id) {
    	Langue langue = null;
        try {
            String query = "SELECT * FROM Langue WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	langue = new Langue(
            			rs.getInt("id"),
            			rs.getString("nom")
            			
            			);
            }
            return langue;
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un Langue.");
            e.printStackTrace();
            return null;
        }
    }
    
}
    
