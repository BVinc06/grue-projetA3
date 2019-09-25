package com.company.view;

import javax.swing.*;
import java.awt.*;

public class frm_auth_panel extends JPanel  {
    public void paintComponent(Graphics g){
        System.out.println("Je suis exécutée !");
        g.fillOval(20, 20, 75, 75);
    }
}
