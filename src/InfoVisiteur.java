import javax.swing.*;
import java.awt.event.*;

public class InfoVisiteur extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldInfoTelephone;
    private JTextField textFieldInfoMail;
    private JTextField textFieldInfoPrenom;
    private JTextField textFieldInfoNom;
    private JTextField textFieldInfoID;

    public InfoVisiteur() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

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
        InfoVisiteur dialog = new InfoVisiteur();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


    public JTextField getTextFieldInfoID() {
        return textFieldInfoID;
    }

    public void setTextFieldInfoID(JTextField textFieldInfoID) {
        this.textFieldInfoID = textFieldInfoID;
    }

    public JTextField getTextFieldInfoNom() {
        return textFieldInfoNom;
    }

    public void setTextFieldInfoNom(JTextField textFieldInfoNom) {
        this.textFieldInfoNom = textFieldInfoNom;
    }

    public JTextField getTextFieldInfoPrenom() {
        return textFieldInfoPrenom;
    }

    public void setTextFieldInfoPrenom(JTextField textFieldInfoPrenom) {
        this.textFieldInfoPrenom = textFieldInfoPrenom;
    }

    public JTextField getTextFieldInfoMail() {
        return textFieldInfoMail;
    }

    public void setTextFieldInfoMail(JTextField textFieldInfoMail) {
        this.textFieldInfoMail = textFieldInfoMail;
    }

    public JTextField getTextFieldInfoTelephone() {
        return textFieldInfoTelephone;
    }

    public void setTextFieldInfoTelephone(JTextField textFieldInfoTelephone) {
        this.textFieldInfoTelephone = textFieldInfoTelephone;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
