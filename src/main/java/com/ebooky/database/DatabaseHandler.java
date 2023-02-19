package com.ebooky.database;

import java.sql.*;

public class DatabaseHandler {
    private static final String URL = "jdbc:sqlite:booky.db"; // URL to the database
    private static Connection connection;

    public static Connection getConnection() {
    	try {
    		Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(URL);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("DEBUG ---- ");
    	System.out.println(connection);
//        if (connection == null) {
//            try {
//                connection = DriverManager.getConnection(URL);
//                
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        return connection;
    }

    public static void createAllTable() {
        createEditionTable();
        createUtilisateurTable();
        createRoleTable();
        createAchatTable();
        createLivreTable();
        createAuteurTable();
        createCategorieTable();
        createCommandeTable();
        createEbookTable();
        createLangueTable();
        createStockTable();
        createTypePaiementTable();
        
        
    }

    public static void createUtilisateurTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Utilisateur ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nom TEXT NOT NULL,"
                + "prenom TEXT NOT NULL,"
                + "email TEXT NOT NULL,"
                + "mdp TEXT NOT NULL,"
                + "id_role INTEGER"
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Utilisateur created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createRoleTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Role ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "label TEXT NOT NULL"
                
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Role created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createEditionTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Edition ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nom TEXT NOT NULL, "
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Edition created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createLivreTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Livre ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "titre TEXT NOT NULL, "
                + "description TEXT NOT NULL,"
                + "prix REAL NOT NULL,"
                + "date_publication DATE,"
                + "id_langue INTEGER,"
                + "id_auteur INTEGER,"
                +"id_categorie INTEGER,"
                +"id_edition INTEGER,"
                + "quantite INTEGER,"
                + "couverture TEXT"
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table LIvre created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createEbookTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Ebook ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "id_livre INTEGER,"
                + "taille REAL,"
                + "extension TEXT NOT NULL,"
                + "path TEXT NOT NULL"
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Ebook created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createCategorieTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Categorie ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "label TEXT NOT NULL"
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Categorie created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createStockTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Stock ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "id_livre INTEGER,"
                + "quantite INTEGER,"
                + "extension TEXT NOT NULL"
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Stock created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void createLangueTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Langue ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nom TEXT NOT NULL"
                
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Langue created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createAchatTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Achat ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "id_utilisateur INTEGER,"
                + "id_livre INTEGER,"
                + "id_type_paiement INTEGER,"
                + "id_commande INTEGER"
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Achat created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createCommandeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Commande ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "total BOOLEAN NOT NULL CHECK (total IN (0,1)),"
                + "valider TEXT NOT NULL"
                
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Commande created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createAuteurTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Auteur ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nom TEXT NOT NULL"
                
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table Auteur created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createTypePaiementTable() {
        String sql = "CREATE TABLE IF NOT EXISTS TypePaiement ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "label TEXT NOT NULL"
                
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table TypePaiement created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
