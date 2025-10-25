import javax.swing.*;

class TemperatureConverterApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konwerter Temperatury");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        TemperatureConverterForm form = new TemperatureConverterForm();
        frame.add(form.getMainPanel());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}