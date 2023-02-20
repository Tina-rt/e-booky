package com.ebooky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ebooky.models.Achat;

public class AchatDao {
	private Connection con;
    public AchatDao(Connection con) {
        this.con=con;
    }
    
    public void closeConn(){
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EbookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void insertAchat(Achat achat) {
    	String query = "INSERT INTO Achat(id_utilisateur, id_livre, id_type_paiement, id_commande) VALUES(?, ?, ?, ?)";
    	try {
			PreparedStatement pstmt = this.con.prepareStatement(query);
			pstmt.setInt(1, achat.getId_utilisateur());
			pstmt.setInt(2, achat.getId_livre());
			pstmt.setInt(3, achat.getId_type_paiement());
			pstmt.setInt(4, achat.getId_commande());
			
			int is_execute = pstmt.executeUpdate();
			if (is_execute > 0) {
				System.out.println("Achat inserted successfully Achat: "+achat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
