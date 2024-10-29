import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorChangerApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ColorChangerApp");
        JButton redButton = new JButton("red");
        JButton blueButton = new JButton("blue");
        JButton greenButton = new JButton("green");

        redButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.RED);
            }
        });

        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.BLUE);
            }
        });

        greenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.GREEN);
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(redButton);
        frame.add(blueButton);
        frame.add(greenButton);
        frame.setSize(300, 200);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
