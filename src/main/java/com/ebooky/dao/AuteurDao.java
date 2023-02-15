/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ebooky.dao;

import com.ebooky.models.Auteur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tina
 */
public class AuteurDao {
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    public AuteurDao(Connection con) {
        this.con=con;
    }
    public Auteur selectAuteurById(int id){
        Auteur auteur = new Auteur();
        try {
            String query = "SELECT * FROM Auteur WHERE id = '"+id+"'";
            PreparedStatement pstmt = con.prepareStatement(query);
//            pstmt.setString(0, name);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	auteur = new Auteur(
            			rs.getInt("id"),
            			rs.getString("nom")
            			
            			);
            	
            }
           
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un auteur.");
            e.printStackTrace();
            
            
        }
        return auteur;
    }
    
    public Auteur selectAuteurName(String name){
        Auteur auteur = new Auteur();
        try {
            String query = "SELECT * FROM Auteur WHERE nom = '"+name+"'";
            PreparedStatement pstmt = con.prepareStatement(query);
//            pstmt.setString(0, name);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	auteur = new Auteur(
            			rs.getInt("id"),
            			rs.getString("nom")
            			
            			);
            	
            }
           
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un auteur.");
            e.printStackTrace();
            
            
        }
        return auteur;
    }
    
    public Auteur insertAuteur(Auteur auteur) throws Exception{
        Auteur existing_auteur = new Auteur();
        existing_auteur = this.selectAuteurName(auteur.getNom());
        if (existing_auteur.getId() > 0){
            throw new Exception("Auteur "+auteur.getNom()+" existe deja");
            
        }
        try {
            String query = "INSERT INTO Auteur (nom) VALUES (?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, auteur.getNom());
           
            pstmt.executeUpdate();
            System.out.println("Auteur ajouté avec succès.");
            return this.selectAuteurName(auteur.getNom());
        } catch (SQLException e) {
            System.out.println("Impossible d'ajouter un auteur.");
            e.printStackTrace();
            
        }
        return null;
    }

    public ArrayList<Auteur> selectAllAuteur(){
        ArrayList<Auteur> all_categorie = new ArrayList<>();
        try {
            String query = "SELECT * FROM Auteur";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	Auteur l = new Auteur(
            			rs.getInt("id"),
            			rs.getString("nom")
            			
            			);
            	all_categorie.add(l);
            }
           
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un auteur.");
            e.printStackTrace();
            
        }
        return all_categorie;
    }
}
