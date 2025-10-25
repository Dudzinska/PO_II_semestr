    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    public class TemperatureConverterForm {
            private JLabel Celsjusza;
        private JFormattedTextField celsiusField;
        private JLabel Fahrenheita;
        private JTextField fahrenheitField;
        private JButton konwertujButton;
        private JButton clearButton;
            private JPanel mainPanel;

            public TemperatureConverterForm() {

            konwertujButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    convertTemperature();
                }
            });

                clearButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearFields();
                    }
                });
            }

        private void convertTemperature() {
            try {
                double celsius = Double.parseDouble(celsiusField.getText());
                double fahrenheit = (celsius * 9/5) + 32;
                fahrenheitField.setText(String.format("%.2f", fahrenheit));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel,
                        "Proszę wpisać prawidłową liczbę!",
                        "Błąd",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        private void clearFields() {
            celsiusField.setText("");
            fahrenheitField.setText("");
        }

        public JPanel getMainPanel() {
            return mainPanel;
        }
    }

