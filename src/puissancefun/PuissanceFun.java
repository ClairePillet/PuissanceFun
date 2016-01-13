
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puissancefun;

import java.io.*;
import java.util.*;
import java.text.*;

public class PuissanceFun {

    public static void main(String[] args) throws Exception {
        int tour = 0;
        Pions joueurUn;
        Pions joueurDeux;
        char lookUn;
        char lookDeux;
        boolean verifChute;
        int rejouer;
        int menu = 0;
        int largeur = 4;
        int longueur = 4;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader rep = new BufferedReader(isr);

        System.out.println("***MENU PRINCIPAL***");
        System.out.println("1. Petit => Grille 4*4");
        System.out.println("2. Moyen  => Grille 8 * 8");
        System.out.println("3. Grand => Grille 12*12");
        System.out.println("4. Personnalise => Choisissez votre grille");

        menu = Integer.parseInt(rep.readLine());

        do {

            switch (menu) {
                case 1:
                    largeur = 4;
                    longueur = 4;
                    break;

                case 2:
                    largeur = 8;
                    longueur = 8;
                    break;
                case 3 :
                    largeur = 12;
                    longueur =12;
                    break;
                case 4:
                    System.out.println(
                            "Saisir une largeur: ");
                    largeur = Integer.parseInt(rep.readLine());

                    System.out.println(
                            "Saisir une longueur: ");
                    longueur = Integer.parseInt(rep.readLine());

                default:
                    break;

            }

            System.out.println(
                    "Choix apparence joueur 1: ");
            String s = rep.readLine();
            lookUn = s.charAt(0);
            joueurUn = new Pions(lookUn);

            System.out.println(
                    "Choix apparence joueur 2: ");
            s = rep.readLine();
            lookDeux = s.charAt(0);
            joueurDeux = new Pions(lookDeux);
            Plateau tab = new Plateau(largeur, longueur, joueurUn, joueurDeux);

            //    
            while (tab.checkVictoire()
                    != true) {
                //juste pour voir la matice en nombre non present dans l'appli final
                for (int i = 0; i < largeur; i++) {
                    for (int j = 0; j < longueur; j++) {
                        System.out.print(tab.plateau[i][j]);
                    }
                    System.out.println();
                }

                tab.affichage();
                if (tour % 2 == 0) {
                    System.out.println("Tour du joueur 1: ");
                    System.out.println("Saisir la colone ou placer le pion: ");
                    int choix = Integer.parseInt(rep.readLine());
                    //  tab.plateau[0][choix - 1] = -1;
                    tab.chute(choix - 1, -1);

                } else {
                    System.out.println("Tour du joueur 2: ");
                    System.out.println("Saisir la colone ou placer le pion: ");
                    int choix = Integer.parseInt(rep.readLine());
                    //    tab.plateau[0][choix - 1] = 1;
                    do {
                        verifChute = tab.chute(choix - 1, 1);
                        if (verifChute == false) {
                            System.out.println("Colonne pleine saisissez en une nouvelle.");
                            choix = Integer.parseInt(rep.readLine());
                        }

                    } while (verifChute == false);

                }
                tour++;
            }

            tab.affichage();

            System.out.println(
                    "Victoire !");

            System.out.println("Voulez vous rejouez ? Tapez 0 pour continuer");
            rejouer = Integer.parseInt(rep.readLine());

        } while (rejouer == 0);

    }

}//puissfun
