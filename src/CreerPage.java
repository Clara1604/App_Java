import javax.swing.*;

public class CreerPage extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldNumCR;
    private JTextField textFieldNuméroVisite;
    private JTextField textFieldContenu;
    private JTextField textFieldCDate;
    private JTextField textFieldCLieu;

    public CreerPage() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        CreerPage dialog = new CreerPage();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public JTextField getTextFieldCLieu() {
        return textFieldCLieu;
    }

    public JTextField getTextFieldCDate() {
        return textFieldCDate;
    }

    public JTextField getTextFieldNuméroVisite() {
        return textFieldNuméroVisite;
    }

    public JTextField getTextFieldContenu() {
        return textFieldContenu;
    }

    public JTextField getTextFieldNumCR() {
        return textFieldNumCR;
    }

    public JButton getButtonOK() {
        return buttonOK;
    }
}
