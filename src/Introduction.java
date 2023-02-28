import org.jetbrains.annotations.NotNull;

import java.util.Scanner;


public class Texte {

    Texte(){

    }

     protected void ecrireIntro(){
        System.out.println("Bienvenue dans cet univers.");
        System.out.println("Vous pouvez choisir 3 personnages parmi les races suivantes : ");
        System.out.println("Humain > HP:10 ; MP:3 ");
        System.out.println("Elfe > HP:8 ; MP:5 ");
        System.out.println("Nain > HP:12 ; MP:2 ");
        System.out.println("Pour chaque personnage, vous pouvez choisir un métier : ");
        System.out.println("Guerrier > +2HP ; -1MP ");
        System.out.println("Archer > +0HP ; +0MP ");
        System.out.println("Pretre > -1HP ; +1MP ");
        System.out.println("Mage > -2HP ; +2MP ");
        System.out.println("Une fois votre choix effectué, vous pourrez disposer vos points de stats suivants : ");
        System.out.println("Force, Dexterite, Constitution, Intelligence");
        System.out.println("Vous pouvez ajouter des points mais aussi en retirer jusqu'au minimum de 5 (base de 10, max 20).");
        System.out.println("A vous de jouer, constituez votre équipe !");
    }

    

    protected void saisirNom(int tailleEquipe, Personnage... equipe){
        Scanner sc = new Scanner(System.in);
        int erreur = -1;
        String buff = "";

        for(int i = 0; i <= tailleEquipe; i++) {
            switch (i){
                case 0:
                    System.out.println("Tout d'abord, quel est le nom du premier personnage (20 caractères max) ?");
                    break;
                case 1:
                    System.out.println("Ensuite, quel est le nom du second personnage ?");
                    break;
                case 2:
                    System.out.println("Pour finir quel est le nom du dernier personnage ?");
                    break;
                default:
                    System.out.println("Erreur boucle nom personnage :(");
                    break;
            }

            while (erreur != 0) {
                buff = sc.nextLine();

                if (buff.length() > 20) {
                    erreur = 2;
                    System.out.println("Il y a plus de 20 caractères, tu sais lire des instructions ?");
                }
                if (buff.isBlank() == true) {
                    erreur = 1;
                    System.out.println("Il faut au moins un caractère non vide pfff..");
                }
            }
            i += 1;
        }

    }

    protected void saisirRace(int tailleEquipe, Personnage... equipe){
        Scanner sc = new Scanner(System.in);
        int erreur = -1;
        String buff = "";

        for(int i = 0; i <= tailleEquipe; i++) {
            switch (i){
                case 0:
                    System.out.println("Quelle est la race du premier personnage ?");
                    break;
                case 1:
                    System.out.println("Quelle est la race du second personnage ?");
                    break;
                case 2:
                    System.out.println("Quelle est la race du troisième personnage ?");
                    break;
                default:
                    System.out.println("Erreur boucle race personnage :(");
                    break;
            }

            erreur = -1;

            while (erreur != 0) {
                buff = sc.nextLine();

                switch (buff){
                    case "Humain":
                        AjouterHP(equipe[i], 10);
                        SoustraireMP(equipe[i], 3);
                        break;
                    case "Elfe":
                        AjouterHP(equipe[i], 8);
                        SoustraireMP(equipe[i], 5);
                        break;
                    case "Nain":
                        AjouterHP(equipe[i], 12);
                        SoustraireMP(equipe[i], 2);
                        break;
                    default:
                        System.out.println("Il n'y a que 3 choix possibles : Humain, Elfe ou Nain");
                        break;
                }
            }
        }
    }

    protected void saisirMetier(int tailleEquipe, Personnage... equipe){
        Scanner sc = new Scanner(System.in);
        int erreur = -1;
        String buff = "";

        for(int i = 0; i <= tailleEquipe; i++) {
            switch (i){
                case 0:
                    System.out.println("Quelle est le metier du premier personnage ?");
                    break;
                case 1:
                    System.out.println("Quelle est le metier du second personnage ?");
                    break;
                case 2:
                    System.out.println("Quelle est le metier du troisième personnage ?");
                    break;
                default:
                    System.out.println("Erreur boucle metier personnage :(");
                    break;
            }

            erreur = -1;

            while (erreur != 0) {
                buff = sc.nextLine();

                switch (buff){
                    case "Guerrier":
                        AjouterHP(equipe[i], 2);
                        SoustraireMP(equipe[i], 1);
                        break;
                    case "Archer":
                        AjouterHP(equipe[i], 0);
                        SoustraireMP(equipe[i], 0);
                        break;
                    case "Pretre":
                        SoustraireHP(equipe[i], 1);
                        AjouterMP(equipe[i], 1);
                        break;
                    case "Mage":
                        SoustraireHP(equipe[i], 2);
                        AjouterMP(equipe[i], 2);
                        break;
                    default:
                        System.out.println("Il n'y a que 4 choix possibles : Guerrier, Archer, Pretre ou Mage");
                        break;
                }
            }
        }
    }

    protected void AjouterHP(@NotNull Personnage perso, int soin){
        perso.setHp(perso.getHp()+soin);
    }

    protected void SoustraireHP(@NotNull Personnage perso, int soin){
        perso.setHp(perso.getHp()-soin);
    }

    protected void AjouterMP(@NotNull Personnage perso, int soin){
        perso.setMp(perso.getMp()+soin);
    }

    protected void SoustraireMP(@NotNull Personnage perso, int soin){
        perso.setMp(perso.getMp()-soin);
    }
}