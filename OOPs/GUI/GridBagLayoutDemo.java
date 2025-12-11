import javax.swing.*;
import java.awt.Container;
import java.awt.GridBagLayout; // Added import
import java.awt.GridBagConstraints; // Added import
import java.awt.Insets; // Added import

public class GridBagLayoutDemo {
        public static void main(String[] args) {
                SwingUtilities.invokeLater(GridBagLayoutDemo::run);
        }

        private static void run() {
                JFrame frame = new JFrame("GridBagLayout demo");
                frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                Container cp = frame.getContentPane();
                cp.setLayout(new GridBagLayout());

                cp.add(new JButton("1"), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                new Insets(0, 0, 0, 0), 0, 0));

                cp.add(new JButton("2"), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                new Insets(0, 0, 0, 0), 0, 0));

                cp.add(new JButton("3"), new GridBagConstraints(2, 0, 1, 1, 1.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                new Insets(0, 0, 0, 0), 0, 0));

                cp.add(new JButton("4"), new GridBagConstraints(3, 0, 1, 1, 1.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                new Insets(0, 0, 0, 0), 0, 0));

                cp.add(new JButton("Center"), new GridBagConstraints(0, 1, 4, 1, 1, 1,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(10, 10, 10, 10), 0, 0));

                cp.add(new JButton("A"), new GridBagConstraints(0, 2, 2, 1, 1.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                                new Insets(0, 0, 0, 0), 0, 0));

                cp.add(new JButton("B"), new GridBagConstraints(2, 2, 2, 1, 1.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                                new Insets(0, 0, 0, 0), 0, 0));

                frame.setSize(500, 300);
                frame.setVisible(true);
        }
}
