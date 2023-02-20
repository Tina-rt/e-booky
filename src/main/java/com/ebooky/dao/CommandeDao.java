package com.ebooky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ebooky.models.Commande;

public class CommandeDao {
	private Connection con;
    public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public CommandeDao(Connection con) {
        this.con=con;
    }
    
    public void closeConn(){
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EbookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int insertCommande(Commande commande) {
    	try {
            String query = "INSERT INTO Commande (total, valider) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setFloat(1, commande.getTotal());
            pstmt.setBoolean(2, commande.isValidee());
            System.out.println(commande.toString()+" "+pstmt.toString());
           
            int row_count = pstmt.executeUpdate();
//            this.closeConn();
            
            if (row_count > 0) {
            	pstmt = con.prepareStatement("SELECT id FROM Commande ORDER BY id DESC");
            	ResultSet rs = pstmt.executeQuery();
            	while (rs.next()) {
            		return rs.getInt("id");
            	}
            }
            
            System.out.println("Commande ajouté avec succès. commande: "+ commande);
        } catch (SQLException e) {
            System.out.println("impossible d'ajouter un commande. "+ e.getMessage());
            e.printStackTrace();
        }
    	return 0;
    }
}
