import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    public static void main(String[] args){
        Window window = new Window();

        JLabel titlepg1 = new JLabel();
        titlepg1.setBounds(115,0,200,50);
        titlepg1.setFont(new Font("Arial", Font.BOLD, 20));
        titlepg1.setText("Welcome to JDocs!");

        JButton startbtn = new JButton();
        startbtn.setBounds(105,75,210,50);
        startbtn.setFont(new Font("Arial", Font.BOLD, 20));
        startbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startbtn.setVisible(false);
                titlepg1.setVisible(false);
            }
        });
        startbtn.setText("Start JDocs Editor");

        window.add(titlepg1);
        window.add(startbtn);
    }
}