import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

class Personnage {



    private String nom;
    private int hp;
    private String race;
    private String metier;
    private int mp;
    private int force;
    private int dexterite;
    private int intelligence;
    private int constitution;
    private int armure;

    Personnage(String nom, int hp, String race, String metier){
        this.nom = nom;
        this.hp = hp;
        this.race = race;
        this.metier = metier;
    }

    Personnage(String nom, int hp, int mp, int force, int dexterite, int intelligence, int constitution, int armure, String race, String metier){
        this.nom = nom;
        this.hp = hp;
        this.race = race;
        this.metier = metier;

        this.mp = mp;
        this.force = force;
        this.dexterite = dexterite;
        this.intelligence = intelligence;
        this.constitution = constitution;
        this.armure = armure;
    }

    public Personnage() {

    }


    enum race {
        humain,
        elfe,
        nain;

        race() {
        }
    }

    enum metier {
        guerrier,
        mage,
        pretre,
        archer;

        metier() {
        }
    }
}
