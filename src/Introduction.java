import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Introduction {

    Introduction() {

    }

    protected void ecrireIntro() {
        System.out.println("Bienvenue dans cet univers.");
        System.out.println("Vous pouvez choisir 3 personnages parmi les races suivantes : ");
        System.out.println("Humain > HP:20 ; MP:4 ; Force:10 ; Dexterite:10 ; Constitution:10 ; Intelligence:10");
        System.out.println("Elfe > HP:16 ; MP:6 ; Force:8 ; Dexterite:13 ; Constitution:8 ; Intelligence:11");
        System.out.println("Nain > HP:25 ; MP:3 ; Force:13 ; Dexterite:7 ; Constitution:12 ; Intelligence:8");
        System.out.println("Pour chaque personnage, vous pouvez choisir un métier : ");
        System.out.println("Guerrier > +4HP ; -2MP ; Force:+2 ; Dexterite:+0 ; Constitution:+1 ; Intelligence:-3");
        System.out.println("Archer > +0HP ; +0MP ; Force:-2 ; Dexterite:+4 ; Constitution:-1 ; Intelligence:-1");
        System.out.println("Pretre > -1HP ; +1MP ; Force:-1 ; Dexterite:-2 ; Constitution:+1 ; Intelligence:+2");
        System.out.println("Mage > -3HP ; +2MP ; Force:-3 ; Dexterite:-2 ; Constitution:-2 ; Intelligence:+6");
        System.out.println("Pour chaque métier, vous possédez des compétences consommant des MP : ");
        System.out.println("Guerrier > double attaque. Consomme 1MP. Utilisable tous les 2 tours");
        System.out.println("Archer > double flèche. Consomme 1MP. Utilisable tous les 2 tours");
        System.out.println("Pretre > Soin (1D4 + 1/5 intelligence). Consomme 1MP. Utilisable tout le temps");
        System.out.println("Pretre > Protection (+1 armure). Consomme 1MP. Dure 2 tours. Utilisable tous les 2 tours");
        System.out.println("Pretre > Renforcement (+1 dégats). Consomme 1MP. Dure 2 tours. Utilisable tous les 2 tours");
        System.out.println("Pretre > Guérison (soigne poison). Consomme 1MP. Utilisable tout le temps");
        System.out.println("Mage > feu (1D4 + 1/5 intelligence). Consomme 1MP. Utilisable tous les 2 tours");
        System.out.println("Mage > glace (1D4 + 1/5 intelligence). Consomme 1MP. Utilisable tous les 2 tours");
        System.out.println("Mage > foudre (1D4 + 1/5 intelligence). Consomme 1MP. Utilisable tous les 2 tours");
        System.out.println("Mage > poison (2 points de dégats par tour). Consomme 1MP. Dure 5 tours. Utilisable tous les 3 tours");
        System.out.println("A vous de jouer, constituez votre équipe !");
    }

    protected List<Character> creerEquipe(int tailleEquipe, int numeroEquipe) {

        List<Character> equipe = new ArrayList<Character>();
        while(equipe.size() < tailleEquipe){
            equipe.add(creerPersonnage(equipe.size(), numeroEquipe));
        }

        return equipe;
    }

    protected Character creerPersonnage(int characterNumber, int teamNumber) {
        String name = saisirNom(characterNumber);
        String race = putRace(characterNumber);
        String job = putJob(characterNumber);
        Magic magic = new Magic();


        //Builder
        return Character.builder()
                .name(name)
                .race(Race.valueOf(race))
                .job(Job.valueOf(job))
                .level(1)
                .characteristics(initCharacteristics(race, job))
                .teamNumber(teamNumber)
                .spells(magic.giveMeMagic(Job.valueOf(job)))
                .status(Status.alright)
                .build();

        /*
        Characteristics newCharacteristics = Characteristics.builder()
                .strength(this.characteristics.getStrength() + 2)
                .dexterity(this.characteristics.getDexterity() + 1)
                .constitution(this.characteristics.getConstitution() + 2)
                //TODO add characteristics upgrades when leveling up
                .build();
        return newCharacteristics;

         */
    }

    protected String saisirNom(int numeroPersonnage) {
        Scanner sc = new Scanner(System.in);
        int erreur = -1;
        String buff = "";

        switch (numeroPersonnage) {
            case 0 -> System.out.println("Tout d'abord, quel est le nom du premier personnage (20 caractères max) ?");
            case 1 -> System.out.println("Ensuite, quel est le nom du second personnage ?");
            case 2 -> System.out.println("Pour finir quel est le nom du dernier personnage ?");
            default -> System.out.println("Erreur boucle nom personnage :(");
        }

        while (erreur != 0) {
            buff = sc.nextLine();

            if (buff.length() > 20) {
                erreur = 2;
                System.out.println("Il y a plus de 20 caractères, tu sais lire des instructions ?");
            } else erreur = 0;

            if (buff.isBlank()) {
                erreur = 1;
                System.out.println("Il faut au moins un caractère non vide pfff..");
            }
        }
        return buff;
    }

    protected String putRace(int characterNumber) {
        Scanner sc = new Scanner(System.in);
        int error = -1;
        String buff = "";
        Race race;

                System.out.println("Quelle est la race du personnage ?");
                System.out.println("Tapez '1' pour Humain");
                System.out.println("Tapez '2' pour Elfe");
                System.out.println("Tapez '3' pour Nain");

            while (error != 0) {
                buff = sc.nextLine();
                error = 0;
                switch (buff) {
                    case "1" -> buff = "Human";
                    case "2" -> buff = "Elf";
                    case "3" -> buff = "Dwarf";
                    default -> {
                        System.out.println("Tapez '1' pour Humain, '2' pour Elfe ou '3' pour Nain");
                        error = 1;
                    }
                }

            }
        return buff;
    }

    protected String putJob(int numeroPersonnage) {
        Scanner sc = new Scanner(System.in);
        int error = -1;
        String buff = "";

        switch (numeroPersonnage) {
            case 0 -> {
                System.out.println("Quelle est le metier du premier personnage ?");
                System.out.println("Tapez '1' pour Guerrier");
                System.out.println("Tapez '2' pour Archer");
                System.out.println("Tapez '3' pour Pretre");
                System.out.println("Tapez '4' pour Mage");
            }
            case 1 -> {
                System.out.println("Quelle est le metier du second personnage ?");
                System.out.println("Tapez '1' pour Guerrier");
                System.out.println("Tapez '2' pour Archer");
                System.out.println("Tapez '3' pour Pretre");
                System.out.println("Tapez '4' pour Mage");
            }
            case 2 -> {
                System.out.println("Quelle est le metier du troisième personnage ?");
                System.out.println("Tapez '1' pour Guerrier");
                System.out.println("Tapez '2' pour Archer");
                System.out.println("Tapez '3' pour Pretre");
                System.out.println("Tapez '4' pour Mage");
            }
            default -> System.out.println("Erreur boucle metier personnage :(");
        }

        while (error != 0) {
            buff = sc.nextLine();
            error = 0;
            switch (buff) {
                case "1":
                    buff = "Guerrier";
                case "2":
                    buff = "Archer";
                case "3":
                    buff = "Pretre";
                case "4":
                    buff = "Mage";
                default:
                    System.out.println("Tapez '1' pour Guerrier, '2' pour Archer, '3' pour Pretre ou '4' pour Mage");
                    error = 1;
            }
        }
        return buff;
    }

    protected Characteristics initCharacteristics(String race, String metier){
        int strength = 0;
        int dexterity = 0;
        int constitution = 0;
        int wisdom = 0;
        int hp = 0;
        int mp = 0;
        int defense = 1;

        switch (race) {
            case "Humain" -> {
                strength += 10;
                dexterity += 10;
                constitution += 10;
                wisdom += 10;
                hp += 20;
                mp += 4;
            }
            case "Elfe" -> {
                strength += 8;
                dexterity += 13;
                constitution += 8;
                wisdom += 11;
                hp += 16;
                mp += 6;
            }
            case "Nain" -> {
                strength += 13;
                dexterity += 7;
                constitution += 12;
                wisdom += 8;
                hp += 25;
                mp += 3;
            }
            default -> System.out.println("Erreur dans l'init des caractéristiques");
        }

        switch (metier) {
            case "Guerrier" -> {
                strength += 2;
                dexterity += 0;
                constitution += 1;
                wisdom -= 3;
                hp += 4;
                mp -= 2;
                defense += 1;
            }
            case "Archer" -> {
                strength -= 2;
                dexterity += 4;
                constitution -= 1;
                wisdom -= 1;
                hp += 0;
                mp += 0;
                defense -= 1;
            }
            case "Pretre" -> {
                strength -= 1;
                dexterity -= 2;
                constitution += 1;
                hp -= 1;
                mp += 1;
                wisdom += 2;
            }
            case "Mage" -> {
                strength -= 3;
                dexterity -= 2;
                constitution -= 2;
                wisdom += 6;
                hp -= 3;
                mp += 2;
                defense -= 1;
            }
            default -> System.out.println("Erreur dans l'init des caractéristiques");
        }

        return Characteristics.builder()
                .strength(strength)
                .dexterity(dexterity)
                .constitution(constitution)
                .wisdom(wisdom)
                .hp(hp)
                .mp(mp)
                .defense(defense)
                .build();
    }

}