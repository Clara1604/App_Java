import javax.swing.*;

public class ConsulterPage extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField textFieldID;
    private JTextField textFieldDate;
    private JTextField textFieldLieu;
    private JTextField textFieldContenu;
    private JButton Modifier;
    private JButton Supprimer;


    public ConsulterPage() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        textFieldID.setEditable(false);
        textFieldDate.setEditable(false);
        textFieldContenu.setEditable(false);
    }

    public JTextField getTextFieldID() {
        return textFieldID;
    }

    public void setTextFieldID(JTextField textFieldID) {
        this.textFieldID = textFieldID;
    }

    public JTextField getTextFieldDate() {
        return textFieldDate;
    }

    public void setTextFieldDate(JTextField textFieldDate) {
        this.textFieldDate = textFieldDate;
    }

    public JTextField getTextFieldLieu() {
        return textFieldLieu;
    }

    public void setTextFieldLieu(JTextField textFieldLieu) {
        this.textFieldLieu = textFieldLieu;
    }

    public JTextField getTextFieldContenu() {
        return textFieldContenu;
    }

    public void setTextFieldContenu(JTextField textFieldContenu) {
        this.textFieldContenu = textFieldContenu;
    }

    public JButton getModifier() {
        return Modifier;
    }

    public JButton getSupprimer() {
        return Supprimer;
    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public static void main(String[] args) {
        ConsulterPage dialog = new ConsulterPage();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
