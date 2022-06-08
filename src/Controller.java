import Entities.Compte_Rendu;
import Entities.Visiteur;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Visiteur visiteur;
    private Fentre1 fentre1;
    DAOVisiteur daoVisiteur;
    DAOCompteRendu daoCompteRendu;
    ArrayList visiteurs;
    ArrayList visiteurs1;
    ModelVisiteur mv;
    ModelCompteRendu mcr;
    ArrayList compte_rendus;
    private ConsulterPage cp;
    private ModifierPage mp;
    private CreerPage cr;

    public Controller (Fentre1 f,DAOVisiteur daov, DAOCompteRendu daocr) throws SQLException {

        fentre1 = f;
        ModifierPage mp  = new ModifierPage();
        CreerPage cr = new CreerPage();
        daoVisiteur = daov;
        daoCompteRendu = daocr;

        List<Visiteur> visiteurs = daoVisiteur.findAll();
        ModelVisiteur md = new ModelVisiteur(visiteurs);
        fentre1.getTable1().setModel(md);

        fentre1.getTable1().addMouseListener((MouseListener) new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {



                try {
                    compte_rendus = (ArrayList) daoVisiteur.findCompteRendu(fentre1);
                    ModelCompteRendu mcr = new ModelCompteRendu(compte_rendus);
                    fentre1.getTable2().setModel(mcr);
                    fentre1.getButtonCreer().setVisible(true);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


                //fentre1.textFieldLieu.setText(compte_rendus.get(0).toString());
                // CREER colonne lieu et insert des données !!!!!!!!!!!!!!!!!



            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        fentre1.getRechercherButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {

                     visiteurs1 = (ArrayList) daoVisiteur.findbyname(fentre1.getTextFieldRecherche().getText());
                    ModelVisiteur cd = new ModelVisiteur(visiteurs1);
                    fentre1.getTable1().setModel(cd);



                }catch(Exception e){
                    System.out.println("RECHERCHER");


                }


            }
        });

        ConsulterPage cp = new ConsulterPage();

        fentre1.getTable2().addMouseListener((MouseListener) new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                int i = fentre1.getTable2().getSelectedRow();
                DefaultTableModel model =  (DefaultTableModel) fentre1.getTable2().getModel();

                cp.getTextFieldID().setText(model.getValueAt(i,0).toString());

                cp.getTextFieldDate().setText(model.getValueAt(i,1).toString());

                cp.getTextFieldLieu().setText(model.getValueAt(i,2).toString());
                // Rajouter Lieu

                cp.getTextFieldContenu().setText(model.getValueAt(i,3).toString());
                cp.setVisible(true);
                cp.setVisible(true);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        cp.getModifier().addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int i = fentre1.getTable2().getSelectedRow();
                DefaultTableModel model =  (DefaultTableModel) fentre1.getTable2().getModel();
                mp.getTextFieldMID().setText(model.getValueAt(i,0).toString());

                mp.getTextFieldMDate().setText(model.getValueAt(i,1).toString());

                mp.getTextFieldMLieu().setText(model.getValueAt(i,2).toString());
                // Rajouter Lieu

                mp.getTextFieldMContenu().setText(model.getValueAt(i,3).toString());
                mp.setVisible(true);

            }
        });


        mp.getButtonOk().addActionListener((ActionListener) new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = JOptionPane.showConfirmDialog(null,
                            "Voulez-vous vraiment modifier ce compte-rendu","Confirm Dialog",JOptionPane.YES_NO_OPTION);
                    if(n == JOptionPane.YES_OPTION) {
                        daoCompteRendu.update(mp, cp);

                        JOptionPane.showMessageDialog(null, "Comlpte Rendu modifié avec succés !");

                        compte_rendus = (ArrayList) daoVisiteur.findCompteRendu(fentre1);
                        ModelCompteRendu mcr = new ModelCompteRendu(compte_rendus);
                        fentre1.getTable2().setModel(mcr);
                        int i = fentre1.getTable2().getSelectedRow();
                        DefaultTableModel model =  (DefaultTableModel) fentre1.getTable2().getModel();

                        cp.getTextFieldID().setText(model.getValueAt(i,0).toString());

                        cp.getTextFieldDate().setText(model.getValueAt(i,1).toString());

                        cp.getTextFieldLieu().setText(model.getValueAt(i,2).toString());
                        // Rajouter Lieu

                        cp.getTextFieldContenu().setText(model.getValueAt(i,3).toString());
                        mp.setVisible(false);
                        cp.setVisible(false);

                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });

        cp.getSupprimer().addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int n = JOptionPane.showConfirmDialog(null,
                        "Voulez-vous vraiment supprimer ce compte-rendu", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    try {
                        daoCompteRendu.delete(cp);
                        JOptionPane.showMessageDialog(null, "Comlpte Rendu supprimé avec succés !");
                        compte_rendus = (ArrayList) daoVisiteur.findCompteRendu(fentre1);
                        ModelCompteRendu mcr = new ModelCompteRendu(compte_rendus);
                        fentre1.getTable2().setModel(mcr);
                        int i = fentre1.getTable2().getSelectedRow();
                        DefaultTableModel model =  (DefaultTableModel) fentre1.getTable2().getModel();

                        cp.getTextFieldID().setText(model.getValueAt(i,0).toString());

                        cp.getTextFieldDate().setText(model.getValueAt(i,1).toString());

                        cp.getTextFieldLieu().setText(model.getValueAt(i,2).toString());
                        // Rajouter Lieu

                        cp.getTextFieldContenu().setText(model.getValueAt(i,3).toString());

                        cp.setVisible(false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });

        fentre1.getButtonCreer().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                cr.setVisible(true);
            }
            });

        cr.getButtonOK().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {

                    int i = fentre1.getTable1().getSelectedRow();
                    DefaultTableModel model =  (DefaultTableModel) fentre1.getTable1().getModel();

                    String v = model.getValueAt(i,0).toString();

                    daocr.save(f,cr,v );

                    JOptionPane.showMessageDialog(null, "Comlpte Rendu ajouté avec succés !");


                }catch(Exception e){
                    System.out.println("RECHERCHER");


                }


            }
        });

    }



}
