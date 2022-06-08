import javax.swing.table.DefaultTableModel;

import java.util.HashSet;
import java.util.List;
import Entities.*;

public class ModelCompteRendu extends DefaultTableModel{

    List<Compte_Rendu> liste;
    String[] colNames = {"ID", "Date", "Lieu", "Contenu"};
    HashSet<Compte_Rendu> modified = new HashSet<>();


    public HashSet<Compte_Rendu> getModified() {
        return modified;
    }

    public void setModified(HashSet<Compte_Rendu> modified) {
        this.modified = modified;
    }

    public ModelCompteRendu(List<Entities.Compte_Rendu> compte_rendus) {
        liste = compte_rendus;
    }

    @Override
    public int getRowCount() {
        return liste == null ? 0 : liste.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    } // Mettre 3 apres LIEU creer

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return (column !=0);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object value =null;
        Compte_Rendu cr = liste.get(row);
        switch (column) {
            case 0 :
                value = cr.getNumCR();
                break;
            case 1 :
                value = cr.getDate();
                break;
            case 2 :
                value = cr.getLieu();
                break;
            case 3 :
                value = cr.getContenu();
                break;

        }

        return value;


    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        // TODO Auto-generated method stub
        Compte_Rendu cr = liste.get(row);

        modified.add(cr);
    }

    @Override
    public Class getColumnClass(int column)
    {
        for (int row = 0; row < getRowCount(); row++)
        {
            Object o = getValueAt(row, column);

            if (o != null)
            {
                return o.getClass();
            }
        }

        return Object.class;
    }
}
