import java.awt.*;
import java.sql.*;

public class ConnectionBdd {

    // Les variables nécessaires
    static Connection conn;
    static Statement state;
    static ResultSet result;
    static ResultSetMetaData resultMeta;
    static Object[][] donn;
    static String[] champs;
    static Object[] val;
    static String tableBDD = "personnage";

    // Démarrage de l'application
    public void recuperePersonnageBdd() {
        EventQueue.invokeLater(new Runnable() {

            // Ma méthode "Run"
            public void run() {

                // Informations de connexion
                String BDD = "rpg";
                String url = "jdbc:mysql://localhost:3306/" + BDD;
                String user = "root";
                String passwd = "Atisinsim59211!MS";

                // Vérification de la connexion avec la base de données
                try {
                    //Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(url, user, passwd);
                    System.out.println("Connecter");

                    // Déclaration de la connexion avec la base de donnée
                    Statement state = conn.createStatement();
                    //L'objet ResultSet contient le résultat de la requête SQL
                    ResultSet result = state.executeQuery("SELECT * FROM personnage");
                    //On récupère les MetaData
                    ResultSetMetaData resultMeta = result.getMetaData();

                    // Affiche d'un séparateur visuel (oui, c'est pas très propre, mais libre à vous de le modifié)
                    System.out.println("\n*************************************************************");

                    // On affiche le nom des colonnes
                    for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                        System.out.print("  " + resultMeta.getColumnName(i).toUpperCase() + " ");

                    // Un nouveau séparateur visuel
                    System.out.println("\n*************************************************************");

                    // On affiche les données ligne par ligne
                    while(result.next()){
                        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                            System.out.print("      " + result.getObject(i).toString() + "      ");
                        System.out.println("\n-------------------------------------------------------------");
                    }

                    // On ferme tout les connexion à la base de données
                    result.close();
                    state.close();
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Erreur");
                    System.exit(0);
                }
            }
        });
    }

}
