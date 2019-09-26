package com.company;

import com.company.model.*;
import com.company.controller.*;
import com.company.view.*;

import java.sql.ResultSet;
import java.sql.SQLException;



public class Main {
    public static void main(String[] args) {

        final String  PATH = "D:\\Documents\\Cours Exia A3\\UE MAD MAX\\project\\test\\";
        final String KEY = "awqpudertjutl";

        //CONNEXION DATABASE
        CLctrlGestionComptePersonne objGestion;
        ResultSet rs;

        objGestion = new CLctrlGestionComptePersonne();

        rs = objGestion.listerLesComptes();
        afficher(rs);

        objGestion.CreeUnCompte("X", "x");
        rs = objGestion.listerLesComptes();
        afficher(rs);

        // CRYPTAGE DECRYPTAGE + LOAD FILES
        CLctrlCrypt o1;
        String reponse;

        o1 = new CLctrlCrypt();
        o1.ecrireFichierSimple( PATH + "a.txt", "Campus d’enseignement superieur et de formation professionnelle, CESI poursuit sa mission societale en permettant à des etudiants, alternants et salaries de devenir acteurs des transformations des entreprises et de la societe, grace a ses ecoles et activites.");

        reponse = o1.lireFichierSimple(PATH + "a.txt");
        System.out.println(reponse);

        reponse = o1.crypter(reponse, KEY);
        System.out.println(reponse);
        o1.ecrireFichierSimple(PATH + "b.txt", reponse);

        reponse = o1.lireFichierSimple(PATH  + "b.txt");
        reponse = o1.decrypter(reponse, KEY);
        o1.ecrireFichierSimple(PATH + "c.txt", reponse);
        System.out.println(reponse);

        System.out.println("Terminé");


        frm_auth auth = new frm_auth();

    }

    public static void afficher(ResultSet dataRows) {
        /* Récupération des données du résultat de la requête de lecture */
        try {
            /* Récupération des données du résultat de la requête de lecture */
            while ( dataRows.next() ) {
                for (int i = 1; i <= dataRows.getMetaData().getColumnCount(); i++) {
                    System.out.print(dataRows.getString(i) + " ; ");
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
