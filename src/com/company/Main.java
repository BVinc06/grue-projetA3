package com.company;

import com.company.model.*;
import com.company.controller.*;
import com.company.view.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // DECLARATION CONNECTION DATABASE
        CLcad con = new CLcad("jdbc:mysql://localhost:3306/tb_personne?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false& serverTimezone=UTC", "root", "");
        System.out.println(con.getCon());

        // EXECUTION QUERY REQUEST
        ResultSet resultat = con.m_getRows("SELECT * FROM TB_PERSONNE;");
        con.m_showRows(resultat);

        // EXECUTION UPDATE QUERY
        System.out.println(con.m_actionRows("INSERT INTO TB_PERSONNE (name, firstName) VALUES ('Test','Projet')"));

    }
}
