package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionSqlite {
	
	
    public void query (String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Connexion à la base de données locale SQLite
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ma_base_de_donnees.db");

            // Création de la requête SQL pour récupérer les noms des participants
            String sql = "SELECT nom, prenom FROM table_participants";
            stmt = conn.createStatement();

            // Exécution de la requête SQL
            rs = stmt.executeQuery(sql);

           //  Parcourir chaque ligne de résultat et afficher les noms des participants
            while (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                System.out.println(nom + " " + prenom);
            }
            
        
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture des objets de connexion, de requête et de résultat
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void insert (String query) {
        Connection conn = null;
        Statement stmt = null;
     
        try {
            // Connexion à la base de données locale SQLite
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ma_base_de_donnees.db");

            // Création de la requête SQL pour récupérer les noms des participants
            String sql = "SELECT nom, prenom FROM table_participants";
            stmt = conn.createStatement();

          System.out.println("Nouvelle ligne inserée");
       
        
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture des objets de connexion, de requête et de résultat
            try {
               
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                
            }
            
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
