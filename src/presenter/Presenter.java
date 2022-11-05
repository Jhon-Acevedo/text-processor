package presenter;

import models.controlText;
import persistence.Persistence;
import views.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * The type Presenter.
 */
public class Presenter implements ActionListener {
    private MainFrame mainFrame; //View
    private Persistence persistence; //Persistence
    private controlText controlText; //Models
    private Timer threadPaint; //Threads

    private String text = "";

    /**
     * Instantiates a new Presenter.
     */
    public Presenter() {
        mainFrame = new MainFrame(this);
        controlText = new controlText();
        persistence = new Persistence();
        startThreadWrite();
    }

    /**
     * Start thread write.
     */
    public void startThreadWrite() {
        threadPaint = new Timer(500, e -> {
            text = mainFrame.getTextArea();
            mainFrame.repaint();
        });
        threadPaint.start();

        // Hilo que muestra el numero de letras
        new Timer(200, e -> {
            mainFrame.setNumberLetters(controlText.countLetter(text));
        }).start();

        // Hilos que guardan el texto en un archivo txt
        new Timer(400, e -> {
            persistence.setText(text);
        }).start();

        // Hilo que muestra el numero de palabras
        new Timer(400, e -> {
            mainFrame.updateWords(controlText.countWords(text), controlText.getLines(text));
        }).start();

        // Hilo que muestra la matriz de palabras repetidas
        new Timer(400, e -> {
            Object[][] matrix = controlText.showMatrixTable(text);
            mainFrame.showMatrix(matrix);
        }).start();

    }

    /**
     * Filechooser.
     */
    public void filechooser() {
        JFileChooser fileChooser = new JFileChooser();
//        guardar en una ruta especifica
        int seleccion = fileChooser.showSaveDialog(mainFrame);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String pathi = String.valueOf(file.getAbsoluteFile());
            persistence.setText(pathi);
        }
        fileChooser.showOpenDialog(mainFrame);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "save":
                filechooser();
                break;
        }
    }
}
