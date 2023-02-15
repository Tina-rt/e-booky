package com.ebooky.dao;
import com.ebooky.models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditionDao {
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    public EditionDao(Connection con) {
        this.con=con;
    }
    public Edition insertEdition(Edition edition) {
        Edition edition_ = new Edition();
        try {
            String query = "INSERT INTO Edition (nom) VALUES (?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, edition.getNom());
           
            pstmt.executeUpdate();
            edition_ = this.selectByName(edition.getNom());
            
            System.out.println("Edition ajouté avec succès. edition: "+ edition_);
        } catch (SQLException e) {
            System.out.println("Edition d'ajouter un Langue.");
            e.printStackTrace();
        }
        return edition;
    }

    public void updateEdition(Edition edition) {
        try {
            String query = "UPDATE Edition SET nom = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, edition.getNom());
            
            pstmt.executeUpdate();
            System.out.println("Edition mis à jour avec succès.");
        } catch (SQLException e) {
        	System.out.println("Impossible de mettre à jour un Langue.");
        	e.printStackTrace();
        	}
        }
    public void deleteEdition(Edition edition) {
        try {
            String query = "DELETE FROM Edition WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, edition.getId());
            pstmt.executeUpdate();
            System.out.println("Edition supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Impossible de supprimer une edition.");
            e.printStackTrace();
        }
    }
    public ArrayList<Edition> selectAllEdition(){
    	ArrayList<Edition> all_edition = new ArrayList<>();
        try {
            String query = "SELECT * FROM Edition";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	Edition l = new Edition(
            			rs.getInt("id"),
            			rs.getString("nom")
            			
            			);
            	all_edition.add(l);
            }
           
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un Edition.");
            e.printStackTrace();
            
        }
        return all_edition;
    }
    public Edition selectEdition(int id) {
    	Edition edition = null;
        try {
            String query = "SELECT * FROM Edition WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	edition = new Edition(
            			rs.getInt("id"),
            			rs.getString("nom")
            			
            			);
            }
            return edition;
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un Edition.");
            e.printStackTrace();
            return null;
        }
    }
    public Edition selectByName(String name){
        Edition edition = new Edition();
        try {
            String query = "SELECT * FROM Edition WHERE nom = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	edition = new Edition(
            			rs.getInt("id"),
            			rs.getString("nom")
            			
            			);
            }
            return edition;
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un Edition.");
            e.printStackTrace();
            return null;
        }
    }
    
}
    
