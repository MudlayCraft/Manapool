import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Jan Schroeder, Felix Nilles
 * @version 0.0.1
 */
public class GUI {
    private JPanel enterData;
    private JComboBox formatSelector;
    private JTextField vlaueForest;
    private JTextField valueIsland;
    private JTextField valueMountain;
    private JTextField vlauePlains;
    private JTextField valueSwamp;
    private JTextField valueWaste;
    private JButton calculateButton;
    private JTabbedPane deckPanel;
    private JLabel resultForest;
    private JLabel resultIsland;
    private JLabel resultMountain;
    private JLabel resultPlains;
    private JLabel resultSwamp;
    private JLabel resultWaste;
    private JPanel panelResult;
    private JList decks;
    private JButton deckSearch;
    private JList deckDetails;
    private JPanel displayName;
    private JLabel title;

    public GUI() {
        JFrame frame = new JFrame("Manabase - Calculator");
        frame.setContentPane(enterData);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);

        formatSelector.addItem("Limited");
        formatSelector.addItem("Constructed");
        formatSelector.addItem("EDH");

        valueWaste.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calculate((String) formatSelector.getSelectedItem());
                }
            }
        });
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate((String) formatSelector.getSelectedItem());
            }
        });
        deckSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deckname = JOptionPane.showInputDialog(null, "Bitte gebe den Decknamen ein","Eingabe",JOptionPane.QUESTION_MESSAGE);
                Deck d = new Deck();
                d.deckname=deckname;
                d.deckList = Decklist.loadDeck(deckname);
                d.typ = Interactor.getFormat(d);

                decks.add(deckname,null);

            }
        });
        decks.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                title.setText((String)decks.getSelectedValue());

            }
        });
    }

    private void calculate(String selectedItem) {
        Interactor interactor = null;
        switch (selectedItem) {
            case "Limited":
                interactor = new Interactor(enums.DeckSize.LIMITED);
                break;
            case "Constructed":
                interactor = new Interactor(enums.DeckSize.CONSTRUCTED);
                break;
            case "EDH":
                interactor = new Interactor(enums.DeckSize.EDH);
                break;
            default:
                break;
        }

        int count = 0;

        count += Integer.parseInt(vlaueForest.getText());
        count += Integer.parseInt(valueIsland.getText());
        count += Integer.parseInt(valueMountain.getText());
        count += Integer.parseInt(vlauePlains.getText());
        count += Integer.parseInt(valueSwamp.getText());
        count += Integer.parseInt(valueWaste.getText());

        interactor.manapool.setIdentity(new double[]{Double.parseDouble(vlaueForest.getText()) / count,
                Double.parseDouble(valueIsland.getText()) / count,
                Double.parseDouble(valueMountain.getText()) / count,
                Double.parseDouble(vlauePlains.getText()) / count,
                Double.parseDouble(valueSwamp.getText()) / count,
                Double.parseDouble(valueWaste.getText()) / count});

        int[] id = interactor.manapool.getIdentity();

        resultForest.setText("" + id[0]);
        resultIsland.setText("" + id[1]);
        resultMountain.setText("" + id[2]);
        resultPlains.setText("" + id[3]);
        resultSwamp.setText("" + id[4]);
        resultWaste.setText("" + id[5]);

        deckPanel.setSelectedComponent(panelResult);

    }

    public static void main(String[] args) {
        new GUI();
    }
}
