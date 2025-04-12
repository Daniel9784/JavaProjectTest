package sk.tmconsulting.gui.knihaGUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class KniznicaGUI {
    private JFrame frame;
    // JList vyuzijeme na vizualne zobrazenie dat
    private JList<String> bookList;
    private JTextArea infoArea;
    // DefaultListModel uchovava zoznam s nazvami pre Jlist
    private DefaultListModel<String> listModel;
    // ArrayList uchovava objekty (Knihy)
    private ArrayList<Book> books = new ArrayList<>();
    private JPanel buttonPanel = new JPanel();

    public KniznicaGUI() {
        authorBooksData();
        createLayout();
    }

    private void authorBooksData() {
        Author a1 = new Author("J.K. Rowling", "British author, best known for the Harry Potter series.",59,"31.7.1965","Woman");
        Author a2 = new Author("J.R.R. Tolkien", "English writer, poet, and professor, author of The Lord of the Rings.",81,"3.1.1892","Man");

        books.add(new Book("Harry Potter", "A young wizard's journey through magic and danger.", a1));
        books.add(new Book("The Hobbit", "A hobbit's unexpected adventure with dwarves and a dragon.", a2));
    }

    private void createLayout() {
        frame = new JFrame("Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        // Vytvorenie zoznamu knih pouzitim defaultlistmodel
        listModel = new DefaultListModel<>();
        for (Book book : books) {
            listModel.addElement(book.getTitle());
        }
        // Jlist zobrazi knihy z defaultlistmodel
        bookList = new JList<>(listModel);
        infoArea = new JTextArea();
        infoArea.setEditable(false);
        // Na zalamovanie textu ak presiahne pole
        infoArea.setLineWrap(true);
        // Zalamovanie na konci celych slov
        infoArea.setWrapStyleWord(true);
        // Aby uzivatel mohol vybrat len jednu knihu naraz
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        bookList.addListSelectionListener(e -> {
            // Kontroluje ci je vybrana kniha aby sa kod mohol vykonat (inak to vyberalo knihu aj ked som nechcel)
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = bookList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    showBookDetails(books.get(selectedIndex));
                }
            }
        });
            // Priradenie bookListu a infoArea na west a center
        frame.add(new JScrollPane(bookList), BorderLayout.WEST);
        frame.add(new JScrollPane(infoArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void showBookDetails(Book book) {
        infoArea.setText("");
        infoArea.append("Title: " + book.getTitle() + "\n");
        infoArea.append("Description: " + book.getDescription() + "\n\n");

        // Vytvorenie tlacitka na autora
        JButton authorButton = new JButton("View Author: " + book.getAuthor().getName());
        authorButton.addActionListener(e -> showAuthorDetails(book.getAuthor()));

        // Odstranime obsah panelu lebo mi nechcelo updatovat meno pri vybere inej knihy a nasledne pridame nove tlacitko
        buttonPanel.removeAll();
        buttonPanel.add(authorButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Obnovenie okna aby nemizlo
        frame.revalidate();
        frame.repaint();
    }

    private void showAuthorDetails(Author author) {
        JOptionPane.showMessageDialog(frame,
                "Author: " + author.getName() + "\n\nAge: " + author.getAge() + "\n\nDate of birth: " + author.getDateofbirth() + "\n\nGender: " + author.getGender() + "\n\nBio: " + author.getBio(),
                "Author Info",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KniznicaGUI::new);
    }
}
