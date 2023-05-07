package project;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entite.*;
import enumeration.GenreEnum;

public class ConnexionSqlite {

	public void query(String query) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			// Connexion à la base de données locale SQLite
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:ma_base_de_donnees.db");

			// Création de la requête SQL pour récupérer les noms des participants
			String sql = "SELECT nom, prenom FROM table_participants";
			stmt = conn.createStatement();

			// Création de la requête SQL pou Récupération des temps
			Statement stmt2 = conn.createStatement();
			ResultSet rsTemps = stmt2.executeQuery("SELECT heureArrivee FROM CHRONO ORDER BY temps ASC");

			// Exécution de la requête SQL
			rs1 = stmt.executeQuery(sql);
			rs2 = stmt2.executeQuery(sql);

			// Parcourir chaque ligne de résultat et afficher les noms des participants
			while (rs1.next()) {
				String nom = rs1.getString("nom");
				String prenom = rs1.getString("prenom");
				System.out.println(nom + " " + prenom);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermeture des objets de connexion, de requête et de résultat
			try {
				if (rs1 != null) {
					rs1.close();
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

	// insertion des donnes pour la table participant
	public void testInsertion() {
		// Paramètres de connexion à la base de données
		String url = "jdbc:sqlite:C:/Users/Ezzine/OneDrive - GROUPE 3IL/Bureau/eclipse2023/Projet_v2/ma_base_de_donnees.db";

		try {
			// Connexion à la base de données
			Connection connexion = DriverManager.getConnection(url);

			// Requête SQL pour insérer une ligne dans la table "utilisateurs"
			String requete = "INSERT INTO participant (id,nom, prenom, genre) VALUES (?,?,?,?)";

			// Préparation de la requête
			PreparedStatement preparedStatement = connexion.prepareStatement(requete);

			// Paramètres à insérer dans la requête
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "paul");
			preparedStatement.setString(3, "irak");
			preparedStatement.setString(4, "masculin");

			// Exécution de la requête
			int lignesAjoutees = preparedStatement.executeUpdate();

			if (lignesAjoutees > 0) {
				System.out.println("La ligne a été insérée avec succès !");
			} else {
				System.out.println("La ligne n'a pas pu être insérée.");
			}

			// Fermeture de la connexion
			connexion.close();

		} catch (SQLException e) {
			System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
		}
	}

	
	
	public List<Participant> retrieveParticipant() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Participant> participants = new ArrayList<>();
		// Paramètres de connexion à la base de données
		String url = "jdbc:sqlite:C:/Users/Ezzine/OneDrive - GROUPE 3IL/Bureau/eclipse2023/Projet_v2/ma_base_de_donnees.db";
		try {
			
			Class.forName("org.sqlite.JDBC");

			// Connexion à la base de données
			conn = DriverManager.getConnection(url);

			String sql = "SELECT "
			+ "CHRONO.heureDepart," 
			+ "CHRONO.heureArrivee," 
			+ "PARTICIPANT.nom,"
			+ "PARTICIPANT.prenom," 
			+ "PARTICIPANT.id," 
			+ "PARTICIPANT.genre "
			+ "FROM CHRONO "
			+ "INNER JOIN PARTICIPANT ON CHRONO.id_participant = PARTICIPANT.id";
			
			stmt = conn.createStatement();
			// Exécution de la requête
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				LocalDateTime heureDepart = LocalDateTime.parse(rs.getString("heureDepart"),
						DateTimeFormatter.ISO_LOCAL_DATE_TIME);
				LocalDateTime heureArrivee = LocalDateTime.parse(rs.getString("heureArrivee"),
						DateTimeFormatter.ISO_LOCAL_DATE_TIME);
				Chrono chrono = new Chrono(heureDepart, heureArrivee);

				boolean nouveauParticipant = true;
				for (Participant participant : participants) {

					if (participant.getId() == rs.getInt("id")) {
						nouveauParticipant = false;
						participant.getChronoParEpreuve().put(new Epreuve(), chrono);
						break;
					}

				}
				if (nouveauParticipant) {
					Participant participant = new Participant();
					participant.setNom(rs.getString("nom"));
					participant.setPrenom(rs.getString("prenom"));
					int genre = rs.getInt("genre");					
					participant.setGenre(genre == GenreEnum.FEMME.ordinal()+1 ? GenreEnum.FEMME : GenreEnum.HOMME);
					participant.setId(rs.getInt("id"));
					 Map<Epreuve, Chrono> epreuveChronometres = new HashMap<>();
					 epreuveChronometres.put(new Epreuve(), chrono);
					 participant.setChronoParEpreuve(epreuveChronometres);
					 participants.add(participant);
				}

			}

			// Fermeture de la connexion
			conn.close();

		} catch (SQLException e) {
			System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return participants;

	}
}