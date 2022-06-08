import javax.swing.*;

public class Fentre1 extends JDialog {
    private JPanel contentPane;
    private JComboBox comboBox1;
    public JTextField textFieldDate;
    public JTextField textFieldLieu;
    private JTable table1;
    private JTextField textFieldRecherche;
    private JButton rechercherButton;
    private JTable table2;
    private JButton buttonCreer;
    private JButton buttonOK;

    public Fentre1() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonCreer.setVisible(false);
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public static void main(String[] args) {
        Fentre1 dialog = new Fentre1();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
    }

    public JTextField getTextFieldDate() {
        return textFieldDate;
    }

    public JTable getTable2() {
        return table2;
    }

    public JTextField getTextFieldLieu() {
        return textFieldLieu;
    }


    public JTextField getTextFieldRecherche() {
        return textFieldRecherche;
    }

    public void setTextFieldRecherche(JTextField textFieldRecherche) {
        this.textFieldRecherche = textFieldRecherche;
    }

    public JButton getRechercherButton() {
        return rechercherButton;
    }

    public JButton getButtonCreer() {
        return buttonCreer;
    }

    public void setButtonCreer(JButton buttonCreer) {
        this.buttonCreer = buttonCreer;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
