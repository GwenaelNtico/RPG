import lombok.*;

@Getter
@Setter
@Builder
class Personnage {

    @NonNull
    private String nom;
    private String race;
    private String metier;
    private int hp;
    private int mp;
    private int force;
    private int dexterite;
    private int constitution;
    private int intelligence;
    private int armure;
    private boolean mort;
    private int numeroEquipe;
    private Magie magie;

    enum Race {
        humain,
        elfe,
        nain;

        Race() {
        }
    }

    enum Metier {
        guerrier,
        mage,
        pretre,
        archer;

        Metier() {
        }
    }
}
