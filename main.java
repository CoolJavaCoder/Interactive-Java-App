import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args){
        Window window = new Window();

        JLabel titlepg1 = new JLabel();
        titlepg1.setBounds(163,100,80,50);

        JButton startbtn = new JButton();
        startbtn.setBounds(163,100,80,50);
        startbtn.setFont(new Font("Arial", Font.BOLD, 20));
        startbtn.setText("Start");


        window.add(startbtn);
    }
}