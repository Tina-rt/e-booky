package com.ebooky.dao;

import com.ebooky.models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivreDao {

    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public LivreDao(Connection con) {
        this.con = con;
    }

    public int insertLivre(Livre livre) {
        int id_livre_inserted = 0;
        System.out.println(livre.getId_langue());
        try {
            String query = "INSERT INTO Livre "
                    + "(titre, description, prix, date_publication, id_langue, id_auteur, id_categorie, quantite, couverture) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, livre.getTitre());
            pstmt.setString(2, livre.getDescription());
            pstmt.setDouble(3, livre.getPrix());
            pstmt.setString(4, livre.getDate_de_publication());
            pstmt.setInt(5, livre.getId_langue());
            pstmt.setInt(6, livre.getAuteur().getId());
            pstmt.setInt(7, livre.getId_categorie());
            pstmt.setInt(8, livre.getQuantite());
            pstmt.setString(9, livre.getPage_couverture());
            pstmt.executeUpdate();
            System.out.println("Livre ajouté avec succès.");
            pstmt = con.prepareStatement("SELECT id FROM livre WHERE titre=?");
            pstmt.setString(1, livre.getTitre());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                id_livre_inserted = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Impossible d'ajouter un livre.");
            e.printStackTrace();
        }
        return id_livre_inserted;
    }

    public void updateLivre(Livre livre) {
        try {
            String query = "UPDATE Livre SET titre = ?, description = ?, prix = ?, date_publication"
                    + "= ? , id_langue=? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, livre.getTitre());
            pstmt.setString(2, livre.getDescription());
            pstmt.setDouble(3, livre.getPrix());
            pstmt.setString(4, livre.getDate_de_publication());
            pstmt.setInt(5, livre.getId_langue());
            pstmt.executeUpdate();
            System.out.println("Livre mis à jour avec succès.");
        } catch (SQLException e) {
            System.out.println("Impossible de mettre à jour un livre.");
            e.printStackTrace();
        }
    }

    public void deleteLivre(Livre livre) {
        try {
            String query = "DELETE FROM Livre WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, livre.getId());
            pstmt.executeUpdate();
            System.out.println("Livre supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("Impossible de supprimer un livre.");
            e.printStackTrace();
        }
    }

    public ArrayList<Livre> selectAllLivre() {
        ArrayList<Livre> all_livre = new ArrayList<>();
        try {
            String query = "SELECT * FROM Livre";
            PreparedStatement pstmt = con.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Livre u = new Livre(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getDouble("prix"),
                        rs.getString("date_publication"),
                        rs.getInt("id_langue"),
                        rs.getInt("id_categorie")
                );
                u.setAuteur(new Auteur(rs.getInt("id_auteur")));
                u.setPage_couverture(rs.getString("couverture"));
                all_livre.add(u);
            }

        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un livre.");
            e.printStackTrace();

        }
        return all_livre;
    }

    public Livre selectLivre(int id) {
        Livre livre = null;
        try {
            String query = "SELECT * FROM Livre WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                livre = new Livre(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getDouble("prix"),
                        rs.getString("date_publication"),
                        rs.getInt("id_langue"),
                        rs.getInt("id_categorie")
                );
                livre.setAuteur(new Auteur(rs.getInt("id_auteur")));
                livre.setPage_couverture(rs.getString("couverture"));
            }
            return livre;
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un livre.");
            e.printStackTrace();
            return null;
        }
    }

}
