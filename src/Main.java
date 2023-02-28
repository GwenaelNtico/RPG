import java.util.List;

public class Main {
    public static void main(String[] args) {
        int tailleEquipe = 3;

        List<Personnage> equipe1;
        List<Personnage> equipe2;

        Introduction introduction = new Introduction();

        ConnectionBdd connectionBdd = new ConnectionBdd();

        Actions actions = new Actions();

        introduction.ecrireIntro();

        /* connectionBdd.recuperePersonnageBdd(); */

        System.out.println("Equipe 1");
        equipe1 = introduction.creerEquipe(tailleEquipe, 1);
        System.out.println("Equipe 2");
        equipe2 = introduction.creerEquipe(tailleEquipe, 2);

        /*
        while(actions.equipeMorte() == false){
            // ici ça joue
        }
         */

    }
}