import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Frame extends JFrame implements ActionListener {
    Frame() {
        this.setTitle("Hello to GUI Swing");
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(360, 200);
        // this.setLayout(new FlowLayout());
        // this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

public class GUISwing {
    public static void main(String[] args) throws Exception {
        // Frame frame = new Frame();
        // JLabel label = new JLabel();
        // label.setText("Hello World");
        // frame.add(label);
        // JTextField pathField = new JTextField();
        // pathField.setPreferredSize(new Dimension(100, 40));
        // pathField.add(pathField);
        File myObj = new File("hello.html");
        Scanner myReader = new Scanner(myObj);
        String fileData = "";
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            fileData = fileData + (data + "\n");
        }
        String meta = "<meta http-equiv='refresh' content='5; url=http://localhost:8080'>";
        String[] lines =  fileData.split("\n");
        for (String string : lines) {
            System.out.println(string);
        }
        System.out.println(fileData);

    }
}

// class Something {
// public <T> T func(T a) {
// return a;
// }
// }