import java.util.List;

public class Main {
    public static void main(String[] args) {
        int tailleEquipe = 3;

        List<Character> equipe1;
        List<Character> equipe2;

        Introduction introduction = new Introduction();
        ConnectionBdd connectionBdd = new ConnectionBdd();
        Actions actions = new Actions();
        Jeu jeu = new Jeu();

        // Explication personnage
        introduction.ecrireIntro();

        /* connectionBdd.recuperePersonnageBdd(); */

        // Création des équipes
        System.out.println("Equipe 1");
        equipe1 = introduction.creerEquipe(tailleEquipe, 1);
        System.out.println("Equipe 2");
        equipe2 = introduction.creerEquipe(tailleEquipe, 2);

        while (jeu.equipeMorte(equipe1) == true || jeu.equipeMorte(equipe2) == true) {
            // ici ça joue
        }

    }
}