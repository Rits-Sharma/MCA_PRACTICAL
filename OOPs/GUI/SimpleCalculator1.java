import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator1 extends JFrame implements ActionListener {
    private JTextField display;  //JTextField is a Swing component that displays a single line of editable text.
    private String currentInput = "";
    private double result = 0;
    private String lastOperator = "=";

    public SimpleCalculator1() {
        // Set up the frame
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Common close operations:
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // Exit application
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   // Close only this window
        //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);      // Just hide window
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// Do nothing (handle manually)


        setSize(300, 400);
        setLayout(new BorderLayout());

        // Create display
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setBackground(new Color(255, 192, 203));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 4, 4));

        // Button labels
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        // Create buttons and add to panel
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        // Create close button panel
        JPanel closePanel = new JPanel();
        closePanel.setLayout(new FlowLayout()); //FlowLayout, which arranges components in a left-to-right flow, similar to words in a paragraph.
        closePanel.setBackground(new Color(255, 100, 200));

         // Create close button panel
        JPanel closePanel1 = new JPanel();
        closePanel1.setLayout(new FlowLayout()); //FlowLayout, which arranges components in a left-to-right flow, similar to words in a paragraph.
        closePanel1.setBackground(new Color(200, 100, 200));


        JButton closeButton = new JButton("Close Calculator");
        closeButton.setFont(new Font("Arial", Font.BOLD, 16));
        closeButton.setBackground(new Color(255, 200, 100));
        closeButton.setForeground(Color.WHITE);
        closeButton.setPreferredSize(new Dimension(200, 40));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the application
                System.exit(0);
            }
        });

        closePanel.add(closeButton);
        add(closePanel, BorderLayout.SOUTH);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789".contains(command)) {
            // Number button pressed
            currentInput += command;
            display.setText(currentInput);
        }
        else if (command.equals("C")) {
            // Clear button
            currentInput = "";
            result = 0;
            lastOperator = "=";
            display.setText("");
        }
        else if (command.equals("=")) {
            // Equals button - calculate result
            calculate();
            display.setText(String.valueOf(result));
            currentInput = "";
        }
        else {
            // Operator button (+, -, *, /)
            if (!currentInput.isEmpty()) {
                calculate();
                display.setText(String.valueOf(result));
            }
            lastOperator = command;
            currentInput = "";
        }
    }

    private void calculate() {
        if (currentInput.isEmpty()) return;

        double inputValue = Double.parseDouble(currentInput);

        switch (lastOperator) {
            case "+":
                result += inputValue;
                break;
            case "-":
                result -= inputValue;
                break;
            case "*":
                result *= inputValue;
                break;
            case "/":
                if (inputValue != 0) {
                    result /= inputValue;
                } else {
                    display.setText("Error");
                    currentInput = "";
                    result = 0;
                    lastOperator = "=";
                    return;
                }
                break;
            case "=":
                result = inputValue;
                break;
        }
    }

    public static void main(String[] args) {
        // Run the calculator using SwingUtilities.invokeLater
        // This ensures the GUI runs on the Event Dispatch Thread (EDT)

        // Expanded version of: SwingUtilities.invokeLater(() -> new SimpleCalculator());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create an instance of SimpleCalculator
                SimpleCalculator1 calculator = new SimpleCalculator1();

                // Additional setup if needed:
                // calculator.setLocationRelativeTo(null); // Center on screen
                // calculator.setResizable(false); // Make non-resizable
            }
        });
    }
}
