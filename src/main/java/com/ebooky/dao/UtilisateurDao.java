package com.ebooky.dao;
import com.ebooky.models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDao {
    private Connection con;
    public UtilisateurDao(Connection con) {
        this.con=con;
    }
    public void insertUser(String nom, String prenom, String email, String mdp,int id_role) {
        try {
            String query = "INSERT INTO utilisateur (nom, prenom, email, mdp,id_role) VALUES (?, ?, ?, ?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, email);
            pstmt.setString(4, mdp);
            pstmt.setInt(5, id_role);
            pstmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Impossible d'ajouter un utilisateur.");
            e.printStackTrace();
        }
    }

    public void updateUser(int id, String nom, String prenom, String email, String mdp,int id_role) {
        try {
            String query = "UPDATE utilisateur SET nom = ?, prenom = ?, email = ?, mdp = ? ,id_role=? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, email);
            pstmt.setString(4, mdp);
            pstmt.setInt(5, id_role);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
            System.out.println("Utilisateur mis à jour avec succès.");
        } catch (SQLException e) {
        	System.out.println("Impossible de mettre à jour un utilisateur.");
        	e.printStackTrace();
        	}
        }
    public void deleteUser(int id) {
        try {
            String query = "DELETE FROM utilisateur WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Utilisateur supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Impossible de supprimer un utilisateur.");
            e.printStackTrace();
        }
    }
    public ResultSet selectUser(int id) {
        try {
            String query = "SELECT * FROM utilisateur WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un utilisateur.");
            e.printStackTrace();
            return null;
        }
    }
    public Utilisateur login(String email, String mdp) {
    	Utilisateur utilisateur=null;
    	try {
    		String query = "select * from utilisateur where email=? and mdp=?";
    		PreparedStatement pstmt = this.con.prepareStatement(query);
    		pstmt.setString(1, email);
    		pstmt.setString(2, mdp);
    		ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
            	utilisateur = new Utilisateur();
            	utilisateur.setId(rs.getInt("id"));
            	utilisateur.setNom(rs.getString("nom"));
            	utilisateur.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    	return utilisateur;
    	
    }
}
    
