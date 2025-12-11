import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private String currentInput = "";
    private double result = 0;
    private String lastOperator = "=";

    public SimpleCalculator() {
        // Set up the frame
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Create display
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

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
        // Run the calculator
        SwingUtilities.invokeLater(() -> new SimpleCalculator());
    }
}
