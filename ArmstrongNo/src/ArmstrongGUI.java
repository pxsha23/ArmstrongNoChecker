
//PLAIN GUI

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ArmstrongGUI extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;

    public ArmstrongGUI() {
        setTitle("Armstrong Number Checker");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        JLabel titleLabel = new JLabel("Enter a number to check if it's an Armstrong number:");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        inputField = new JTextField();
        JButton checkButton = new JButton("Check");
        resultLabel = new JLabel("", SwingConstants.CENTER);

        checkButton.addActionListener(this::handleCheck);

        add(titleLabel);
        add(inputField);
        add(checkButton);
        add(resultLabel);

        setVisible(true);
    }

    private void handleCheck(ActionEvent e) {
        String input = inputField.getText();

        if (!InputValidator.isNumeric(input)) {
            resultLabel.setText("❌ Please enter a valid positive integer.");
            return;
        }

        int number = Integer.parseInt(input);
        boolean isArmstrong = ArmstrongChecker.isArmstrong(number);

        if (isArmstrong) {
            resultLabel.setText("✅ " + number + " is an Armstrong number.");
        } else {
            resultLabel.setText("❌ " + number + " is NOT an Armstrong number.");
        }
    }
}


