import Entities.Compte_Rendu;
import Entities.Visiteur;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOVisiteur<compte_rendus> {

    private Connection con;

    public DAOVisiteur(Connection con) {
        this.con=con;
    }

    public List<Visiteur> findAll() throws SQLException {
        String SQL = "Select * from VISITEUR";
        PreparedStatement ps = con.prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();

        List<Visiteur> visiteurs = new ArrayList<Visiteur>();
        Visiteur v = null;
        while(rs.next()) {
            v = new Visiteur();
            v.setIDVisiteur(rs.getInt(1)).setPrénom(rs.getString(2)).setNom(rs.getString(3)).setMail(rs.getString(4)).setTelephone(rs.getString(5));
            visiteurs.add(v);
        }


        return visiteurs;
    }



    public List<Visiteur> findbyname(String texteRecherche) throws SQLException {
        String SQL = "Select * from VISITEUR where Nom LIKE '" + texteRecherche + "%' or Prénom LIKE '" + texteRecherche + "%'";
        PreparedStatement ps = con.prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();


        List<Visiteur> visiteurs = new ArrayList<Visiteur>();
        Visiteur v = null;
        while(rs.next()) {
            v = new Visiteur();
            v.setIDVisiteur(rs.getInt(1)).setPrénom(rs.getString(2)).setNom(rs.getString(3)).setMail(rs.getString(4)).setTelephone(rs.getString(5));
            visiteurs.add(v);
        }

        return visiteurs;
    }

    public List<Compte_Rendu> findCompteRendu(Fentre1 f) throws SQLException {
        int i = f.getTable1().getSelectedRow();
        DefaultTableModel model =  (DefaultTableModel) f.getTable1().getModel();
        String SQL = "Select * from COMPTE_RENDU where IDVisiteur = ?";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setString(1, model.getValueAt(i,0).toString());

        ResultSet rs = ps.executeQuery();

        List<Compte_Rendu> compte_rendus = new ArrayList<Compte_Rendu>();
        Compte_Rendu cr = null;
        while(rs.next()) {

                cr = new Compte_Rendu();
                cr.setNumCR(rs.getInt(1)).setNumVisite(rs.getInt(2)).setContenu(rs.getString(3)).setDate(rs.getDate(4)).setIDVisiteur(rs.getInt(5)).setLieu(rs.getString(6));
                compte_rendus.add(cr);
            }
        return compte_rendus;
    }


}
