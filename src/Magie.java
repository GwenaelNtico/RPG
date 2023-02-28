import lombok.*;

@Getter
@Setter
@Builder

public class Magie {

    private int feu = 0;
    private int glace = 0;
    private int foudre = 0;
    private int poison = 0;
    private int soin = 0;
    private int protection = 0;
    private int renforcement = 0;
    private int guerison = 0;
    private int doubleFleche = 0;
    private int doubleAttaque = 0;

    void lancerMagie(Personnage lanceur, String nomMagie){

    }

    void ChangerTour(Personnage perso, Magie magie){
        if (magie.getFeu()>0) magie.setFeu(magie.getFeu()-1);
        if (magie.getFoudre()>0) magie.setFoudre(magie.getFoudre()-1);
        if (magie.getGlace()>0) magie.setGlace(magie.getGlace()-1);
        if (magie.getPoison()>0) magie.setPoison(magie.getPoison()-1);

        if (magie.getSoin()>0) magie.setSoin(magie.getSoin()-1);
        if (magie.getProtection()>0) magie.setProtection(magie.getProtection()-1);
        if (magie.getRenforcement()>0) magie.setRenforcement(magie.getRenforcement()-1);
        if (magie.getGuerison()>0) magie.setGuerison(magie.getGuerison()-1);

        if (magie.getDoubleAttaque()>0) magie.setDoubleAttaque(magie.getDoubleAttaque()-1);

        if (magie.getDoubleFleche()>0) magie.setDoubleFleche(magie.getDoubleFleche()-1);
    }

}
