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

    public static Pions joueurUn;
    public static Pions joueurDeux;
    //en attendant de régler le probleme de l'apparence:
    public static char lookUn;
    public static char lookDeux;

    public static void main(String[] args) throws Exception {
        int tour = 0;

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader rep = new BufferedReader(isr);

        System.out.println("Saisir une largeur: ");
        int largeur = Integer.parseInt(rep.readLine());

        System.out.println("Saisir une longueur: ");
        int longueur = Integer.parseInt(rep.readLine());

        Plateau tab = new Plateau(largeur, longueur);

        System.out.println("Choix apparence joueur 1: ");
        String s = rep.readLine();
        /* char*/ lookUn = s.charAt(0);

        Pions joueurUn = new Pions(lookUn);

        System.out.println("Choix apparence joueur 2: ");
        s = rep.readLine();
        /*char*/ lookDeux = s.charAt(0);

        joueurDeux = new Pions(lookDeux);

        while (Plateau.checkVictoire() != true) {

            for (int i = 0; i < largeur; i++) {
                for (int j = 0; j < longueur; j++) {
                    System.out.print(Plateau.plateau[i][j]);
                }
                System.out.println();
            }

            Plateau.affichage();
            if (tour % 2 == 0) {
                System.out.println("Tour du joueur 1: ");
                System.out.println("Saisir la colone ou placer le pion: ");
                int choix = Integer.parseInt(rep.readLine());
                Plateau.plateau[0][choix - 1] = -1;
                Plateau.chute();

            } else {
                System.out.println("Tour du joueur 2: ");
                System.out.println("Saisir la colone ou placer le pion: ");
                int choix = Integer.parseInt(rep.readLine());
                Plateau.plateau[0][choix - 1] = 1;
                Plateau.chute();

            }
            tour++;
        }

    }

}//puissfun
