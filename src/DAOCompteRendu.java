import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DAOCompteRendu {

    private Connection con;

    public DAOCompteRendu(Connection con) {
        this.con=con;
    }


    public void save(Fentre1 f, CreerPage cr, String v) throws SQLException {

        String SQL="insert COMPTE_RENDU(NumCR,NuméroVisite,Contenu, Date, IDVisiteur, Lieu) values (?,?,?,?,?,?)";

        PreparedStatement ps = (PreparedStatement) con.prepareStatement(SQL);
        String date = cr.getTextFieldCDate().getText();
        java.sql.Date date1 = java.sql.Date.valueOf(date);

        ps.setString(1, cr.getTextFieldNumCR().getText());
        ps.setString(2, cr.getTextFieldNuméroVisite().getText());
        ps.setString(3, cr.getTextFieldContenu().getText().toString());
        ps.setDate(4, date1);
        ps.setString(5, v);
        ps.setString(6, cr.getTextFieldCLieu().getText().toString());
        

        ps.executeQuery();

    }

    public void update(ModifierPage mp, ConsulterPage  cp) throws SQLException {

        String SQL="UPDATE COMPTE_RENDU SET   Contenu = ?, Date = ?, Lieu = ? where NumCR=?";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(SQL);


        ps.setString(1, mp.getTextFieldMContenu().getText().toString());
        ps.setString(2, mp.getTextFieldMDate().getText().toString());
        ps.setString(3, mp.getTextFieldMLieu().getText().toString());
        ps.setString(4, cp.getTextFieldID().getText().toString());

        ps.executeQuery();
    }

    public void delete(ConsulterPage cp) throws SQLException {

        String SQL="DELETE FROM COMPTE_RENDU WHERE NumCR = ?";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setString(1, cp.getTextFieldID().getText().toString());

        ps.executeQuery();

    }
}
