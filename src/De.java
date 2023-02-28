import static java.lang.Math.round;

public class De {

    int lancerDe(int nombreDes, int valeurDes){
        int resultat = 0;

        for (int i = 0; i < nombreDes; i++){
            // Récupère le résultat en entier pour i D XXX
            resultat += (int) round((Math.random() * valeurDes) + 1.0);
        }

        return resultat;
    }

}
