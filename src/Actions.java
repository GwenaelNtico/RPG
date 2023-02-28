import static java.lang.Math.round;

public class Actions {

    void Attaquer(Personnage attaquant, Personnage defenseur){
        boolean attaqueReussie = false;
        int touche = 0;
        int degats = 0;
        int resultatDe = 0;
        De de = new De();

        // On compare la dexterite des deux personnages *10 pour faire un pourcentage
        touche = attaquant.getDexterite() - defenseur.getDexterite() *10;
        // On met un minimum de 50% de chances de toucher l'adversaire
        if (touche<20) {touche = 20;}

        // remplacer nombre et valeur dé en fonction de l'arme / classe / métier utilisé
        resultatDe = de.lancerDe(1, 100);
        if (touche <= resultatDe){
            attaqueReussie = true;
            degats = (round(attaquant.getForce() / 5) + de.lancerDe(2, 4)) - defenseur.getArmure();
            if (resultatDe >= 99) {
                degats = (int) round(degats * 1.5);
            }
            if (defenseur.getHp() - degats < 0) {
                // PERSONNAGE MORT
                defenseur.setHp(0);
                defenseur.setMort(true);
                System.out.printf("%s est mort. RIP.%n", defenseur.getNom());
            }else defenseur.setHp(defenseur.getHp() - degats);

        }
    }

    void Soigner(Personnage soigneur, Personnage blesse){
        int soin = 0;
        int resultatDe = 0;
        De de = new De();

        resultatDe = de.lancerDe(1,4);
        soin = resultatDe + round(soigneur.getIntelligence() / 5);


    }

}
