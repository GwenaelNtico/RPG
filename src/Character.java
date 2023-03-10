import lombok.*;

import static java.lang.Math.round;

@Getter
@Setter
@Builder
class Character {

    @NonNull
    private String name;
    private Race race;
    private Job job;
    private int level;
    private int hp;
    private int mp;
    private Characteristics characteristics;
    private int teamNumber;
    private Magic magic;

    public int attack(Character attacker, Character target) {
        int touche = 0;
        int degats = 0;
        int resultatDe = 0;
        De de = new De();

        // On compare la dexterite des deux personnages *10 pour faire un pourcentage
        touche = attacker.characteristics.getDexterity() - target.getCharacteristics().getDexterity() *10;
        // On met un minimum de 20% de chances de toucher l'adversaire
        if (touche<20) {touche = 20;}

        // remplacer nombre et valeur dé en fonction de l'arme / classe / métier utilisé
        resultatDe = de.lancerDe(1, 100);
        if (touche <= resultatDe){
            degats = (round(attacker.characteristics.getStrength() / 5) + de.lancerDe(2, 4)) - target.getCharacteristics().getDefense();
            if (resultatDe >= 99) {
                degats = (int) round(degats * 1.5);
            }
            if (target.getHp() - degats < 0) {
                target.setHp(0);
            }else target.setHp(target.getHp() - degats);
            System.out.printf("Attaque réussie ! %s a infligé " + Integer.toString(degats) + " !", attacker.getName());
            if (target.isDead()==true) System.out.printf("%s est mort. RIP.%n", target.getName());
        }
        return 0; // returns remaining healthPoint
    }

    public int heal(Character healer, Character target){
        //TODO Write heal method
        return 0;    //returns the number of HP healed
    }

    public boolean isDead() { return hp == 0; }

    public void levelUp(Character character){
        character.level += +1;
        hp = hp + hp /2;
        mp = mp + mp / 3;
        character.characteristics = levelUpCharacteristics();
    }

    private Characteristics levelUpCharacteristics() {
        Characteristics newCharacteristics = Characteristics.builder()
                .strength(this.characteristics.getStrength() + 2)
                .dexterity(this.characteristics.getDexterity() + 1)
                .constitution(this.characteristics.getConstitution() + 2)
                //TODO add characteristics upgrades when leveling up
                .build();
        return newCharacteristics;
    }

    private void giveMagic(Character character){
        Magic magic = new Magic();
        
    }

}
