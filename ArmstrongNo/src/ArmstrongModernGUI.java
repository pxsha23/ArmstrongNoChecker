import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ArmstrongModernGUI extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;

    public ArmstrongModernGUI() {
        setTitle("Armstrong Number Checker");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //colors
        Color primaryColor = new Color(50, 90, 140);
        Color secondaryColor = new Color(245, 247, 250);
        Color cardColor = Color.WHITE;
        Color successColor = new Color(46, 204, 113);
        Color errorColor = new Color(231, 76, 60);
        Font mainFont = new Font("Segoe UI", Font.PLAIN, 16);

        // Outer Panel
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(secondaryColor);
        outerPanel.setLayout(new GridBagLayout());
        add(outerPanel);

        // Card Panel
        JPanel card = new JPanel();
        card.setBackground(cardColor);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(200, 200, 200), 1, true),
                new EmptyBorder(25, 30, 25, 30)
        ));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setPreferredSize(new Dimension(400, 250));
        outerPanel.add(card);

        // Title
        JLabel titleLabel = new JLabel("Armstrong Number Checker");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(primaryColor);

        // Input 
        inputField = new JTextField();
        inputField.setFont(mainFont);
        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        inputField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(180, 180, 180), 1, true),
                new EmptyBorder(8, 12, 8, 12)
        ));
        inputField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Button
        JButton checkButton = new JButton("Check Number");
        checkButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        checkButton.setBackground(primaryColor);
        checkButton.setForeground(Color.WHITE);
        checkButton.setFocusPainted(false);
        checkButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        checkButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkButton.addActionListener(this::handleCheck);

        // Result
        resultLabel = new JLabel(" ");
        resultLabel.setFont(mainFont);
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel.setForeground(Color.DARK_GRAY);

        // Add spacing & components
        card.add(titleLabel);
        card.add(Box.createRigidArea(new Dimension(0, 20)));
        card.add(inputField);
        card.add(Box.createRigidArea(new Dimension(0, 20)));
        card.add(checkButton);
        card.add(Box.createRigidArea(new Dimension(0, 20)));
        card.add(resultLabel);

        setVisible(true);
    }

    private void handleCheck(ActionEvent e) {
        String input = inputField.getText().trim();

        if (!InputValidator.isNumeric(input)) {
            resultLabel.setText("Please enter a valid number.");
            resultLabel.setForeground(new Color(231, 76, 60));
            return;
        }

        int number = Integer.parseInt(input);
        if (ArmstrongChecker.isArmstrong(number)) {
            resultLabel.setText(" Yes, " + number + " is an Armstrong number.");
            resultLabel.setForeground(new Color(46, 204, 113));
        } else {
            resultLabel.setText("No, " + number + " is not an Armstrong number.");
            resultLabel.setForeground(new Color(231, 76, 60));
        }
    }
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new ArmstrongModernGUI());
}
}
