4
2
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

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader rep = new BufferedReader(isr);

        System.out.println(
                "Saisir une largeur: ");
        int largeur = Integer.parseInt(rep.readLine());

        System.out.println(
                "Saisir une longueur: ");
        int longueur = Integer.parseInt(rep.readLine());

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

                try {
                    int choix = Integer.parseInt(rep.readLine());

                    //  tab.plateau[0][choix - 1] = -1;
                    tab.chute(choix - 1, -1);
                } catch (Exception e) {
                    System.out.println("Nombre incorrect");
                }
            } else {
                System.out.println("Tour du joueur 2: ");
                System.out.println("Saisir la colone ou placer le pion: ");
                
                try{
                int choix = Integer.parseInt(rep.readLine());
                //    tab.plateau[0][choix - 1] = 1;
                do {
<<<<<<< HEAD
                    verifChute = tab.chute(choix - 1, 1);
                    if (verifChute == false) {
                        System.out.println("Colonne pleine saisissez en une nouvelle.");
                        choix = Integer.parseInt(rep.readLine());
                    }
=======
                    verifChute=tab.chute(choix - 1, 1);
                    if (verifChute == false)
                            {
                                System.out.println("Colonne pleine saisissez en une nouvelle.");
                                choix = Integer.parseInt(rep.readLine());
                            }
>>>>>>> origin/master

                } while (verifChute == false);
                
                }catch(Exception e){System.out.println("Choix incorrect");}
                
               

            }
            tour++;
        }

        tab.affichage();

        System.out.println(
                "Victoire !");

    }

}//puissfun
