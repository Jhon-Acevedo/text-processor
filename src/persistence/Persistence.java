package persistence;

import java.io.FileWriter;
import java.io.IOException;

public class Persistence extends Thread {
    private static final String FILE1 = "file.txt";

    private String text;

    public Persistence() {
        start();
    }

    @Override
    public void run() {
        while (true) try {
            writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile() throws IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FileWriter writer = new FileWriter(FILE1);
        writer.write(text);
        writer.close();
    }

    public void setText(String text) {
        this.text = text;
    }
}
