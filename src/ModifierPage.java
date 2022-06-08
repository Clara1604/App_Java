import javax.swing.*;
import java.awt.event.*;

public class ModifierPage extends JDialog {
    private JPanel contentPane;
    private JButton buttonOk;
    private JButton buttonCancel;
    private JTextField textFieldMID;
    private JTextField textFieldMDate;
    private JTextField textFieldMLieu;
    private JTextField textFieldMContenu;

    public ModifierPage() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOk);



        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ModifierPage dialog = new ModifierPage();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public JTextField getTextFieldMID() {
        return textFieldMID;
    }

    public void setTextFieldMID(JTextField textFieldMID) {
        this.textFieldMID = textFieldMID;
    }

    public JTextField getTextFieldMDate() {
        return textFieldMDate;
    }

    public void setTextFieldMDate(JTextField textFieldMDate) {
        this.textFieldMDate = textFieldMDate;
    }

    public JTextField getTextFieldMLieu() {
        return textFieldMLieu;
    }

    public void setTextFieldMLieu(JTextField textFieldMLieu) {
        this.textFieldMLieu = textFieldMLieu;
    }

    public JTextField getTextFieldMContenu() {
        return textFieldMContenu;
    }

    public JButton getButtonOk() {
        return buttonOk;
    }

    public void setButtonOK(JButton buttonOK) {
        this.buttonOk = buttonOK;
    }

    public void setTextFieldMContenu(JTextField textFieldMContenu) {
        this.textFieldMContenu = textFieldMContenu;
    }
}
