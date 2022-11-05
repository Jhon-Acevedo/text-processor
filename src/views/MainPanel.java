package views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;

/**
 * The type Main panel.
 */
public class MainPanel extends JPanel {

    private JTextArea jTextArea;
    private StaticsPanel staticsPanel;

    private JList jList;

    /**
     * Instantiates a new Main panel.
     *
     * @param listener the listener
     */
    public MainPanel(ActionListener listener) {
        setLayout(new BorderLayout());

        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        add(jTextArea);

        staticsPanel = new StaticsPanel(listener);
        add(staticsPanel, BorderLayout.EAST);


    }

    /**
     * Gets text area.
     *
     * @return the text area
     */
    public String getjTextArea() {
        return jTextArea.getText();
    }

    /**
     * Update words.
     *
     * @param countWords the count words
     * @param numerLines the numer lines
     */
    public void updateWords(int countWords, int numerLines) {
        staticsPanel.setNumberWords(countWords, numerLines);
    }

    /**
     * Sets number letters.
     *
     * @param numberLetters the number letters
     */
    public void setNumberLetters(int numberLetters) {
        staticsPanel.setNumberLetters(numberLetters);
    }

    /**
     * Show matrix.
     *
     * @param matrix the matrix
     */
    public void showMatrix(Object[][] matrix) {
        staticsPanel.showMatrix(matrix);
    }


}
