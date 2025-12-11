import javax.swing.*;
import java.awt.Container;
import java.awt.BorderLayout;
// ... rest of the code

public class BorderLayoutDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BorderLayoutDemo::run);
    }

    private static void run() {
        JFrame frame = new JFrame("BorderLayout demo");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(new JButton("North"), BorderLayout.NORTH);
        cp.add(new JButton("South"), BorderLayout.SOUTH);
        cp.add(new JButton("East"), BorderLayout.EAST);
        cp.add(new JButton("West"), BorderLayout.WEST);
        cp.add(new JButton("Center"), BorderLayout.CENTER);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}
