import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Circle extends JFrame{
    private int radius = 20;
    public Circle(){
        setTitle("Circle");
        CirclePanel circle = new CirclePanel();
        JButton increace = new JButton("increase");
        JButton decrease = new JButton("decrease");

        increace.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                radius+=5;
                circle.repaint();
            }
        });
        decrease.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                radius-=5;
                circle.repaint();
            }
        });
        setLayout(new BorderLayout());
        add(circle,BorderLayout.CENTER);

        JPanel panel = new JPanel();

        panel.add(increace);
        panel.add(decrease);
        add(panel,BorderLayout.SOUTH);

        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    
    class CirclePanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawOval(getWidth() / 2 - radius ,getHeight() / 2 - radius, 2 * radius, 2 * radius);
    
        }
    }
    public static void main(String[] args) {
        new Circle();
    }
}
