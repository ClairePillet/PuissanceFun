/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puissancefun;

import java.util.*;

public class Plateau {

    //attributs
    public static int longueur;
    public static int largeur;
    public static int[][] plateau;

    //constructeurs
    public Plateau(int largeur, int longeur) {
        this.largeur = largeur;
        this.longueur = longeur;
    }

    public Plateau() {
        this.largeur = 5;
        this.longueur = 5;
    }

	//methodes
    public  void initialisation() {
        plateau = new int[largeur][longueur];
        for (int i = 0; i < largeur; i++) {
            Random r = new Random();
            int val = r.nextInt(longueur);
            for (int j = 0; j < longueur; j++) {
                plateau[i][j] = 0;
                plateau[i][val] = 2;

            }
        }
    }

    public static void affichage() {
        int l = 0;
        System.out.println();
        while (l <= 2 * longueur) {
            System.out.print('-');
            l++;
        }

        for (int i = 0; i < largeur; i++) {
            System.out.println();
            for (int j = 0; j < longueur; j++) {
                System.out.print('|');
                if (plateau[i][j] == 0) {
                    System.out.print(' ');
                }
                if (plateau[i][j] == 2) {
                    System.out.print('.');
                }
                if (plateau[i][j] == -1) {
                    System.out.print(PuissanceFun.lookUn/*joueurUn.apparence*/);
                }
                if (plateau[i][j] == 1) {
                    System.out.print(PuissanceFun.lookDeux/*joueurDeux.apparence*/);
                }

            }
            System.out.print("|\n");
            l = 0;
            while (l <= 2 * longueur) {
                System.out.print('-');
                l++;
            }
        }

        System.out.println();
    }

    public static void chute() {
        for (int j = 0; j < longueur; j++) {
            if (plateau[0][j] != 0 && plateau[0][j] != 2) {
                int i = 0;
                while (i < largeur - 1 && (plateau[i + 1][j] != -1 && plateau[i + 1][j] != 1)) {
                    int tmp = plateau[i + 1][j];
                    if (plateau[i + 1][j] == 2) {
                        int b = 2;
                        plateau[i + 1][j] = plateau[i][j];
                        plateau[i][j] = 0;
                    } else {
                        plateau[i + 1][j] = plateau[i][j];
                        plateau[i][j] = tmp;
                    }
                    i++;
                }
            }
        }
    }

    public static boolean checkVictoire() {
        int cpt;
        boolean victoire = false;

        cpt = 0;
        for (int i = largeur - 1; i >= 0; i--) {
            for (int j = 0; j < longueur - 1; j++) {
                if (plateau[i][j] != 0) {
                    if (/*(plateau[i][j]!= 0 && plateau[i][j]!=2) &&*/plateau[i][j] == plateau[i][j + 1]) {
                        cpt++;
                    } else {
                        cpt = 0;
                    }
                }
            }
            if (cpt == 4) {
                victoire = true;
            }
        }

    
                /*cpt=0;
                 for(int i = 0; i < largeur-1; ii++){
                 for(int jj = 0; jj < longueur-1; jj++){
                 if(plateau[i][jj] == plateau[i+1][jj+1]){
                 cpt++;
                 }else{
                 cpt--;
                 }
                 i++;
                 }
                 }
                 if(cpt==4) return True;
                 //fin test diagonale gauche
                 *///En cours de réalisation
                /*cpt=0;
                 for(int ii = 0; ii < largeur-1; ii++){
                 for(int jj = longueur-1; jj > 1 ; jj++){
                 if(plateau[ii][jj] == plateau[ii+1][jj-1]){
                 cpt++;
                 }else{
                 cpt--;
                 }
                 ii++;
                 }
                 }
                 if(cpt==4) return True;
                 //fin test diagonale droite
                 *///En cours de réalisation
        cpt = 0;
        for (int j = 0; j < longueur; j++) {
            for (int i = largeur - 1; i > 0; i--) {
                if (plateau[i][j] != 0) {
                    if (/*(plateau[i][j]!= 0 && plateau[i][j]!=2) &&*/plateau[i][j] == plateau[i - 1][j]) {
                        cpt++;
                    } else {
                        cpt = 0;
                    }
                }
            }
            if (cpt == 4) {
                victoire = true;
            }
        }//fin test vertical
        return victoire;
    }

}//fin Plateau
