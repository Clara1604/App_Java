import java.sql.SQLException;
import java.sql.Connection;

/**
 * @author 33662
 *
 */
public class App {

    public static void main(String[] args) throws ClassNotFoundException {



        try {

            DAOVisiteur daov = new DAOVisiteur(Singleton.getInstance().con);
            DAOCompteRendu daocr = new DAOCompteRendu(Singleton.getInstance().con);
            //DAOConnection daocx = new DAOConnection(Singleton.getInstance().con);
            Fentre1 f = new Fentre1();
            //Connexion co = new Connexion();
            Controller c = new Controller(f, daov, daocr);
            f.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

}
