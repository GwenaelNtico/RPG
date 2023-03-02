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

    protected Character creerPersonnage(int numeroPersonnage, int numeroEquipe) {
        String nom = saisirNom(numeroPersonnage);
        String race = saisirRace(numeroPersonnage);
        String metier = saisirMetier(numeroPersonnage);

        //Builder
        return Character.builder()
                .name(nom)
                .race(race)
                .job(metier)
                .force(initForce(race, metier))
                .dexterite(initDexterite(race, metier))
                .constitution(InitConstitution(race, metier))
                .intelligence(InitIntelligence(race, metier))
                .hp(InitHP(race, metier))
                .mp(InitMP(race, metier))
                .armure(1)
                .mort(false)
                .teamNumber(numeroEquipe)
                .build();
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

    protected String saisirRace(int numeroPersonnage) {
        Scanner sc = new Scanner(System.in);
        int erreur = -1;
        String buff = "";

        switch (numeroPersonnage) {
            case 0 -> {
                System.out.println("Quelle est la race du premier personnage ?");
                System.out.println("Tapez '1' pour Humain");
                System.out.println("Tapez '2' pour Elfe");
                System.out.println("Tapez '3' pour Nain");
            }
            case 1 -> {
                System.out.println("Quelle est la race du second personnage ?");
                System.out.println("Tapez '1' pour Humain");
                System.out.println("Tapez '2' pour Elfe");
                System.out.println("Tapez '3' pour Nain");
            }
            case 2 -> {
                System.out.println("Quelle est la race du troisième personnage ?");
                System.out.println("Tapez '1' pour Humain");
                System.out.println("Tapez '2' pour Elfe");
                System.out.println("Tapez '3' pour Nain");
            }
            default -> System.out.println("Erreur boucle race personnage :(");
        }

            while (erreur != 0) {
                buff = sc.nextLine();
                erreur = 0;
                switch (buff) {
                    case "1" -> buff = "Humain";
                    case "2" -> buff = "Elfe";
                    case "3" -> buff = "Nain";
                    default -> {
                        System.out.println("Tapez '1' pour Humain, '2' pour Elfe ou '3' pour Nain");
                        erreur = 1;
                    }
                }

            }
        return buff;
    }

    protected String saisirMetier(int numeroPersonnage) {
        Scanner sc = new Scanner(System.in);
        int erreur = -1;
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

        while (erreur != 0) {
            buff = sc.nextLine();
            erreur = 0;
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
                    erreur = 1;
            }
        }
        return buff;
    }

    protected int initForce(String race, String metier){
        int force = 0;

        switch (race) {
            case "Humain" -> force += 10;
            case "Elfe" -> force += 8;
            case "Nain" -> force += 13;
            default -> System.out.println("Erreur dans l'init de la force pour la race (elle n'est pas en toi) :(");
        }

        switch (metier) {
            case "Guerrier" -> force += 2;
            case "Archer" -> force -= 2;
            case "Pretre" -> force -= 1;
            case "Mage" -> force -= 3;
            default -> System.out.println("Erreur dans l'init de la force pour le metier (elle n'est pas en toi) :(");
        }

        return force;
    }

    protected int initDexterite(String race, String metier){
        int dexterite = 0;

        switch (race) {
            case "Humain" -> dexterite += 10;
            case "Elfe" -> dexterite += 13;
            case "Nain" -> dexterite += 7;
            default -> System.out.println("Erreur dans l'init de la dexterite pour la race :(");
        }

        switch (metier) {
            case "Guerrier" -> dexterite += 0;
            case "Archer" -> dexterite += 4;
            case "Pretre" -> dexterite -= 2;
            case "Mage" -> dexterite -= 2;
            default -> System.out.println("Erreur dans l'init de la dexterite pour le metier :(");
        }

        return dexterite;
    }

    protected int InitConstitution(String race, String metier){
        int constitution = 0;

        switch (race) {
            case "Humain" -> constitution += 10;
            case "Elfe" -> constitution += 8;
            case "Nain" -> constitution += 12;
            default -> System.out.println("Erreur dans l'init de la constitution pour la race :(");
        }

        switch (metier) {
            case "Guerrier" -> constitution += 1;
            case "Archer" -> constitution -= 1;
            case "Pretre" -> constitution += 1;
            case "Mage" -> constitution -= 2;
            default -> System.out.println("Erreur dans l'init de la constitution pour le metier :(");
        }

        return constitution;
    }

    protected int InitIntelligence(String race, String metier){
        int intelligence = 0;

        switch (race) {
            case "Humain" -> intelligence += 10;
            case "Elfe" -> intelligence += 11;
            case "Nain" -> intelligence += 8;
            default -> System.out.println("Erreur dans l'init de l'intel pour la race :(");
        }

        switch (metier) {
            case "Guerrier" -> intelligence -= 3;
            case "Archer" -> intelligence -= 1;
            case "Pretre" -> intelligence += 2;
            case "Mage" -> intelligence += 6;
            default -> System.out.println("Erreur dans l'init de l'intel pour le metier) :(");
        }

        return intelligence;
    }

    protected int InitHP(String race, String metier){
        int hp = 0;

        switch (race) {
            case "Humain" -> hp += 20;
            case "Elfe" -> hp += 16;
            case "Nain" -> hp += 25;
            default -> System.out.println("Erreur dans l'init des hp pour la race :(");
        }

        switch (metier) {
            case "Guerrier" -> hp += 4;
            case "Archer" -> hp += 0;
            case "Pretre" -> hp -= 1;
            case "Mage" -> hp -= 3;
            default -> System.out.println("Erreur dans l'init des hp pour le metier) :(");
        }

        return hp;
    }

    protected int InitMP(String race, String metier){
        int mp = 0;

        switch (race) {
            case "Humain" -> mp += 4;
            case "Elfe" -> mp += 6;
            case "Nain" -> mp += 3;
            default -> System.out.println("Erreur dans l'init des mp pour la race :(");
        }

        switch (metier) {
            case "Guerrier" -> mp -= 2;
            case "Archer" -> mp += 0;
            case "Pretre" -> mp += 1;
            case "Mage" -> mp += 2;
            default -> System.out.println("Erreur dans l'init des mp pour le metier) :(");
        }

        return mp;
    }

}