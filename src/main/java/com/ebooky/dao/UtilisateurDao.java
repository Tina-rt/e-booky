package com.ebooky.dao;
import com.ebooky.models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtilisateurDao {
    private Connection con;
    public UtilisateurDao(Connection con) {
        this.con=con;
    }
    public void insertUser(Utilisateur utilisateur) {
        try {
            String query = "INSERT INTO utilisateur (nom, prenom, email, mdp,id_role) VALUES (?, ?, ?, ?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, utilisateur.getNom());
            pstmt.setString(2, utilisateur.getPrenom());
            pstmt.setString(3, utilisateur.getEmail());
            pstmt.setString(4, utilisateur.getMot_de_passe());
            pstmt.setInt(5, utilisateur.getId_role());
            pstmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Impossible d'ajouter un utilisateur.");
            e.printStackTrace();
        }
    }

    public void updateUser(Utilisateur utilisateur) {
        try {
            String query = "UPDATE utilisateur SET nom = ?, prenom = ?, email = ?, mdp = ? ,id_role=? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, utilisateur.getNom());
            pstmt.setString(2, utilisateur.getPrenom());
            pstmt.setString(3, utilisateur.getEmail());
            pstmt.setString(4, utilisateur.getMot_de_passe());
            pstmt.setInt(5, utilisateur.getId_role());
            pstmt.executeUpdate();
            System.out.println("Utilisateur mis à jour avec succès.");
        } catch (SQLException e) {
        	System.out.println("Impossible de mettre à jour un utilisateur.");
        	e.printStackTrace();
        	}
        }
    public void deleteUser(Utilisateur utilisateur) {
        try {
            String query = "DELETE FROM utilisateur WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, utilisateur.getId());
            pstmt.executeUpdate();
            System.out.println("Utilisateur supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Impossible de supprimer un utilisateur.");
            e.printStackTrace();
        }
    }
    public ArrayList<Utilisateur> selectAllUser(){
    	ArrayList<Utilisateur> all_utilisateur = new ArrayList<Utilisateur>();
        try {
            String query = "SELECT * FROM Utilisateur";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	Utilisateur u = new Utilisateur(
            			rs.getInt("id"),
            			rs.getString("nom"),
            			rs.getString("prenom"),
            			rs.getString("email"),
            			rs.getString("mdp"),
            			rs.getInt("id_role")
            			);
            	all_utilisateur.add(u);
            }
           
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un utilisateur.");
            e.printStackTrace();
            
        }
        return all_utilisateur;
    }
    public Utilisateur selectUser(int id) {
    	Utilisateur u = null;
        try {
            String query = "SELECT * FROM Utilisateur WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	u = new Utilisateur(
            			rs.getInt("id"),
            			rs.getString("nom"),
            			rs.getString("prenom"),
            			rs.getString("email"),
            			rs.getString("mdp"),
            			rs.getInt("id_role")
            			);
            }
            return u;
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un utilisateur.");
            e.printStackTrace();
            return null;
        }
    }
}
    
