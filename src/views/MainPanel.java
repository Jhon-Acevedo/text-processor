package views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;

public class MainPanel extends JPanel {

    private JTextArea jTextArea;
    private StaticsPanel staticsPanel;

    private JList jList;

    public MainPanel(ActionListener listener) {
        setLayout(new BorderLayout());

        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        add(jTextArea);

        staticsPanel = new StaticsPanel(listener);
        add(staticsPanel, BorderLayout.EAST);


    }

    public String getjTextArea() {
        return jTextArea.getText();
    }

    public void updateWords(int countWords, int numerLines) {
        staticsPanel.setNumberWords(countWords, numerLines);
    }

    public void setNumberLetters(int numberLetters) {
        staticsPanel.setNumberLetters(numberLetters);
    }

    public void showMatrix(Object[][] matrix) {
        staticsPanel.showMatrix(matrix);
    }


}
