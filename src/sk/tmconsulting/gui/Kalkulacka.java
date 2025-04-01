package sk.tmconsulting.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Kalkulacka {
    private JTextField vstup;
    private JLabel vysledok;

    public Kalkulacka() {
        JFrame frame = new JFrame("Kalkulačka");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 1));

        vstup = new JTextField();
        vysledok = new JLabel("Výsledok: ");
        JButton vypocitat = new JButton("Vypočítať");

        vypocitat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vypocitaj();
            }
        });

        frame.add(vstup);
        frame.add(vypocitat);
        frame.add(vysledok);

        frame.setVisible(true);
    }

    private void vypocitaj() {
        try {
            // Create a new JavaScript context using Rhino
            Context context = Context.enter();
            context.setOptimizationLevel(-1); // Disable optimizations for better debugging

            // Create a new scope for execution
            Scriptable scope = context.initStandardObjects();

            // Get the JavaScript expression from the input field
            String expression = vstup.getText();

            // Evaluate the expression
            Object result = context.evaluateString(scope, expression, "<stdin>", 1, null);

            // Display the result
            vysledok.setText("Výsledok: " + Context.toString(result));
        } catch (Exception ex) {
            vysledok.setText("Chybný výraz");
        } finally {
            // Exit the context to avoid memory leaks
            Context.exit();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Kalkulacka::new);
    }
}
