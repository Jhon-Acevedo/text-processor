package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type Statics panel.
 */
public class StaticsPanel extends JPanel {
    private int numberWords;
    private JLabel jlNumberWords;
    private JLabel jlNumberLines;
    private JLabel jlNumberLetters;

    private JPTableElements jpTableElements;


    /**
     * Instantiates a new Statics panel.
     *
     * @param listener the listener
     */
    public StaticsPanel(ActionListener listener) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        setPreferredSize(new Dimension(400,100));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        jlNumberWords = new JLabel();
        jlNumberWords.setPreferredSize(new Dimension(getWidth(),50));
        jlNumberWords.setBackground(Color.red);
        add(jlNumberWords);

        jlNumberLines = new JLabel();
        jlNumberLines.setPreferredSize(new Dimension(getWidth(),50));
        add(jlNumberLines);

        jlNumberLetters = new JLabel();
        jlNumberLetters.setPreferredSize(new Dimension(getWidth(),50));
        add(jlNumberLetters);

        JButton buttonSave = new JButton("Save");
        buttonSave.setPreferredSize(new Dimension(getWidth(),50));
        buttonSave.addActionListener(listener);
        buttonSave.setActionCommand("save");
        //add(buttonSave);

        jpTableElements = new JPTableElements();
        add(jpTableElements);
    }

    /**
     * Sets number words.
     *
     * @param numberWords the number words
     * @param numberLines the number lines
     */
    public void setNumberWords(int numberWords, int numberLines) {
        jlNumberWords.setText("Numero de Palabras Usadas: " + numberWords);
        jlNumberLines.setText("Numero de Lineas: " + numberLines);
    }

    /**
     * Sets number letters.
     *
     * @param numberLetters the number letters
     */
    public void setNumberLetters(int numberLetters) {
        jlNumberLetters.setText("Numero de letras: " + numberLetters);
    }


    /**
     * Show matrix.
     *
     * @param matrix the matrix
     */
    public void showMatrix(Object[][] matrix) {
        jpTableElements.refresh(matrix);
    }

}
