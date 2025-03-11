package uloha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class novakalkulackaVzhlad {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulačka");
        frame.setSize(500,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel dlzkaNapis = new JLabel("Dĺžka:");
        dlzkaNapis.setBounds(100,100,100,25);
        frame.add(dlzkaNapis);

        JTextField dlzkaText = new JTextField(10);
        dlzkaText.setBounds(201,100,100,25);
        frame.add(dlzkaText);

        JLabel sirkaNapis = new JLabel("Šírka:");
        sirkaNapis.setBounds(100,150,100,25);
        frame.add(sirkaNapis);

        JTextField sirkaText = new JTextField(10);
        sirkaText.setBounds(201,150,100,25);
        frame.add(sirkaText);

        JButton obsah = new JButton("Obsah");
        obsah.setBounds(131,200,100,25);
        frame.add(obsah);

        JButton obvod = new JButton("Obvod");
        obvod.setBounds(271,200,100,25);
        frame.add(obvod);

        JLabel vysledok = new JLabel("           ");
        vysledok.setBounds(151,250,400,25);
        vysledok.setForeground(Color.black);
        vysledok.setFont(new Font("Arial",Font.BOLD,15));
        frame.add(vysledok);

        obsah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cislo1Obsah = Integer.parseInt(dlzkaText.getText());
                int cislo2Obsah = Integer.parseInt(sirkaText.getText());
                int vysledokObsah = cislo1Obsah * cislo2Obsah;
                vysledok.setText("Obsah obdĺžnika je: " + vysledokObsah + " m²");
            }
        });

        obvod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cislo1Obvod = Integer.parseInt(dlzkaText.getText());
                int cislo2Obvod = Integer.parseInt(sirkaText.getText());
                int vysledokObvod = 2* (cislo1Obvod + cislo2Obvod);
                vysledok.setText("Obvod obdĺžnika je: " + vysledokObvod + " m");
            }
        });
    }
}
