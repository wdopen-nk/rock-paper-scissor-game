import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorGUI extends JFrame {
    // player buttons
    JButton rockButton, paperButton, scissorButton;

    JLabel computerChoice;

    public RockPaperScissorGUI() {
        // invoke JFrame constructor and add title to GUI
        super("Rock, Paper, and Scissor");

        // set the size of GUI
        setSize(450, 574);

        // set layout to null to disable the layout management
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // load GUI in the middle of the screen everytime we run the application
        setLocationRelativeTo(null);

        // add GUI components
        addGUIComponents();
    }

    private void addGUIComponents() {
        // create score table
        JLabel scoreTable = new JLabel("Computer: 0");

        // set x, y coordinates and width/height, font size & text placement
        scoreTable.setBounds(0, 43, 450, 30);
        scoreTable.setFont(new Font("Dialog", Font.BOLD, 26));
        scoreTable.setHorizontalAlignment(SwingConstants.CENTER);

        // add to GUI
        add(scoreTable);

        // create computer choice;
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175, 118, 98, 81);
        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        // create a black border
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        // create player score table
        JLabel playerScoreTable = new JLabel("Player: 0");
        playerScoreTable.setBounds(0, 317, 450, 30);
        playerScoreTable.setFont(new Font("Dialog", Font.BOLD, 26));
        playerScoreTable.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreTable);

        // rock button
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 387, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(rockButton);

        // paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165, 387, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(paperButton);

        // scissor button
        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(285, 387, 105, 81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(scissorButton);
    }

    private void showDialog(String message) {
        JDialog resultDialog = new JDialog(this, "Result", true);
        resultDialog.setSize(227, 124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        // message label
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        // try again button
        JButton tryAgainButton = new JButton("Try Again?");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // reset computer choice
                computerChoice.setText("?");

                // close the dialog box
                resultDialog.dispose();
            }
        });

        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }
}