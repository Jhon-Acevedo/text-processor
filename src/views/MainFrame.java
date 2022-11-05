package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * The type Main frame.
 */
public class MainFrame extends JFrame {
    private MainPanel mainPanel;

    /**
     * Instantiates a new Main frame.
     *
     * @param listener the listener
     */
    public MainFrame(ActionListener listener) {
        setIconImage(new ImageIcon(getClass().getResource("/img/Icon.png")).getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,800);
        setLocationRelativeTo(null);
        initComponents(listener);
        setVisible(true);
        setTitle("Text Editor");
    }

    private void initComponents(ActionListener listener) {
        mainPanel = new MainPanel(listener);
        add(mainPanel);
    }


    /**
     * Get text area string.
     *
     * @return the string
     */
    public String getTextArea(){
       return  mainPanel.getjTextArea();
    }


    /**
     * Update words.
     *
     * @param countWords  the count words
     * @param numberLines the number lines
     */
    public void updateWords(int countWords, int numberLines) {
        mainPanel.updateWords(countWords , numberLines);
    }

    /**
     * Sets number letters.
     *
     * @param numberLetters the number letters
     */
    public void setNumberLetters(int numberLetters) {
        mainPanel.setNumberLetters(numberLetters);
    }

    /**
     * Show matrix.
     *
     * @param matrix the matrix
     */
    public void showMatrix(Object[][] matrix){
        mainPanel.showMatrix(matrix);
    }
}
