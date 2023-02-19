/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ebooky.dao;

import com.ebooky.models.Categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tina
 */
public class CategorieDao {
    private Connection con;
    public CategorieDao(Connection con) {
        this.con=con;
    }
    
    public ArrayList<Categorie> selectAllCategorie(){
        ArrayList<Categorie> all_categorie = new ArrayList<>();
        try {
            String query = "SELECT * FROM Categorie";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	Categorie l = new Categorie(
            			rs.getInt("id"),
            			rs.getString("label")
            			
            			);
            	all_categorie.add(l);
            }
           
        } catch (SQLException e) {
            System.out.println("Impossible de sélectionner un Langue.");
            e.printStackTrace();
            
        }
        return all_categorie;
    }
}
