import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorldSwing2 {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Hello World Swing App");

        // Create panel to hold components
        JPanel panel = new JPanel();

        // Create label
        JLabel label = new JLabel("Hello World!");

        // Create button
        JButton button = new JButton("Click Me!");

        // Add action listener to button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button Clicked!");
            }
        });

        // Add components to panel
        panel.add(label);
        panel.add(button);

        // Add panel to frame
        frame.add(panel);

        // Frame settings
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null); // Center window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
