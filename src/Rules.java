import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {
    String name;
    JButton back, start;

    Rules(String name) {
        this.name = name;

        setTitle("MCQ Exam Rules");
        setSize(900, 600);
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(mainPanel);

        // Heading
        JLabel heading = new JLabel("Welcome " + name + " to QuizBee", SwingConstants.CENTER);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 32));
        heading.setForeground(new Color(30, 30, 60));
        mainPanel.add(heading, BorderLayout.NORTH);

        // Rules Text (in a scrollable panel)
        String ruleText = """
                <html><div style='font-size:14px;'>
                <b>Exam Rules:</b><br><br>
                1. <b>There are total 30 questions each question has only one correct answer with 1 marks each.</b> Carefully read all the options before selecting your answer.<br><br>
                2. <b>Negative marking of 0.25.</b> 0.25 Marks will be deducted for wrong answers.<br><br>
                3. <b>Use of unfair means is strictly prohibited.</b> Any form of cheating will result in disqualification.<br><br>
                4. <b>Do not refresh or close the exam window.</b> It may lead to auto-submission or loss of progress.<br><br>
                5. <b>You are not allowed to revisit previous questions (if restricted).</b> Follow the navigation rules.<br><br>
                6. <b>Time is limited to  60sec for each question.</b> Manage it wisely—unanswered questions won't be reconsidered.<br><br>
                7. <b>Make sure to submit before the time ends.</b> Auto-submission is not guaranteed.<br><br>
                8. <b>Technical issues must be reported immediately.</b> Inform the invigilator or exam supervisor without delay.<br>
                </div></html>
                """;

        JLabel rulesLabel = new JLabel(ruleText);
        rulesLabel.setVerticalAlignment(JLabel.TOP);
        rulesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane(rulesLabel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        back = new JButton("Back");
        start = new JButton("Start");

        styleButton(back);
        styleButton(start);

        back.addActionListener(this);
        start.addActionListener(this);

        buttonPanel.add(back);
        buttonPanel.add(start);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Custom button styling
    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(120, 40));
        button.setFont(new Font("Tahoma", Font.BOLD, 16));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setContentAreaFilled(true);
                button.setBackground(new Color(240, 240, 240));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setContentAreaFilled(false);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name); // Uncomment when implemented
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login(); // Ensure Login class exists
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
