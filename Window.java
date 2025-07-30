import javax.swing.*;

public class Window extends JFrame {

    Window(){
        this.setResizable(false);
        this.setSize(420,420);
        this.setTitle("JDocs");
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}