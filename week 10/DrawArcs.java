import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawArcs extends JFrame {

    private int currentAngle = 0;
    private ArcsPanel arcsPanel;
    private Timer timer;
    private int spinSpeed = 0;

    public DrawArcs() {
        setTitle("DrawArcs");


        arcsPanel = new ArcsPanel();
        add(arcsPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        for (int i = 1; i <= 3; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new SpinButtonAction(i));
            buttonPanel.add(button);
        }
        JButton stopbutton = new JButton("Stop");
        stopbutton.addActionListener(new stopbutton());
        buttonPanel.add(stopbutton);

        add(buttonPanel, "South");

        // Create the timer for automatic spinning
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentAngle += spinSpeed;
                currentAngle %= 360;
                arcsPanel.repaint();
            }
        });
    }

    /** Main method */
    public static void main(String[] args) {
        DrawArcs frame = new DrawArcs();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    // The class for drawing arcs on a panel
    class ArcsPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int xCenter = getWidth() / 2;
            int yCenter = getHeight() / 2;
            int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
            int x = xCenter - radius;
            int y = yCenter - radius;

            // Draw arcs based on the current angle
            g.fillArc(x, y, 2 * radius, 2 * radius, currentAngle, 30);
            g.fillArc(x, y, 2 * radius, 2 * radius, currentAngle + 90, 30);
            g.fillArc(x, y, 2 * radius, 2 * radius, currentAngle + 180, 30);
            g.fillArc(x, y, 2 * radius, 2 * radius, currentAngle + 270, 30);
        }
    }

    // Action listener for the spin buttons
    private class SpinButtonAction implements ActionListener {
        private int speed;

        public SpinButtonAction(int speed) {
            this.speed = speed * 15; // Set speed based on button (0, 10, 20, 30 degrees)
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (speed == 0) {
                timer.stop();
            } else {
                spinSpeed = speed;
                timer.start();
            }
        }
    }
    class stopbutton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            timer.stop();
        }
    }
}
