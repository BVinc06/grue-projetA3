package com.company.view;

import com.company.controller.CLctrlCrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_decrypt implements ActionListener {
    final String  PATH = "C:\\Users\\josep\\Desktop\\Folder\\";
    JFrame fen;
    frm_decrypt_panel pan;
    JTextField textField;
    String key_entered;
    int key_length;
    int key_generate_length;
    public frm_decrypt() {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int widthScreen = screen.width;
        int heightScreen = screen.height;

        fen = new JFrame();
        pan = new frm_decrypt_panel();

        fen.setTitle("DECRYPTAGE");
        fen.setLocation(widthScreen/4,heightScreen/4);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.setSize(widthScreen/2, heightScreen/2);
        fen.setResizable(false);
        fen.setAlwaysOnTop(true);
        fen.setContentPane(pan);
        textField = new JTextField(20);
        JLabel jlabel = new JLabel("<html><b>Entrer la cle de decryptage</b></html>");
        textField.addActionListener(this);
        fen.add(jlabel);
        fen.add(textField);

        fen.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        key_entered=actionEvent.getActionCommand();
        key_length=key_entered.length();
        key_generate_length=12-key_length;
        System.out.println("CLE DE DECRYPTAGE: "+key_entered +"   LONGUEUR: "+ key_length+"    LONGUEUR A GENERER: "+key_generate_length);
        textField.setEditable(false);

        //// OUVRIR A DECRYPT FICHIER ICI
        CLctrlCrypt fichier = new CLctrlCrypt();
        String reponse = fichier.lireFichierSimple(PATH  + "b.txt");

        fichier.generate_alphabet(key_entered,key_generate_length,reponse);
    }
}
