import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class main {
    public static void main(String[] args) {
        Window window = new Window();
        window.setSize(420,420);

        JTextArea editArea = new JTextArea();
        editArea.setBounds(50, 150, 300, 200); // Set bounds manually
        editArea.setVisible(false);           // Hidden until button click

        JButton saveButton = new JButton();
        saveButton.setBounds(50,90,110,50);
        saveButton.setText("Save");
        saveButton.setVisible(false);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save your file");

                // Suggest a default filename
                fileChooser.setSelectedFile(new File("*.txt"));

                int userSelection = fileChooser.showSaveDialog(window);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try {
                        FileWriter writer = new FileWriter(fileToSave);
                        writer.write(editArea.getText());
                        writer.close();
                        JOptionPane.showMessageDialog(window, "File saved:\n" + fileToSave.getAbsolutePath());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(window, "Error saving file.");
                    }
                }
            }
        });

        JButton loadButton = new JButton();
        loadButton.setBounds(165,90,110,50);
        loadButton.setText("Load file");
        loadButton.setVisible(false);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Open a file");

                int userSelection = fileChooser.showOpenDialog(window);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToOpen = fileChooser.getSelectedFile();
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileToOpen));
                        editArea.read(reader, null); // Loads into the JTextArea
                        reader.close();
                        JOptionPane.showMessageDialog(window, "File loaded:\n" + fileToOpen.getAbsolutePath());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(window, "Error loading file.");
                    }
                }
            }
        });

        JLabel titlepg1 = new JLabel("Welcome to JDocs!");
        titlepg1.setBounds(115, 0, 200, 50);
        titlepg1.setFont(new Font("Arial", Font.BOLD, 20));

        JButton startbtn = new JButton("Start JDocs Editor");
        startbtn.setBounds(105, 75, 210, 50);
        startbtn.setFont(new Font("Arial", Font.BOLD, 20));
        startbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadButton.setVisible(true);
                saveButton.setVisible(true);
                editArea.setVisible(true);
                startbtn.setVisible(false);
                titlepg1.setText("JDocs editor");
            }
        });


        window.add(saveButton);
        window.add(loadButton);
        window.add(titlepg1);
        window.add(startbtn);
        window.add(editArea);


        window.setVisible(true);  // Show the window
    }
}