package com.company;

import com.company.model.*;
import com.company.controller.*;
import com.company.view.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("salut");

        CLctrlGestionComptePersonne objGestion;
        ResultSet rs;

        objGestion = new CLctrlGestionComptePersonne();

        rs = objGestion.listerLesComptes();
        afficher(rs);

        objGestion.CreeUnCompte("X", "x");
        rs = objGestion.listerLesComptes();
        afficher(rs);
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
