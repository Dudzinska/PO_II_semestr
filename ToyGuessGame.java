import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToyGuessGame extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel hintLabel;
    private JTextField guessField;
    private JButton checkButton;
    private JLabel scoreLabel;
    private JButton newGameButton;
    private JButton closeButton;
    
    private String[] toys = {"lalka", "samochod", "mis", "klocki", "piłka"};
    private String[] hints = {
            "Dla dzieci, często ma sukienkę",
            "Jeździ na czterech kołach",
            "Pluszwy, lubi miodek",
            "Można z nich budować",
            "Okrągła, można ją kopać"
    };

    private int currentToy = 0;
    private int score = 0;
    private int attempts = 0;

    public ToyGuessGame() {
        super("Gra - Zgadnij Zabawkę");

        initializeComponents();

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        startNewGame();
        setupListeners();
    }

    private void initializeComponents() {
        mainPanel = new JPanel();
        titleLabel = new JLabel("ZGADNIJ ZABAWKĘ!");
        hintLabel = new JLabel("Podpowiedź: ");
        guessField = new JTextField(15);
        checkButton = new JButton("SPRAWDŹ");
        scoreLabel = new JLabel("Wynik: 0/0");
        newGameButton = new JButton("NOWA GRA");
        closeButton = new JButton("ZAMKNIJ");

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        hintLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        guessField.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        guessField.setMaximumSize(new Dimension(200, 30));

        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(hintLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(guessField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(checkButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(scoreLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(newGameButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(closeButton);
    }

    private void startNewGame() {
        currentToy = 0;
        score = 0;
        attempts = 0;
        updateHint();
        updateScore();
        guessField.setText("");
        guessField.setEnabled(true);
        checkButton.setEnabled(true);
    }

    private void updateHint() {
        hintLabel.setText("Podpowiedź: " + hints[currentToy]);
    }

    private void updateScore() {
        scoreLabel.setText("Wynik: " + score + "/" + attempts);
    }

    private void setupListeners() {
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });

          closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void checkGuess() {
        String guess = guessField.getText().trim().toLowerCase();
        String correctAnswer = toys[currentToy];

        attempts++;

        if (guess.equals(correctAnswer)) {
            score++;
            JOptionPane.showMessageDialog(this,
                    "BRAWO! Zgadłeś! To: " + correctAnswer,
                    "Sukces",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Niepoprawnie! Poprawna odpowiedź to: " + correctAnswer,
                    "Spróbuj jeszcze raz",
                    JOptionPane.WARNING_MESSAGE);
        }
        currentToy++;
        if (currentToy >= toys.length) {
            currentToy = 0;
        }

        updateHint();
        updateScore();
        guessField.setText("");
        guessField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToyGuessGame().setVisible(true);
            }
        });
    }
}