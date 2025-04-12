package sk.tmconsulting.gui;

import javax.swing.*;

public class ZmenaVzhladu {
    public static void main(String[] args) {
        try {
            // Automaticky nastaví natívny vzhľad podľa OS
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Teraz môžeme vytvoriť GUI
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Moja aplikácia");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.add(new JButton("Klikni ma"));
            frame.setLocationRelativeTo(null); // centrovanie okna
            frame.setVisible(true);
        });
    }
}